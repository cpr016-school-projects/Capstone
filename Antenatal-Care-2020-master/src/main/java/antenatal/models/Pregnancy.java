package antenatal.models;

import java.util.UUID;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pregnancy implements Serializable {
	
	private static final long serialVersionUID = 5522377346352177150L;
	
	private String pregnancyId;
	private String patientId;
	private Integer gestation;
	private String expectedDeliveryDate;
	private Double hemoglobin0; 
	private Double hemoglobin36; 
	private boolean isActive; 
	
	public Pregnancy() {
		pregnancyId = generateId();
		isActive = true;
	}
	
	public Pregnancy(String patientId) {
		this.patientId = patientId;
		this.pregnancyId = generateId();
		this.gestation = 0;
		this.hemoglobin0 = 0.;
		this.hemoglobin36 = 0.;
		this.isActive = true;
		this.expectedDeliveryDate = "";
		
	}
	
	public String getPregnancyId() {
		return pregnancyId;
	}
	
	public void setPregnancyId(String pregnancyId) {
		this.pregnancyId = pregnancyId;
	}
	
	public String getPatientId() {
		return this.patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public Integer getGestation() {
		return this.gestation;
	}
	
	
	public void setGestation(int gestation) {
		this.gestation = gestation;
	}
	
	public Double getHemoglobin0() {
		return this.hemoglobin0;
	}
	
	public void setHemoglobin0(Double hemoglobin0) {
		this.hemoglobin0 = hemoglobin0;
	}
	
	public Double getHemoglobin36() {
		return this.hemoglobin36;
	}
	
	public void setHemoglobin36(Double hemoglobin36) {
		this.hemoglobin36 = hemoglobin36;
	}
	
	public boolean getActive() {
		return this.isActive;
	}
	
	public void setActive(boolean b) {
		this.isActive = b; 
	}
	
	public String getEDD() {
		return this.expectedDeliveryDate;
	}
	
	public void setEDD(String edd) {
		this.expectedDeliveryDate = edd;
	}
	
	private String generateId() {
        return UUID.randomUUID().toString();
    }
}