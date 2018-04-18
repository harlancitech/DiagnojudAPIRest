package br.net.itech.factories.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.itech.dtos.AddressDto;
import br.net.itech.entities.Address;

@Component
public class AddressFactory {
	@Autowired
	CityFactory cityFactory;

	public Address getAddress(AddressDto addressDto) {
		Address address = new Address();
		address.setId(Integer.parseInt(addressDto.getId()));
		address.setStreet(addressDto.getStreet());
		address.setDistrict(addressDto.getDistrict());
		address.setNumber(addressDto.getNumber());
		address.setCity(cityFactory.getCity(addressDto.getCity()));
		return address;
	}
}