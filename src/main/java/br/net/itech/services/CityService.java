package br.net.itech.services;

import java.util.Optional;

import br.net.itech.entities.City;

public interface CityService {
	/**
	 * Find City by Id
	 * 
	 * @param Id
	 * @return Optional<City>
	 */
	Optional<City> findById(Integer id);

	/**
	 * Create City
	 * 
	 * @param City
	 * @return City
	 */
	City create(City city);
}