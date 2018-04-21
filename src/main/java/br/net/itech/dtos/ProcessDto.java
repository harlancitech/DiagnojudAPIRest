package br.net.itech.dtos;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class ProcessDto {
	private Optional<String> id;

	@NotEmpty(message = "Id do requerente não pode ser nulo.")
	private String peopleId;

	@NotEmpty(message = "Título não pode ser vazio.")
	private String title;

	@NotEmpty(message = "Descrição não pode ser vazio.")
	private String description;

	@NotEmpty(message = "Vara não pode ser vazio.")
	private String court;

	private String justiceType;

	@NotEmpty(message = "Número do processo não pode ser vazio.")
	private String processNumber;

	@NotEmpty(message = "O processo é com advogado?.")
	private String withAttorney;

	private Optional<String> oabAttorney = Optional.empty();

	private String confidentialProcess;

	private Optional<JusticeSecretDto> justiceSecret = Optional.empty();

	public ProcessDto() {
	}

	public Optional<String> getId() {
		return id;
	}

	public void setId(Optional<String> id) {
		this.id = id;
	}

	public String getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getJusticeType() {
		return justiceType;
	}

	public void setJusticeType(String justiceType) {
		this.justiceType = justiceType;
	}

	public String getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(String processNumber) {
		this.processNumber = processNumber;
	}

	public String getWithAttorney() {
		return withAttorney;
	}

	public void setWithAttorney(String withAttorney) {
		this.withAttorney = withAttorney;
	}

	public Optional<String> getOabAttorney() {
		return oabAttorney;
	}

	public void setOabAttorney(Optional<String> oabAttorney) {
		this.oabAttorney = oabAttorney;
	}

	public String getConfidentialProcess() {
		return confidentialProcess;
	}

	public void setConfidentialProcess(String confidentialProcess) {
		this.confidentialProcess = confidentialProcess;
	}

	public Optional<JusticeSecretDto> getJusticeSecret() {
		return justiceSecret;
	}

	public void setJusticeSecret(Optional<JusticeSecretDto> justiceSecret) {
		this.justiceSecret = justiceSecret;
	}

	@Override
	public String toString() {
		return "ProcessDto [id=" + id + ", peopleId=" + peopleId + ", title=" + title + ", description=" + description
				+ ", court=" + court + ", justiceType=" + justiceType + ", processNumber=" + processNumber
				+ ", withAttorney=" + withAttorney + ", oabAttorney=" + oabAttorney + ", confidentialProcess="
				+ confidentialProcess + ", justiceSecret=" + justiceSecret + "]";
	}
}