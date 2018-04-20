package br.net.itech.factories.entities;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.DiagnosisDto;
import br.net.itech.entities.Diagnosis;

@Component
public class DiagnosisFactory {
	/**
	 * Converts an object DTO to entity.
	 * 
	 * @param DiagnosisDto
	 * @return Diagnosis
	 */
	public Diagnosis getDiagnosis(DiagnosisDto diagnosisDto) {
		Diagnosis diagnosis = new Diagnosis();
		if (diagnosisDto.getId() != null)
			diagnosis.setId(Integer.parseInt(diagnosisDto.getId()));
		diagnosis.setDescription(diagnosisDto.getDescription());
//		if (EnumUtils.isValidEnum(DiagnosticStatus.class, diagnosisDto.getDiagnosticStatus()))
//			diagnosis.setDiagnosticStatus(DiagnosticStatus.valueOf(diagnosisDto.getDiagnosticStatus()));
		return diagnosis;
	}
}