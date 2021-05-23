package antenatal.controllers;

import java.io.FileWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import antenatal.models.MonthlyReport;
import antenatal.models.PatientInfoModel;
import antenatal.models.PatientInfoModel.IPT;
import antenatal.models.PatientInfoModel.TT;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import antenatal.services.MonthlyReportService;
import antenatal.services.PatientInfoService;
import antenatal.services.PregnancyService;
import antenatal.services.VisitService;
import antenatal.views.MainMenu;
import antenatal.views.MonthlyReportPanel;
import edu.usm.cos420.consultingregister.domain.Patient;
import edu.usm.cos420.consultingregister.service.search.PatientSearch;

public class MonthlyReportController {

    private MainMenu mainMenuView;
    private MonthlyReportService mrs;
    private VisitService vService;
    private PatientInfoService piService;
    private PregnancyService pService;
    private PatientSearch patientSearch;
    private MonthlyReportPanel monthlyView;

    public MonthlyReportController() { //MainMenu view
        // this.mainMenuView = view;
        this.mrs = new MonthlyReportService();
        this.vService = new VisitService();
        this.piService = new PatientInfoService();
        this.patientSearch = new PatientSearch();
        this.pService = new PregnancyService();
        this.monthlyView = new MonthlyReportPanel();
    }

    public MonthlyReportController(MonthlyReportService mrs) {
        this.mrs = mrs;
        this.vService = new VisitService();
        this.piService = new PatientInfoService();
        this.patientSearch = new PatientSearch();
        this.pService = new PregnancyService();
        this.monthlyView = new MonthlyReportPanel();
    }

    public MonthlyReportController(MonthlyReportPanel monthlyView) {
        this.mrs = new MonthlyReportService();
        this.vService = new VisitService();
        this.piService = new PatientInfoService();
        this.patientSearch = new PatientSearch();
        this.pService = new PregnancyService();
        this.monthlyView = monthlyView;
    }



