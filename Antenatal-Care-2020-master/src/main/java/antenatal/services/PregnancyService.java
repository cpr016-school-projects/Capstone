package antenatal.services;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import antenatal.dao.domain.PregnancyDao;
import antenatal.models.Pregnancy;

public class PregnancyService implements GenericService<Pregnancy> {
	
	PregnancyDao pregnancyDao;
	
	public PregnancyService() {
		this.pregnancyDao = new PregnancyDao();
	}
	
	public void addItem(Pregnancy p) {
		pregnancyDao.add(p);
	}
	
	public Pregnancy findItem(String pregnancyId) {
		return pregnancyDao.find(pregnancyId);
	}
	
	public void remove(String pregnancyId) {
		pregnancyDao.remove(pregnancyId);
	}
	
	public void updateItem(Pregnancy p) {
		pregnancyDao.update(p);
	}
	
	public List<Pregnancy> getAll(){
		return pregnancyDao.list();
	}
	
	// get all pregnancies by patient id
	public List<Pregnancy> getAllPatientPregnancy(String patientId){
		List<Pregnancy> allPregnancy = this.getAll();
		List<Pregnancy> result = new ArrayList<Pregnancy>();
		ListIterator<Pregnancy> iter = allPregnancy.listIterator();
		
		Pregnancy p;
		
		while(iter.hasNext()) {
			p = iter.next();
			if(p.getPatientId().equals(patientId)) {
				result.add(p);
			}
		}
		
		return result;
	}
	
	// get active pregnancies by patientid 
	public Pregnancy getActivePatientPregnancy(String patientId){
		List<Pregnancy> allPatientPregnancy = this.getAllPatientPregnancy(patientId);
		ListIterator<Pregnancy> iter = allPatientPregnancy.listIterator();
		Pregnancy p;
		
		while(iter.hasNext()) {
			p = iter.next();
			if(p.getActive()) {
				return p;
			}
		}
		return null;
	}
	
}