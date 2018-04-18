package br.net.itech.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.itech.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	/**
	 * Find Diagnosis by Id
	 * 
	 * @param Id
	 * @return Optional<Address>
	 */
	Optional<City> findById(Integer id);
}