    public void generate(String export, int m, int y) { //start or main
        int numReg = this.getRegistrants(m, y);
        int numAtt = this.getAttendances(m, y);
        int num4thVisit = this.get4thVisits(m, y);
        int[] age = this.getAgeCounts(m,y);
        int below5ft = this.getBelow5ft(m, y);
        int[] parity = this.getParityCounts(m, y);
        int[] hg = this.getHemoglobinCounts(m, y);
        int[] durationPregnancyAtReg = this.getDurationPregnancy(m, y); //first trimester,second trimester, third trimester
        int[] iptCounts = this.getIPTCounts(m, y);
        int TTVaccine2Plus = this.getTTCount(m, y); //number of patients with tetanus vaccines on cycle 2+ (first and second dose taken)
        int[] pmtctCounts = this.getPMTCTCounts(m, y); // # counselled, # tested, , # of babies on arv, # of mothers on arv
        int[] itn = this.getITNCounts(m, y);

        if(export == null) {
            export = new String();
        }
        if(export.equals("CSV")) { //csv

            try {
                FileWriter writer = new FileWriter("MonthlyReport.csv");
                writer.append("# of Registrants,# of Attendances,# making 4th visits,"
                        + "TT 2+ vaccination,Age 10-14,Age 15-19,Age 20-24,Age 25-29,Age 30-34,Age 35+,Mothers below 150cm (5 ft),"
                        + "Parity 0,Parity 1-2,Parity 3-4,Parity 5+,Clients with HB checked at registration, Clients with HB < 11 gm/dl at registration,"
                        + "Clients with HB < 7 gm/dl at registration,Clients with HB checked at 36 weeks,Clients with HB < 11 gm/dl at 36 weeks,"
                        + "Clients with HB < 7 gm/dl at 36 weeks,# IPT 1,# IPT 2,# IPT 3,# Using ITN at 1st visit,# Using ITN at 2nd visit,# Counselled (PMTCT),"
                        + "# Tested (PMTCT),# Positive tests,# of mothers on antiretroviral");
                writer.append("\n");
                writer.append(String.valueOf(numReg)+",");
                writer.append(String.valueOf(numAtt)+",");
                writer.append(String.valueOf(num4thVisit)+",");
                writer.append(String.valueOf(TTVaccine2Plus)+",");
                for(int i = 0; i < age.length; i++) {
                    writer.append(String.valueOf(age[i])+",");  //age values
                }

                writer.append(String.valueOf(below5ft)+","); //below 5 ft

                for(int i = 0; i < parity.length; i++) {        //parity values
                    writer.append(String.valueOf(parity[i])+",");
                }

                for(int i = 0; i < hg.length; i++) {            //hg values
                    writer.append(String.valueOf(hg[i])+",");
                }

                for(int i = 0; i < iptCounts.length; i++) {            //ipt values
                    writer.append(String.valueOf(iptCounts[i])+",");
                }

                for(int i = 0; i < itn.length; i++) {
                    writer.append(String.valueOf(itn[i])+",");  //itn values
                }

                for(int i = 0; i < pmtctCounts.length; i++) {
                    if(i == 3) {
                        writer.append(String.valueOf(pmtctCounts[i]));
                    }else {
                        writer.append(String.valueOf(pmtctCounts[i])+","); //pmtctCounts
                    }

                }

                writer.close();

                JOptionPane.showMessageDialog(mainMenuView, "Successfully saved MonthlyReport.csv","Success",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(mainMenuView.homePanel, "Error saving MonthlyReport.csv","Error",JOptionPane.ERROR_MESSAGE);

                e.printStackTrace();
            }

        }else if(export.equals("JSON")) { //dao

            try {
                MonthlyReport mr = new MonthlyReport(m,y,numReg,numAtt,num4thVisit,below5ft,age,hg,parity,durationPregnancyAtReg,iptCounts,TTVaccine2Plus,pmtctCounts,itn);

                mrs.addItem(mr);
                JOptionPane.showMessageDialog(mainMenuView, "Successfully saved MonthlyReport.json","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(mainMenuView, "Error saving MonthlyReport.json","Error",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }


        }else {
            //cancel
        }


        // Display the report
        monthlyView.displayReport(m, y, numReg, numAtt, num4thVisit, age, 
            below5ft, parity, hg, durationPregnancyAtReg, iptCounts,
            TTVaccine2Plus, pmtctCounts, itn);

    }



    public List<Visit> getAllVisits(int m,int y){ 
        List<Visit> allVisits = vService.getAll();    //get all visits in dao

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        allVisits.removeIf(Visit -> {   
            try {
                return sdf.parse(Visit.getVisitDate()).getMonth()+1 != m;
            } catch (ParseException e) {      
                e.printStackTrace();
                return true; //still remove it if can't parse date
            }
        });   //remove all visits not in month (that's passed as param)

        allVisits.removeIf(Visit -> {   
            try {
                return sdf.parse(Visit.getVisitDate()).getYear()+1900 != y;
            } catch (ParseException e) {      
                e.printStackTrace();
                return true; //still remove it if can't parse date
            }
        });   //remove all visits not in year (that's passed as param)


        return allVisits;

    }

    public int[] getAgeCounts(int m, int y) {
        int[] ages = new int[6];
        List<Visit> visits = getAllVisits(m, y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {    //get age of all patients (we have to use info from CR since we don't store age)
            if(!patientsCounted.contains(v.getPatientId())){
                patientSearch.setFilterNHISNumber(Long.parseLong(v.getPatientId())); //get patient
                List<Patient> matches = patientSearch.getMatches();
                int age = matches.get(0).getAge();
                if(age >= 10 && age <= 14) {
                    ages[0]++;
                }else if(age >=15 && age <=19) {
                    ages[1]++;
                }else if(age >=20 && age <=24) {
                    ages[2]++;
                }else if(age >=25 && age <=29) {
                    ages[3]++;
                }else if(age >=30 && age <=34) {
                    ages[4]++;
                }else if(age >= 35) { 
                    ages[5]++;
                }      

                patientsCounted.add(v.getPatientId()); //so we don't count this again
            }
        }

        return ages;

    }

    public int[] getHemoglobinCounts(int m,int y) {
        int[] hg = new int[6];
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>(); //patient IDs that have been counted (multiple visits possibly)
        for(Visit v : visits) {
            Pregnancy p = pService.findItem(v.getPregnancyId());
            if(!patientsCounted.contains(v.getPatientId())){ //haven't counted this patient yet
                double hg0 = p.getHemoglobin0();
                double hg36 = p.getHemoglobin36();
                if(hg0 > 0) {
                    hg[0]++;
                }
                if(hg0 < 11.0) {
                    hg[1]++;
                }
                if(hg0 < 7.0) {
                    hg[2]++;
                }

                if(hg36 > 0) {
                    hg[3]++;
                }
                if(hg36 < 11) {
                    hg[4]++;
                }
                if(hg36 < 7) {
                    hg[5]++;
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again
            }
        }

        return hg;
    }


    public int[] getParityCounts(int m,int y) {
        int[] parityCount = new int[4];
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                int parity = piService.findItem(v.getPatientId()).getParity();
                if(parity == 0) {
                    parityCount[0]++;
                }else if(parity == 1 || parity == 2) {
                    parityCount[1]++;
                }else if(parity == 3 || parity == 4) {
                    parityCount[2]++;
                }else if(parity >= 5) {
                    parityCount[3]++;
                }

                patientsCounted.add(v.getPatientId());

            }

        }

        return parityCount;


    }

    public int getBelow5ft(int m,int y) {
        int count = 0;
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                PatientInfoModel patient = piService.findItem(v.getPatientId());
                if(patient.getHeight() < 150) {
                    count++;
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again

            }   
        }      
        return count;       
    }

    public int getRegistrants(int m,int y) {
        int count = 0;
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                count++;                
            }  

            patientsCounted.add(v.getPatientId()); //so we don't count this again

        }      
        return count; 
    }

