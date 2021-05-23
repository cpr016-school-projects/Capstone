package antenatal.services;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import antenatal.dao.domain.VisitDao;
import antenatal.models.Visit;

public class VisitService implements GenericService<Visit> {

    VisitDao visitDao;

    public VisitService() {
        this.visitDao = new VisitDao();
    }
    
    public void addItem(Visit v) { //add a new BaseVisit to the dao
		visitDao.add(v);
    }

    public Visit findItem(String id) { //retrieve a BaseVisit based on its ID
        return visitDao.find(id);
    }

    public void remove(String id) { //remove a BaseVisit
        visitDao.remove(id);
    }

    public void updateItem(Visit updated) { //update a BaseVisit
        visitDao.update(updated);
    }
    
    public List<Visit> getAll(){
        return visitDao.list();
    }
    
    /**
     * Retrieve all visits for a given patient
     * @return list of visits tied to a single patient
     */
    public List<Visit> getAllVisitsForPatient(String patientId) {
    	List<Visit> allVisits = this.getAll();
    	List<Visit> visitsForPatient = new ArrayList<Visit>();
    	
    	for(Visit visit : allVisits) {
    		if (visit.getPatientId().equals(patientId)) {
    			visitsForPatient.add(visit);
    		}
    	}
    	
    	return visitsForPatient;
    }

    /**
     * Retrieve most recent visit
     * @return last visit, or new visit if null
     */
    public Visit getLastVisit(String patientId, String pregnancyId) {
        List<Visit> allVisits = getPregnancyVisits(pregnancyId);

        if (allVisits.size() > 0) {
            return allVisits.get(allVisits.size() - 1);
        } else {
            return null;
        }

    }
    
    public Visit getLatestPatientVisit(String patientId) {
    	List<Visit> allVisits = getAll();
    	Collections.sort(allVisits, new VisitComparator());
    	if (allVisits.size() > 0) {
    		return allVisits.get(allVisits.size() -1);
    	} else {
    		return null;
    	}
    }
    
    public List<Visit> getPregnancyVisits(String pregnancyId){
    	List<Visit> allVisits = this.getAll();
    	List<Visit> result = new ArrayList<Visit>();
    	ListIterator<Visit> iter = allVisits.listIterator();
    	
    	Visit v;
    	
    	while(iter.hasNext()) {
    		v = iter.next();
    		if(v.getPregnancyId().equals(pregnancyId)) {
    			result.add(v);
    		}
    	}
    	Collections.sort(result, new VisitComparator());
    	return result;
    }
    
    private class VisitComparator implements Comparator<Visit>{
    	public int compare(Visit v1, Visit v2) {
    		return v1.getVisitDate().compareTo(v2.getVisitDate());
    	}
    }

}
