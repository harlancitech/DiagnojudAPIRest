package br.net.itech.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.hibernate.service.internal.ProvidedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.itech.dtos.PeopleDto;
import br.net.itech.dtos.PeopleRegistrationDto;
import br.net.itech.entities.Address;
import br.net.itech.entities.City;
import br.net.itech.entities.People;
import br.net.itech.entities.Province;
import br.net.itech.enums.ProfileTypes;
import br.net.itech.factories.dtos.PeopleDtoFactory;
import br.net.itech.factories.entities.AddressFactory;
import br.net.itech.factories.entities.CityFactory;
import br.net.itech.factories.entities.PeopleRegistrationFactory;
import br.net.itech.factories.entities.ProvinceFactory;
import br.net.itech.response.Response;
import br.net.itech.services.AddressService;
import br.net.itech.services.CityService;
import br.net.itech.services.PeopleService;
import br.net.itech.services.ProvinceService;

@RestController
@RequestMapping(value = "/api/people-registration")
public class PeopleRegistrationController {// implements Create<PeopleRegistrationDto> {
	@Autowired
	PeopleService peopleService;

	@Autowired
	ProvinceService provinceService;

	@Autowired
	ProvinceFactory provinceFactory;

	@Autowired
	CityService cityService;

	@Autowired
	CityFactory cityFactory;

	@Autowired
	AddressService addressService;

	@Autowired
	AddressFactory addressFactory;

	@Autowired
	PeopleDtoFactory peopleDtoFactory;

	@Autowired
	PeopleRegistrationFactory peopleRegistrationFactory;

	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleRegistrationController.class);

	@PostMapping
	public ResponseEntity<Response<PeopleDto>> create(@Valid @RequestBody PeopleRegistrationDto objectDto,
			BindingResult bindingResult) throws NoSuchAlgorithmException {
		LOGGER.info("Recebendo pessoa: {}", objectDto);
		Response<PeopleDto> response = new Response<PeopleDto>();
		validate(objectDto, bindingResult);
		if (bindingResult.hasErrors()) {
			LOGGER.info("Erro ao validar cadastro de pessoa: {}", bindingResult.getAllErrors());
			bindingResult.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		Province province = provinceService
				.create(provinceFactory.getProvince(objectDto.getAddress().getCity().getProvince()));
		City city = cityFactory.getCity(objectDto.getAddress().getCity());
		city.setProvince(province);
		city = cityService.create(city);
		Address address = addressFactory.getAddress(objectDto.getAddress());
		address.setCity(city);
		address = addressService.create(address);
		People people = peopleRegistrationFactory.getPeople(objectDto);
		people.setAddress(address);
		people.setProfileType(ProfileTypes.CLIENT);
		people = peopleService.create(people);
		response.setData(peopleDtoFactory.getPeopleDto(people));
		return ResponseEntity.ok(response);
	}

	private void validate(PeopleRegistrationDto peopleRegistrationDto, BindingResult bindingResult) {
		peopleService.findByCpf(peopleRegistrationDto.getCpf())
				.ifPresent(people -> bindingResult.addError(new ObjectError("People", "CPF já cadastrado.")));
		peopleService.findByEmail(peopleRegistrationDto.getEmail())
				.ifPresent(people -> bindingResult.addError(new ObjectError("People", "Email já cadastrado.")));
	}
}