package br.net.itech.factories.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.itech.dtos.JusticeSecretDto;
import br.net.itech.entities.JusticeSecret;

@Component
public class JusticeSecretDtoFactory {
	@Autowired
	JusticeSecretDto justiceSecretDto;

	/**
	 * Converts an entity to object DTO.
	 * 
	 * @param Province
	 * @return ProvinceDto
	 */
	public JusticeSecretDto getJusticeSecretDto(JusticeSecret justiceSecret) {
		justiceSecretDto.setId(String.valueOf(justiceSecret.getId()));
		justiceSecretDto.setJusticeSecret(justiceSecret.getJusticeSecret());
		return justiceSecretDto;
	}
}