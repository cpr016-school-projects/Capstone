package antenatal.controllers;

import antenatal.models.PatientInfoModel;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import antenatal.services.PatientInfoService;
import antenatal.services.PregnancyService;
import antenatal.services.VisitService;
import antenatal.views.PatientInfoPanel;
import antenatal.views.PatientSearchPanel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JTabbedPane;

import edu.usm.cos420.consultingregister.service.search.*;
import edu.usm.cos420.consultingregister.domain.*;


public class PatientController {
	
	private PatientInfoService patientInfoService;
	private PatientSearch patientSearch;
	private List<Patient> matches;
	public PatientInfoPanel patientView;
	public PatientSearchPanel patientSearchView;
	
	public PatientController(PatientSearchPanel patientSearchPanel, PatientInfoPanel patientInfoPanel) {
		patientSearch = new PatientSearch();
		matches = new ArrayList<Patient>();
		patientInfoService = new PatientInfoService();
		patientView = patientInfoPanel;
		patientSearchView = patientSearchPanel;
	}

	
	public Patient getBasePatient(Long patientId) {
		patientSearch.setFilterNHISNumber(patientId);
		matches = patientSearch.getMatches();
		if (matches.size() > 0) {
			return matches.get(0);
		} else {
			return null;
		}
	}
	
	
	public void savePatientInfo(PatientInfoModel patientInfo) {
	    patientInfoService.updateItem(patientInfo);
	}
	
	public PatientInfoModel getPatientInfo(long patientId) {
		return patientInfoService.findItem(patientId+"");
	}
	
	public void displayPatient(Long patientId, Pregnancy pregnancy, Visit latestVisit, List<Visit> allVisits, String gestation) {
		try {
			patientSearch.setFilterNHISNumber(patientId);
			matches = patientSearch.getMatches();
			Patient patient = matches.get(0);
			String fullName = String.format("%s, %s", patient.getLastName(), patient.getFirstName());
			
			PatientInfoModel patientInfo = patientInfoService.findItem(patientId.toString());
			
			if (patientInfo != null) {
				patientView.populatePatientInfo(patientInfo, pregnancy, latestVisit, gestation);
			}
			// TODO: Still need logic to handle if a patient has patientInfo but no active pregnancy
			patientView.displayBasePatientInfo(patientId.toString(), fullName, patient.getAge().toString(), patient.getGender().name(),
					patient.getAddress().toString(), patient.getTribe());
			
			patientView.populateVisitList(allVisits);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
