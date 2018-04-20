package br.net.itech.dtos;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class JusticeSecretDto {
	private String id;

	@NotEmpty(message = "Senha sigilosa não pode ser vazia.")
	private String justiceSecret;
	
	public JusticeSecretDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJusticeSecret() {
		return justiceSecret;
	}

	public void setJusticeSecret(String justiceSecret) {
		this.justiceSecret = justiceSecret;
	}

	@Override
	public String toString() {
		return "JusticeSecretDto [id=" + id + ", justiceSecret=" + justiceSecret + "]";
	}
}