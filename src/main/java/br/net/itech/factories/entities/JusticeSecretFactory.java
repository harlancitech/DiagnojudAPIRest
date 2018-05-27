package br.net.itech.factories.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.itech.dtos.JusticeSecretDto;
import br.net.itech.entities.JusticeSecret;

@Component
public class JusticeSecretFactory {
	@Autowired
	JusticeSecret justiceSecret;

	/**
	 * Converts an object DTO to entity.
	 * 
	 * @param ProcessDto
	 * @return Process
	 */
	public JusticeSecret getJusticeSecret(JusticeSecretDto justiceSecretDto) {
		if (justiceSecretDto.getId().isPresent())
			justiceSecret.setId(Integer.parseInt(justiceSecretDto.getId().get()));
		justiceSecret.setJusticeSecret(justiceSecretDto.getJusticeSecret());
		return justiceSecret;
	}
}