package br.net.itech.factories.entities;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.PeopleRegistrationDto;
import br.net.itech.entities.People;

@Component
public class PeopleRegistrationFactory {
	public People getPeople(PeopleRegistrationDto peopleRegistrationDto) {
		People people = new People();
		people.setEmail(peopleRegistrationDto.getEmail());
		people.setCpf(peopleRegistrationDto.getCpf());
		people.setName(peopleRegistrationDto.getName());
		people.setRg(peopleRegistrationDto.getRg());
		return people;
	}
}