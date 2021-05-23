package antenatal.models;

import java.io.Serializable;

public class PatientInfoModel implements Serializable {

    private static final long serialVersionUID = 5522377346352177150L;

    private String patientId;
    private int parity;
    private BloodGroup bloodGroup;
    private boolean venerealDiseaseLab;
    private Sickling sickling;
    private TT tt;
    private IPT ipt;
    private Double height;
    private boolean pmtctPretestCounseling;
    private boolean pmtctTestResult;
    private boolean pmtctPosttestCounseling;
    private boolean pmtctAntiretroviralDrugsGiven;

    public PatientInfoModel(String patientId, int parity, Double height, BloodGroup bloodGroup, boolean venerealDiseaseLab, Sickling sickling,
            boolean pmtctPretestCounseling, boolean pmtctTestResult, boolean pmtctPosttestCounseling,
            boolean pmtctAntiretroviralDrugsGiven, TT tt, IPT ipt) {
        this.setPatientId(patientId);
        this.setParity(parity);
        this.setBloodGroup(bloodGroup);
        this.setVenerealDiseaseLab(venerealDiseaseLab);
        this.setSickling(sickling);
        this.setPmtctPretestCounseling(pmtctPretestCounseling);
        this.setPmtctTestResult(pmtctTestResult);
        this.setPmtctPosttestCounseling(pmtctPosttestCounseling);
        this.setPmtctAntiretroviralDrugsGiven(pmtctAntiretroviralDrugsGiven);
        this.setTt(tt);
        this.setIpt(ipt);
        this.setHeight(height); 
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getParity() {
        return parity;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public boolean isVenerealDiseaseLab() {
        return venerealDiseaseLab;
    }

    public void setVenerealDiseaseLab(boolean venerealDiseaseLab) {
        this.venerealDiseaseLab = venerealDiseaseLab;
    }

    public Sickling getSickling() {
        return sickling;
    }

    public void setSickling(Sickling sickling) {
        this.sickling = sickling;
    }

    public boolean isPmtctPretestCounseling() {
		return pmtctPretestCounseling;
	}

	public void setPmtctPretestCounseling(boolean pmtctPretestCounseling) {
		this.pmtctPretestCounseling = pmtctPretestCounseling;
	}

	public boolean isPmtctTestResult() {
		return pmtctTestResult;
	}

	public void setPmtctTestResult(boolean pmtctTestResult) {
		this.pmtctTestResult = pmtctTestResult;
	}

	public boolean isPmtctPosttestCounseling() {
		return pmtctPosttestCounseling;
	}

	public void setPmtctPosttestCounseling(boolean pmtctPosttestCounseling) {
		this.pmtctPosttestCounseling = pmtctPosttestCounseling;
	}

	public boolean isPmtctAntiretroviralDrugsGiven() {
		return pmtctAntiretroviralDrugsGiven;
	}

	public void setPmtctAntiretroviralDrugsGiven(boolean pmtctAntiretroviralDrugsGiven) {
		this.pmtctAntiretroviralDrugsGiven = pmtctAntiretroviralDrugsGiven;
	}

	public TT getTt() {
        return tt;
    }

    public void setTt(TT tt) {
        this.tt = tt;
    }

    public IPT getIpt() {
        return ipt;
    }

    public void setIpt(IPT ipt) {
        this.ipt = ipt;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public enum BloodGroup {
        A,
        B,
        O,
        AB
    }

    public static class Sickling {

        public boolean status;
        public Type type;

        public Sickling() {
            this.status = false;
            this.type = null;
        }

        public Sickling(boolean status, Type type) {
            this.status = status;
            this.type = type;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public enum Type {
        	None,
            AS,
            SS,
            SC
        }
    }

    public static class TT {

        public boolean firstDoseGiven;
        public boolean secondDoseGiven;
        public boolean thirdDoseGiven;
        public boolean fourthDoseGiven;
        public boolean fifthDoseGiven;
        public boolean previouslyProtected;

        public TT() {
            this.firstDoseGiven = false;
            this.secondDoseGiven = false;
            this.thirdDoseGiven = false;
            this.fourthDoseGiven = false;
            this.fifthDoseGiven = false;
            this.previouslyProtected = false;
        }

        public TT(boolean firstDoseGiven, boolean secondDoseGiven, boolean thirdDoseGiven, boolean fourthDoseGiven, boolean fifthDoseGiven, boolean previouslyProtected) {
            this.firstDoseGiven = firstDoseGiven;
            this.secondDoseGiven = secondDoseGiven;
            this.thirdDoseGiven = thirdDoseGiven;
            this.fourthDoseGiven = fourthDoseGiven;
            this.fifthDoseGiven = fifthDoseGiven;
            this.previouslyProtected = previouslyProtected;
        }

        public boolean isFirstDoseGiven() {
            return firstDoseGiven;
        }

        public void setFirstDoseGiven(boolean firstDoseGiven) {
            this.firstDoseGiven = firstDoseGiven;
        }

        public boolean isSecondDoseGiven() {
            return secondDoseGiven;
        }

        public void setSecondDoseGiven(boolean secondDoseGiven) {
            this.secondDoseGiven = secondDoseGiven;
        }

        public boolean isThirdDoseGiven() {
            return thirdDoseGiven;
        }

        public void setThirdDoseGiven(boolean thirdDoseGiven) {
            this.thirdDoseGiven = thirdDoseGiven;
        }

        public boolean isFourthDoseGiven() {
            return fourthDoseGiven;
        }

        public void setFourthDoseGiven(boolean fourthDoseGiven) {
            this.fourthDoseGiven = fourthDoseGiven;
        }

        public boolean isFifthDoseGiven() {
            return fifthDoseGiven;
        }

        public void setFifthDoseGiven(boolean fifthDoseGiven) {
            this.fifthDoseGiven = fifthDoseGiven;
        }

        public boolean isPreviouslyProtected() {
            return previouslyProtected;
        }

        public void setPreviouslyProtected(boolean previouslyProtected) {
            this.previouslyProtected = previouslyProtected;
        }

        public int getNumberOfShots() {
            
            if(isFifthDoseGiven()) {
                return 5;
            }
            else if(isFourthDoseGiven()){
                return 4;
            }
            else if(isThirdDoseGiven()){
                return 3;
            }
            else if(isSecondDoseGiven()) {
                return 2;
            }
            else if(isFirstDoseGiven()) {
                return 1;
            }
            else if(isPreviouslyProtected()) {
                return -1;
            }
            else {
                return 0;
            }

        }

    }

    public static class IPT {

        public boolean firstDoseGiven;
        public boolean secondDoseGiven;
        public boolean thirdDoseGiven;

        public IPT() {
            this.firstDoseGiven = false;
            this.secondDoseGiven = false;
            this.thirdDoseGiven = false;
        }

        public IPT(boolean firstDoseGiven, boolean secondDoseGiven, boolean thirdDoseGiven) {
            this.firstDoseGiven = firstDoseGiven;
            this.secondDoseGiven = secondDoseGiven;
            this.thirdDoseGiven = thirdDoseGiven;
        }

        public boolean isFirstDoseGiven() {
            return firstDoseGiven;
        }

        public void setFirstDoseGiven(boolean firstDoseGiven) {
            this.firstDoseGiven = firstDoseGiven;
        }

        public boolean isSecondDoseGiven() {
            return secondDoseGiven;
        }

        public void setSecondDoseGiven(boolean secondDoseGiven) {
            this.secondDoseGiven = secondDoseGiven;
        }

        public boolean isThirdDoseGiven() {
            return thirdDoseGiven;
        }

        public void setThirdDoseGiven(boolean thirdDoseGiven) {
            this.thirdDoseGiven = thirdDoseGiven;
        }
        
        public int getNumberOfShots() {
            if(isThirdDoseGiven()){
                return 3;
            }
            else if(isSecondDoseGiven()) {
                return 2;
            }
            else if(isFirstDoseGiven()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    
    public static class Shot {
        
        public String type;
        public String givenDate;
        public String nextDate;
        
        public Shot() {
            this.type = new String();
            this.givenDate = new String();
            this.nextDate = new String();
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLatestDate() {
            return givenDate;
        }

        public void setLatestDate(String latestDate) {
            this.givenDate = latestDate;
        }

        public String getNextDate() {
            return nextDate;
        }

        public void setNextDate(String nextDate) {
            this.nextDate = nextDate;
        }
        
        
        
        
        
    }
}