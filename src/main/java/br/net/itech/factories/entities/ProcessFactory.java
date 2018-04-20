package br.net.itech.factories.entities;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.ProcessDto;
import br.net.itech.entities.Process;

@Component
public class ProcessFactory {
	/**
	 * Converts an object DTO to entity.
	 * 
	 * @param ProvinceDto
	 * @return Province
	 */
	public Process getProvince(ProcessDto processDto) {
		Process process = new Process();
		if (processDto.getId() != null)
			process.setId(Integer.parseInt(processDto.getId().get()));
		process.setTitle(processDto.getTitle());
		return process;
	}
}