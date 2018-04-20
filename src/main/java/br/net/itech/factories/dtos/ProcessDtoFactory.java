package br.net.itech.factories.dtos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.itech.dtos.ProcessDto;
import br.net.itech.entities.Process;

@Component
public class ProcessDtoFactory {
	@Autowired
	ProcessDto processDto;

	@Autowired
	JusticeSecretDtoFactory justiceSecretDtoFactory;

	/**
	 * Converts an entity to object DTO.
	 * 
	 * @param Process
	 * @return ProcessDto
	 */
	public ProcessDto getProcessDto(Process process) {
		processDto.setId(Optional.ofNullable(String.valueOf(process.getId())));
		processDto.setPeopleId(String.valueOf(process.getPeople().getId()));
		processDto.setTitle(process.getTitle());
		processDto.setDescription(process.getDescription());
		processDto.setCourt(process.getCourt());
		processDto.setJusticeType(String.valueOf(process.getJusticeType()));
		processDto.setProcessNumber(process.getProcessNumber());
		processDto.setWithAttorney(String.valueOf(process.getWithAttorney()));
		if (process.getWithAttorney())
			processDto.setOabAttorney(Optional.ofNullable(process.getOabAttorney()));
		processDto.setConfidentialProcess(String.valueOf(process.getConfidentialProcess()));
		if (process.getConfidentialProcess())
			processDto.setJusticeSecret(Optional.ofNullable(
					justiceSecretDtoFactory.getJusticeSecretDto(process.getJusticeSecret()).getJusticeSecret()));
		return processDto;
	}
}