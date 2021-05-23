package antenatal.services;

import java.util.List;

import antenatal.dao.domain.PatientDao;
import antenatal.models.PatientModel;

public class PatientService{

	PatientDao dao;
	
	public PatientService() {
		this.dao = new PatientDao(); 
	}
	
	public void addItem(long patientId, String firstName, String lastName,
			String address, int age, char gender, long clinicId, long OPNumber, long NHISNumber) {
		PatientModel pm = new PatientModel(patientId, firstName, lastName, address, age, gender, clinicId, OPNumber, NHISNumber);
		dao.add(pm.getPatientId(), pm);
	}
	

	public PatientModel getItem(long patientId) {
		return dao.find(patientId);
	}
	
	
}