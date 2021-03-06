package br.net.itech.dtos;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDto {
	private String id;

	@NotEmpty(message = "Estado não pode ser vazio.")
	@Length(min = 4, max = 30, message = "Estado deve conter entre 4 a 30 caracteres.")
	private String name;

	//@Length(min = 2, max = 2, message = "UF deve conter 2 caracteres.")
	private Optional<String> uf = Optional.empty();
	
	private Optional<JusticeSecretDto> justiceSecret = Optional.empty();
	
	public ProvinceDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getUf() {
		return uf;
	}

	public void setUf(Optional<String> uf) {
		this.uf = uf;
	}

	public Optional<JusticeSecretDto> getJusticeSecret() {
		return justiceSecret;
	}

	public void setJusticeSecret(Optional<JusticeSecretDto> justiceSecret) {
		this.justiceSecret = justiceSecret;
	}

	@Override
	public String toString() {
		return "ProvinceDto [id=" + id + ", name=" + name + ", uf=" + uf + ", justiceSecret=" + justiceSecret + "]";
	}
}