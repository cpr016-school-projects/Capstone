package antenatal.models;

import java.util.UUID;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


public class Visit implements Serializable {
	
	private static final long serialVersionUID = 5522377346352177150L;
	
	private String patientId;


	private String pregnancyId;
	private String visitId;
	private String visitDate;

	private String complaints; 
	private String remarks;
	private boolean referred;
	private double weight;
	private boolean itnInUse;
	private boolean isActive; 

	// we don't want to populate these
	private BloodPressure bloodPressure;
	private double fundalHeight;

	
	public Visit() {
		visitId = generateId();
	}
	
	public Visit(String patientId, String pregnancyId) {
		this.patientId = patientId;
		this.pregnancyId = pregnancyId;
		this.visitId = generateId();
	}
	
	public Visit(String patientId, String pregnancyId, String visitDate) {
		this.patientId = patientId;
		this.pregnancyId = pregnancyId;
		this.visitId = generateId();
		this.visitDate = visitDate;
		this.complaints = "";
		this.remarks = "";
		this.referred = false;
		this.isActive = true;
		this.bloodPressure = new BloodPressure(0, 0);
		this.weight = 0;
		this.itnInUse = false;
	}
	
	public Visit(String patientId, String pregnancyId, double weight, boolean referred, BloodPressure bloodPressure) {
		this.patientId = patientId;
		this.pregnancyId = pregnancyId;
		this.visitId = generateId();
		this.visitDate = "";
		this.complaints = "";
		this.remarks = "";
		this.bloodPressure = bloodPressure;
		this.weight = weight;
		this.referred = referred;	
	}

	/**
	 * Constructor for populating visit with previous data
	 */
	public Visit(String patientId, String pregnancyId, String visitDate, String complaints, 
		String remarks, boolean referred, double weight, boolean isActive, boolean itnInUse) {
		this.patientId = patientId;
		this.pregnancyId = pregnancyId;
		this.visitDate = visitDate;
		this.visitId = generateId();
		this.complaints = complaints;
		this.remarks = remarks;
		this.referred = referred;
		this.weight = weight;
		this.itnInUse = itnInUse;
		this.isActive = isActive;
	}
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	
	
	public String getVisitId() {
		return this.visitId;
	}
	
	public String getVisitDate() {
		return this.visitDate;
	}
	
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getPregnancyId() {
		return pregnancyId;
	}
	
	public void setPregnancyId(String pregnancyId) {
		this.pregnancyId = pregnancyId;
	}
	
	public String getComplaints(){
		return this.complaints;
	}
	
	public void addComplaint(String complaint) {
		this.complaints = complaint;
	}
	
	public String getRemarks(){
		return this.remarks;
	}
	
	public void addRemark(String remark) {
		this.remarks = remark;
	}

	public void setReferred(boolean referred) {
		this.referred = referred;
	}

	public boolean getReferred() {
		return this.referred;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}

	public BloodPressure getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(int systolic, int diastolic) {
		this.bloodPressure = new BloodPressure(systolic, diastolic);
	}
	
	public double getFundalHeight() {
		return this.fundalHeight;
	}
	
	public void setFundalHeight(double fundalHeight) {
		this.fundalHeight = fundalHeight;
	}
	
	public boolean isItnInUse() {
		return itnInUse;
	}

	public void setItnInUse(boolean itnInUse) {
		this.itnInUse = itnInUse;
	}

	private String generateId() {
        return UUID.randomUUID().toString();
    }

	public static class BloodPressure {
		private int systolicBP;
		private int diastolicBP;
		
		public BloodPressure(int systolicBP, int diastolicBP) {
			this.setSystolicBP(systolicBP);
			this.setDiastolicBP(diastolicBP);
		}

		public int getSystolicBP() {
			return systolicBP;
		}

		public void setSystolicBP(int systolicBP) {
			this.systolicBP = systolicBP;
		}

		public int getDiastolicBP() {
			return diastolicBP;
		}

		public void setDiastolicBP(int diastolicBP) {
			this.diastolicBP = diastolicBP;
		}
	}
}