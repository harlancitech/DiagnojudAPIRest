package br.net.itech.factories.entities;

import org.springframework.stereotype.Component;

import br.net.itech.dtos.DiagnosisDto;
import br.net.itech.entities.Diagnosis;

@Component
public class DiagnosisFactory {
	public Diagnosis getObject(DiagnosisDto diagnosisDto) {
		Diagnosis diagnosis = new Diagnosis();
		if (diagnosisDto.getId() != null)
			diagnosis.setId(Integer.parseInt(diagnosisDto.getId()));
		diagnosis.setDescription(diagnosisDto.getDescription());
		//diagnosis.setDiagnosticStatus();
		return diagnosis;
	}
}