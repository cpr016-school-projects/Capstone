package antenatal.models;

import java.io.Serializable;

import java.util.UUID;

import edu.usm.cos420.consultingregister.domain.Patient;

public class MonthlyReport implements Serializable {

    private static final long serialVersionUID = 5522377346352177150L;
    private String monthlyReportID;
    private int month;
    private int year;
    private int numRegistrants; 
    private int numAttendances;
    private int numMaking4thVisit;
    private int numBelow5ft;
    private int[] ageAtReg; //10-14, 15-19, 20-24, 25-29, 30-34, 35+
    private int[] hemoglobinAtRegAnd36; // # checked HB at reg, < 11, < 7, # checked at 36, < 11, < 7
    private int[] parityCount; //0, 1-2, 3-4, 5+
    private int[] durationPregnancyAtReg; //first trimester,second trimester, third trimester
    private int[] iptCounts;
    private int TTVaccine2Plus; //number of patients with tetanus vaccines on cycle 2+ (first and second dose taken)
    private int[] pmtctCounts;// # counselled, # tested, , # of babies on arv, # of mothers on arv
    private int[] ITNCounts;
    
    
    public MonthlyReport() {
        ageAtReg = new int[6];
        hemoglobinAtRegAnd36 = new int[6];
        parityCount = new int[4];
        durationPregnancyAtReg = new int[3];
        iptCounts = new int[3];
        pmtctCounts = new int[3]; 
    }
    
    public MonthlyReport(int month, int year, int numReg, int numAtt, int num4th, int numBelow5, int[] age, int[] hg, int[] parity,
            int[] durationPregnancy, int[] ipt, int TT, int[] pmtct, int[] itn) {
        this.monthlyReportID = generateId();
        this.month = month;
        this.year = year;
        this.numRegistrants = numReg;
        this.numAttendances = numAtt;
        this.numMaking4thVisit = num4th;
        this.numBelow5ft = numBelow5;
        this.ageAtReg = age;
        this.hemoglobinAtRegAnd36 = hg;
        this.parityCount = parity;
        this.durationPregnancyAtReg = durationPregnancy;
        this.iptCounts = ipt;
        this.TTVaccine2Plus = TT;
        this.pmtctCounts = pmtct;
        this.ITNCounts = itn;
        
    }
    
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setMonth(int m) {
        this.month = m;
    }
    
    public void setYear(int y) {
        this.year = y;
    }
    
    public void setNumReg(int numR) {
        this.numRegistrants = numR;
    }
      
    public int getNumReg() {
        return this.numRegistrants;
    }
    
    public int getNumAtt() {
        return this.numAttendances;
    }
    
    public void setNumAtt(int numA) {
        this.numAttendances = numA;
    }
    
    public void setNum4thVisit(int num4th) {
        this.numMaking4thVisit = num4th;
    }
    
    public int getNum4thVisit() {
        return this.numMaking4thVisit;
    }
    
    public void setNumBelow5Ft(int below5) {
        this.numBelow5ft = below5;
    }
    
    public int getNumBelow5Ft() {
        return this.numBelow5ft;
    }
    
    public void setAge(int[] age) {
        this.ageAtReg = age;
    }
    
    public int[] getAge() {
        return ageAtReg;
    }
    
    public void setHemoglobin(int[] hg) {
        this.hemoglobinAtRegAnd36 = hg;
    }
    
    public int[] getHemoglobin() {
        return this.hemoglobinAtRegAnd36;
    }
    
    public void setParity(int[] parity) {
        this.parityCount = parity;
    }
    
    public int[] getParity() {
        return this.parityCount;
    }
    
    public void setDurationPregnancy(int[] durationP) {
        this.durationPregnancyAtReg = durationP;
    }
    
    public int[] getDurationPregnancy() {
        return this.durationPregnancyAtReg;
    }
    
    public void setIPTCounts(int[] ipt) {
        this.iptCounts = ipt;
    }

    public int[] getIPTCounts() {
        return this.iptCounts;
    }
    
    public void setPMTCTCounts(int[] pmtct) {
        this.pmtctCounts = pmtct;
    }
    
    public int[] getPMTCTCounts() {
        return this.pmtctCounts;
    }
    
    public void setTTCount(int tt) {
        this.TTVaccine2Plus = tt;
    }
    
    public int getTTCount() {
        return this.TTVaccine2Plus;
    }
    
    
    
    public String generateId() {
        return UUID.randomUUID().toString();
    }
    
    public String getID() {
        return monthlyReportID;
    }
    
    
    
    
}