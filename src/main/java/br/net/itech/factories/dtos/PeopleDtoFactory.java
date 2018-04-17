package br.net.itech.factories.dtos;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.PeopleDto;
import br.net.itech.entities.People;

@Component
public class PeopleDtoFactory {
	public PeopleDto getPeopleDto(People people) {
		PeopleDto peopleDto = new PeopleDto();
		peopleDto.setId(String.valueOf(people.getId()));
		peopleDto.setEmail(people.getEmail());
		peopleDto.setName(people.getName());
		peopleDto.setCpf(people.getCpf());
		peopleDto.setRg(people.getRg());
		peopleDto.setRegistry(String.valueOf(people.getRegistry()));
		peopleDto.setProfile(people.getProfileType().toString());
		return peopleDto;
	}
}
