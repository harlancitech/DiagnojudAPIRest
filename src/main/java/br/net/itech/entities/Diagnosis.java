package br.net.itech.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.net.itech.enuns.DiagnosticStatus;

@Entity
@Table(name = "diagnostics")
public class Diagnosis implements Serializable {
	private static final long serialVersionUID = -3130246109561030177L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private DiagnosticStatus diagnosticStatus;

	@Column(name = "date_diagnosis")
	private Date dateDiagnosis;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "update_date")
	private Date updateDate;

	@PrePersist
	public void prePersist() {
		final Date currentDate = new Date();
		creationDate = currentDate;
		updateDate = currentDate;
	}

	@PreUpdate
	public void preUpdate() {
		final Date currentDate = new Date();
		updateDate = currentDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DiagnosticStatus getDiagnosticStatus() {
		return diagnosticStatus;
	}

	public void setDiagnosticStatus(DiagnosticStatus diagnosticStatus) {
		this.diagnosticStatus = diagnosticStatus;
	}

	public Date getDateDiagnosis() {
		return dateDiagnosis;
	}

	public void setDateDiagnosis(Date dateDiagnosis) {
		this.dateDiagnosis = dateDiagnosis;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnosis other = (Diagnosis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diagnosis [id=" + id + ", description=" + description + ", diagnosticStatus=" + diagnosticStatus
				+ ", dateDiagnosis=" + dateDiagnosis + ", creationDate=" + creationDate + ", updateDate=" + updateDate
				+ "]";
	}
}