package br.net.itech.dtos;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class JusticeSecretDto {
	private Optional<String> id;

	@NotEmpty(message = "Senha sigilosa não pode ser vazia.")
	private String justiceSecret;

	public JusticeSecretDto() {
	}

	public Optional<String> getId() {
		return id;
	}

	public void setId(Optional<String> id) {
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
		return "JusticeSecretDto [id=" + id.get() + ", justiceSecret=" + justiceSecret + "]";
	}
}