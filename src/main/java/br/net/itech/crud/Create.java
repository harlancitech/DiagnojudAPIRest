package br.net.itech.crud;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import br.net.itech.response.Response;

public interface Create<T> {
	public ResponseEntity<Response<T>> create(@Valid @RequestBody T objectDto, BindingResult bindingResult)
			throws NoSuchAlgorithmException;
}