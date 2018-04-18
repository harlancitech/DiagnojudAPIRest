package br.net.itech.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.itech.entities.City;
import br.net.itech.repositories.CityRepository;
import br.net.itech.services.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityRepository cityRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Override
	public Optional<City> findById(Integer id) {
		LOGGER.info("Buscando Diagnosis por Id: " + id);
		return cityRepository.findById(id);
	}

	@Override
	public City create(City city) {
		LOGGER.info("Persistindo um diagnostico: {}", city);
		return cityRepository.save(city);
	}
}