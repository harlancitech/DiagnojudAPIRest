package br.net.itech.factories.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.itech.dtos.ProcessDto;
import br.net.itech.entities.People;
import br.net.itech.entities.Process;
import br.net.itech.enums.JusticeTypes;

@Component
public class ProcessFactory {
	@Autowired
	JusticeSecretFactory justiceSecretFactory;

	/**
	 * Converts an object DTO to entity.
	 * 
	 * @param ProcessDto
	 * @return Process
	 */
	public Process getProvince(ProcessDto processDto) {
		Process process = new Process();
		if (processDto.getId() != null)
			process.setId(Integer.parseInt(processDto.getId().get()));
		process.setTitle(processDto.getTitle());
		process.setDescription(processDto.getDescription());
		process.setCourt(processDto.getCourt());
		People people = new People();
		people.setId(Integer.parseInt(processDto.getPeopleId()));
		process.setPeople(people);
		process.setJusticeType(JusticeTypes.valueOf(processDto.getJusticeType()));
		process.setProcessNumber(processDto.getProcessNumber());
		process.setWithAttorney(Boolean.valueOf(processDto.getWithAttorney()));
		if (processDto.getOabAttorney().isPresent())
			process.setOabAttorney(processDto.getOabAttorney().get());
		process.setConfidentialProcess(Boolean.valueOf(processDto.getConfidentialProcess()));
		if (processDto.getJusticeSecret().isPresent())
			process.setJusticeSecret(justiceSecretFactory.getJusticeSecret(processDto.getJusticeSecret().get()));
		return process;
	}
}