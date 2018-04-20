package br.net.itech.factories.dtos;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.ProvinceDto;
import br.net.itech.entities.Province;

@Component
public class ProvinceDtoFactory {
	/**
	 * Converts an entity to object DTO.
	 * 
	 * @param Province
	 * @return ProvinceDto
	 */
	public ProvinceDto getProvinceDto(Province province) {
		ProvinceDto provinceDto = new ProvinceDto();
		if (province.getId() != null)
			provinceDto.setId(String.valueOf(province.getId()));
		provinceDto.setName(province.getName());
		if (province.getUf() != null)
			provinceDto.setUf(Optional.ofNullable(province.getUf()));
		//provinceDto
		return provinceDto;
	}
}