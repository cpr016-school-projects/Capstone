package antenatal.controllers;

import antenatal.models.Visit;
import antenatal.models.Visit.BloodPressure;
import antenatal.models.PatientInfoModel;
import antenatal.models.PatientInfoModel.TT;
import antenatal.models.Pregnancy;
import antenatal.services.VisitService;
import antenatal.services.PatientInfoService;
import antenatal.services.PregnancyService;
import antenatal.views.InitialVisitPanel;
import antenatal.views.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class VisitController {
	
	public static class VisitDTO {
		
		PatientInfoModel.BloodGroup bloodGroup;
		PatientInfoModel.Sickling sickling;
		PatientInfoModel.TT tt;
		PatientInfoModel.IPT ipt;
		BloodPressure bloodPressure;
		
		String edd;
		String complaint;
		String remark;
		
		Integer gestation;
		Integer parity; 
		
		Double hemoglobin0;
		Double hemoglobin36;
		Double fundalHeight;
		Double height;
		Double weight;
		
		boolean venerealDiseaseLab;
		boolean referred;
		boolean itnInUse;
		boolean pmctcPreTest;
		boolean pmctcTestResult;
		boolean pmctcPostTest;
		boolean pmctcAntiretroviral;
		boolean pregnancyTerminated;
		
		public VisitDTO(String edd, Double height, Double weight, Double fundalHeight, Double hemoglobin0, Double hemoglobin36, Integer gestation, Integer parity,
				PatientInfoModel.BloodGroup bloodGroup, PatientInfoModel.Sickling sickling, boolean venerealDiseaseLab, boolean pmctcPreTest, boolean pmctcTestResult,
				boolean pmctcPostTest, boolean pmctcAntiretroviral, PatientInfoModel.TT tt, PatientInfoModel.IPT ipt, BloodPressure bloodPressure,
				String complaint, String remark, boolean referred, boolean itnInUse, boolean terminated) {
			this.edd = edd;
			this.height = height;
			this.weight = weight; 
			this.fundalHeight = fundalHeight;
			this.hemoglobin0 = hemoglobin0; 
			this.hemoglobin36 = hemoglobin36; 
			this.gestation = gestation; 
			this.parity = parity;
			this.bloodGroup = bloodGroup; 
			this.sickling = sickling;
			this.venerealDiseaseLab = venerealDiseaseLab;
			this.pmctcPreTest = pmctcPreTest;
			this.pmctcTestResult = pmctcTestResult;
			this.pmctcPostTest = pmctcPostTest;
			this.pmctcAntiretroviral = pmctcAntiretroviral;
			this.tt = tt;
			this.ipt = ipt; 
			this.bloodPressure = bloodPressure;
			this.complaint = complaint;
			this.remark = remark;
			this.referred = referred;
			this.itnInUse = itnInUse;
			this.pregnancyTerminated = terminated;
		}
	}
	

	
	public class Pair<Visit, Pregnancy> {
		public final Visit visit;
		public final Pregnancy pregnancy;
		
		public Pair(Visit v, Pregnancy p) {
			this.pregnancy = p;
			this.visit = v;
		}
	}

	private VisitService visitService;
	private PregnancyService pregnancyService;
	private InitialVisitPanel visitView;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public VisitController(InitialVisitPanel visitPanel) {
		visitView = visitPanel;
		visitService = new VisitService();
		pregnancyService = new PregnancyService();
	}

	

	/**
	 * Check if a patient has an active pregnancy populate fields of new Visit using
	 * pregnancy or previous visit if available
	 */
	public Pair<Visit, Pregnancy> newVisit(String patientId) {
		
		System.out.println("Creating new visit");
		
		Pregnancy pregnancy = pregnancyService.getActivePatientPregnancy(patientId);
		Visit newVisit;

		if (pregnancy != null) {
			Visit lastVisit = visitService.getLastVisit(patientId, pregnancy.getPatientId());
			
			if (lastVisit != null) {
			
				newVisit = new Visit(patientId, pregnancy.getPregnancyId(), sdf.format(new Date()), lastVisit.getComplaints(), lastVisit.getRemarks(),
						lastVisit.getReferred(), lastVisit.getWeight(), pregnancy.getActive(), false);
			}
			else {
				newVisit = new Visit(patientId, pregnancy.getPregnancyId(), sdf.format(new Date()));
			}
		}
		else {
			pregnancy = new Pregnancy(patientId);
			newVisit = new Visit(patientId, pregnancy.getPregnancyId(), sdf.format(new Date()));
			pregnancyService.addItem(pregnancy);
		}

		//visitService.addItem(newVisit);
		return new Pair(newVisit, pregnancy);
	}

	public Pair<Visit, Pregnancy> displayVisit(Long patientId, PatientInfoModel patientInfo) {
		Pair<Visit, Pregnancy> pv = newVisit(patientId.toString());
																			
		Visit newVisit = pv.visit; 
		Pregnancy pregnancy = pv.pregnancy;
		
		if (patientInfo != null && !pregnancy.getEDD().equals("")) {
			visitView.displaySubsequentVisit(patientInfo, pregnancy); //1+ visit (gray out)
		}
		else if (patientInfo != null && pregnancy.getEDD().equals("")) {
			visitView.displayNewPregnancyVisit(patientInfo);
		}
		else {
			visitView.displayInitialVisit(patientId.toString()); //first visit
		}

		return new Pair<Visit, Pregnancy>(newVisit, pregnancy);
	}

	public PatientInfoModel saveVisit() {
	    
		try {
			// Get patient id from UI
			String patientId = visitView.lblNumber.getText();
			Pair<Visit, Pregnancy> pair = newVisit(patientId);
			
			
			VisitDTO dto = visitView.populateDTO();
			
			if (dto != null) {
				
				PatientInfoModel patientInfo = new PatientInfoModel(patientId, dto.parity, dto.height, dto.bloodGroup, dto.venerealDiseaseLab,
						dto.sickling, dto.pmctcPreTest, dto.pmctcTestResult, dto.pmctcPostTest, dto.pmctcAntiretroviral, dto.tt, dto.ipt);
		
				pair.pregnancy.setEDD(dto.edd);
				pair.pregnancy.setGestation(dto.gestation);
				pair.pregnancy.setHemoglobin0(dto.hemoglobin0);
				pair.pregnancy.setHemoglobin36(dto.hemoglobin36);
				pair.pregnancy.setActive(!dto.pregnancyTerminated);
				
				pair.visit.setWeight(dto.weight);
				pair.visit.setFundalHeight(dto.fundalHeight);
				pair.visit.setReferred(dto.referred);
				pair.visit.setItnInUse(dto.itnInUse);
				pair.visit.setBloodPressure(dto.bloodPressure.getSystolicBP(), dto.bloodPressure.getDiastolicBP());
				pair.visit.addComplaint(dto.complaint);
				pair.visit.addRemark(dto.remark);
				
				visitService.addItem(pair.visit);
				pregnancyService.updateItem(pair.pregnancy);
				
			    visitView.clear();
				
				
				return patientInfo;
			}
		} catch (Exception ex) {
			System.err.print(ex);
		}
		return null;
	}
	
	public Visit getLatestVisit(String patientId, String pregnancyId ) {
	    return visitService.getLastVisit(patientId, pregnancyId);
	}
	
	public Visit getLatestPatientVisit(String patientId) {
		return visitService.getLatestPatientVisit(patientId);
	}
	
	public Pregnancy getActivePregnancy(String patientId) {
	    return pregnancyService.getActivePatientPregnancy(patientId);
	}
	
	public List<Visit> getAllVisits(String patientId) {
		// TODO: Make sure they're sorted by date
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    List<Visit> visits = visitService.getAllVisitsForPatient(patientId);
	    Collections.sort(visits, new Comparator<Visit>() {
	        
	        @Override
	        public int compare(Visit v1, Visit v2) {
	            try {
	                return -sdf.parse(v1.getVisitDate()).compareTo(sdf.parse(v2.getVisitDate()));
	            }catch(ParseException e){
	               throw new IllegalArgumentException(e);
	            }
	        }
	        
	        
	    });
		
		return visits;
	}
	
	public Visit getFirstVisit(String pregnancyId) {
		return visitService.getPregnancyVisits(pregnancyId).get(0);
	}
	
	public Visit getLastVisit(String pregnancyId) {
		List<Visit> pregnancyVisits = visitService.getPregnancyVisits(pregnancyId);
		return pregnancyVisits.get(pregnancyVisits.size()-1);
	}
	
	public Pregnancy getPregnancyById(String pregnancyId) {
		return pregnancyService.findItem(pregnancyId);
	}
	
	public void terminateLatestPregnancy(String patientId) {
		Pregnancy pregnancy = pregnancyService.getActivePatientPregnancy(patientId);
		if (pregnancy != null) {
			pregnancy.setActive(false);
			pregnancyService.updateItem(pregnancy);
		}
	}
}
