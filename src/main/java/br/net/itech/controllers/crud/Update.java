package br.net.itech.controllers.crud;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.net.itech.response.Response;

public interface Update<T> {
	/**
	 * Update a database record by Id.
	 * 
	 * @param id
	 * @param objectDto
	 * @param BindingResult
	 * @return ResponseEntity<Response<T>>
	 * @throws ParseException
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<T>> update(@PathVariable("id") Integer id, @Valid @RequestBody T objectDto,
			BindingResult bindingResult) throws ParseException;
}