    public int getAttendances(int m,int y) {
        return getAllVisits(m,y).size();
    }

    public int get4thVisits(int m, int y) {
        int count = 0;
        List<Visit> visits = getAllVisits(m,y);
        Map<String,Integer> patientsVisits = new HashMap<String,Integer>();
        for(Visit v : visits) {
            if(patientsVisits.containsKey(v.getPatientId())) {
                patientsVisits.put(v.getPatientId(), patientsVisits.get(v.getPatientId())+1);
            }else {
                patientsVisits.put(v.getPatientId(), 1);                      
            }   

            if(patientsVisits.get(v.getPatientId()) >= 4) {
                count++;
            }
        }

        return count; 
    }

    public int[] getDurationPregnancy(int m, int y) {
        //1st trimester = 0 - 13 weeks, 2nd = 14 - 27, 3rd = 28+
        int[] pregnancyDuration = new int[3];
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>(); //patient IDs that have been counted (multiple visits possibly)
        Map<String,Integer> patientsVisits = new HashMap<String,Integer>();
        for(Visit v : visits) {
            if(patientsVisits.containsKey(v.getPatientId())) {
                patientsVisits.put(v.getPatientId(), patientsVisits.get(v.getPatientId())+1);
            }else {
                patientsVisits.put(v.getPatientId(), 1);                      
            }   

            if(patientsVisits.get(v.getPatientId()) == 1) { //first visit
            	Pregnancy p = pService.findItem(v.getPregnancyId());
                int gestation = p.getGestation();
                if(gestation <= 13) {
                    pregnancyDuration[0]++;
                }else if(gestation >= 14 && gestation <= 27) {
                    pregnancyDuration[1]++;
                }else if(gestation >= 28) {
                    pregnancyDuration[2]++;

                }
            }

        }

        return pregnancyDuration;
    }

    public int[] getIPTCounts(int m, int y) {
        int iptCount[] = new int[3];
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                IPT ipt = piService.findItem(v.getPatientId()).getIpt();

                if(ipt.firstDoseGiven) {
                    iptCount[0]++;
                } 
                if(ipt.secondDoseGiven) {
                    iptCount[1]++;
                }
                if(ipt.thirdDoseGiven) {
                    iptCount[2]++;
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again


            }
        }

        return iptCount;

    }

    public int getTTCount(int m, int y) {
        int count = 0;
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                TT tt = piService.findItem(v.getPatientId()).getTt();
                if(tt.isFirstDoseGiven() && tt.isSecondDoseGiven() || tt.isPreviouslyProtected()) {
                    count++;
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again

            }
        }

        return count;

    }

    public int[] getPMTCTCounts(int m, int y) {
        int[] pmtctCounts = new int[4];
        List<Visit> visits = getAllVisits(m,y);
        List<String> patientsCounted = new ArrayList<String>();
        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){
                PatientInfoModel patientInfo = piService.findItem(v.getPatientId());

                if(patientInfo.isPmtctPretestCounseling() || patientInfo.isPmtctPosttestCounseling()) {
                    pmtctCounts[0]++;
                }

                if(patientInfo.isPmtctTestResult() || !patientInfo.isPmtctTestResult()) { //tested (can be false or true) as long has received test
                    pmtctCounts[1]++;
                }
                
                if(patientInfo.isPmtctTestResult()) {
                    pmtctCounts[2]++;
                }

                if(patientInfo.isPmtctAntiretroviralDrugsGiven()) {
                    pmtctCounts[3]++;
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again

            }
        }

        return pmtctCounts;


    }

    public int[] getITNCounts(int m, int y) {
        int[] ITN = new int[2];
        List<Visit> visits = getAllVisits(m,y);
        Map<String,Integer> patientsVisits = new HashMap<String,Integer>();
        List<String> patientsCounted = new ArrayList<String>();

        for(Visit v : visits) {
            if(!patientsCounted.contains(v.getPatientId())){

                if(patientsVisits.containsKey(v.getPatientId())) { 
                    patientsVisits.put(v.getPatientId(), patientsVisits.get(v.getPatientId())+1);
                    if(patientsVisits.get(v.getPatientId()) == 2) {
                        if(v.isItnInUse()) {
                            ITN[1]++;
                        }
                    }
                }else {
                    patientsVisits.put(v.getPatientId(), 1);   
                    if(v.isItnInUse()) { //first visit
                        ITN[0]++;
                    }
                }

                patientsCounted.add(v.getPatientId()); //so we don't count this again
            }

        }
        return ITN;
    }
}



