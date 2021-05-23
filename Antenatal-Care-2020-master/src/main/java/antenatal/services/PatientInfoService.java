package antenatal.services;

import java.util.ArrayList;
import java.util.List;

import antenatal.dao.domain.PatientInfoDao;
import antenatal.models.PatientInfoModel;

import edu.usm.cos420.consultingregister.service.search.*;
import edu.usm.cos420.consultingregister.domain.Patient;

public class PatientInfoService implements GenericService<PatientInfoModel> {
	
	PatientSearch patientSearch = new PatientSearch();
	List<Patient> matches = new ArrayList<Patient>();
	
	PatientInfoDao dao;
	
	public PatientInfoService() {
		this.dao = new PatientInfoDao();
	}

	public void addItem(PatientInfoModel entity) {
		dao.add(entity);
	}

	public PatientInfoModel findItem(String search) {
		return dao.find(search);
	}

	public List<PatientInfoModel> getAll() {
		return dao.list();
	}

	public void updateItem(PatientInfoModel entity) {
		dao.update(entity);
	}
	
	public boolean itemExists(PatientInfoModel entity) {
		return findItem(entity.getPatientId()) != null;
	}

}
