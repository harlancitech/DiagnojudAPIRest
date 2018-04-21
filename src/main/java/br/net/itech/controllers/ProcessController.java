package br.net.itech.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.itech.controllers.crud.Create;
import br.net.itech.dtos.ProcessDto;
import br.net.itech.response.Response;

@RestController
@RequestMapping(value = "/api/process")
public class ProcessController implements Create<ProcessDto> {
//	@Autowired
//	ProcessService

	@Override
	public ResponseEntity<Response<ProcessDto>> create(@Valid @RequestBody ProcessDto objectDto,
			BindingResult bindingResult) throws NoSuchAlgorithmException {
		
		return null;
	}

}