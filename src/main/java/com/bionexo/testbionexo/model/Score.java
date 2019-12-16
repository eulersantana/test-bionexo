package com.bionexo.testbionexo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Score {
	
	@JsonProperty(required = true)
	private Integer size;
	
	@JsonProperty(required = true)
	private Integer adaptationForSeniors;
	
	@JsonProperty(required = true)
	private Integer medicalEquipment;
	
	@JsonProperty(required = true)
	private Integer medecine;

	public Integer getSize() {
		return size;
	}
	

	public Score(String sizeStr, String adaptationForSeniorsStr, String medicalEquipmentStr, String medecineStr) {
		super();
		this.size = this.preProcessingScore(sizeStr);
		this.adaptationForSeniors = this.preProcessingScore(adaptationForSeniorsStr);
		this.medicalEquipment = this.preProcessingScore(medicalEquipmentStr);
		this.medecine = this.preProcessingScore(medecineStr);
	}


	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getAdaptationForSeniors() {
		return adaptationForSeniors;
	}

	public void setAdaptationForSeniors(Integer adaptationForSeniors) {
		this.adaptationForSeniors = adaptationForSeniors;
	}

	public Integer getMedicalEquipment() {
		return medicalEquipment;
	}

	public void setMedicalEquipment(Integer medicalEquipment) {
		this.medicalEquipment = medicalEquipment;
	}

	public Integer getMedecine() {
		return medecine;
	}

	public void setMedecine(Integer medecine) {
		this.medecine = medecine;
	}
	
	private Integer preProcessingScore(String sizeStr) {
		
		if (sizeStr.toUpperCase().indexOf("DESEMPENHO MUITO ACIMA") >= 0) {
			return 3;
		} else {
			if (sizeStr.toUpperCase().indexOf("DESEMPENHO ACIMA") >= 0) {
				return 2;
			}
		}
		return 1;
	}	
}
