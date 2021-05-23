package antenatal.controllers;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import antenatal.models.PatientInfoModel;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import antenatal.views.InitialVisitPanel;
import antenatal.views.MainMenu;
import antenatal.views.MonthlyReportPanel;
import antenatal.views.PatientInfoPanel;
import antenatal.views.PatientSearchPanel;
import antenatal.views.PreviousVisitPanel;
import edu.usm.cos420.consultingregister.domain.Patient;

public class MenuController {
	
	// constants to keep track of tabs
	private final int HOME_TAB = 0;
	private final int PATIENT_TAB = 1;
	private final int VISIT_TAB = 2;
	private final int MONTHLY_TAB = 3;
	
	// Controllers
    private PatientController patientController;
    private VisitController visitController;
	private MonthlyReportController monthlyController;
	
    // Views
    private MainMenu homeMenu;
    private PatientSearchPanel patientSearchPanel;
    private PatientInfoPanel patientInfoPanel;
	private InitialVisitPanel visitPanel;
	private MonthlyReportPanel monthlyPanel;
     

    public MenuController() {
        // init views
        homeMenu = new MainMenu();
        patientSearchPanel = new PatientSearchPanel();
        patientInfoPanel = new PatientInfoPanel();
		monthlyPanel = new MonthlyReportPanel();
		visitPanel = new InitialVisitPanel();
      
        // Init controllers
        patientController = new PatientController(patientSearchPanel, patientInfoPanel);
		visitController = new VisitController(visitPanel);
		monthlyController = new MonthlyReportController(monthlyPanel);
    }

    public void start() throws ParseException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    uiInit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void uiInit() {
        // Add search tab
        homeMenu.tabPanel.addTab("Home", null, patientSearchPanel, null);
        homeMenu.tabPanel.setEnabledAt(HOME_TAB, true);
        // Add patient info tab
        homeMenu.tabPanel.addTab("Patient Information", null, patientInfoPanel, null);
        homeMenu.tabPanel.setEnabledAt(PATIENT_TAB, false);
        // Add visit info tab
        homeMenu.tabPanel.addTab("New Visit", null, visitPanel, null);
		homeMenu.tabPanel.setEnabledAt(VISIT_TAB, false);
		// Add Monthly Report tab
		homeMenu.tabPanel.addTab("Monthly Report", null, monthlyPanel, null);
		homeMenu.tabPanel.setEnabledAt(MONTHLY_TAB, false);

        homeMenu.setVisible(true);

        // Add action listeners
        patientSearchPanel.searchBtn.addActionListener(l -> patientSearch());
        patientSearchPanel.generateBtn.addActionListener(l -> generateReport());
        visitPanel.btnSubmitInfo.addActionListener(l -> saveVisit());
        visitPanel.btnCancel.addActionListener(l -> cancelVisit());
        patientInfoPanel.btnPreviousVisit.addActionListener(l -> displayVisit());
        patientInfoPanel.newVisitBtn.addActionListener(l -> startNewVisit());

    }

    public void displayVisit() {
        if (!patientInfoPanel.visitsList.isSelectionEmpty()) {
            try {
                Visit visit = patientInfoPanel.visitsList.getSelectedValue();

                PreviousVisitPanel previousVisit = new PreviousVisitPanel();

                previousVisit.setTitle("Antenatal Care Team");
                previousVisit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                previousVisit.setBounds(100, 100, 480, 330);
                previousVisit.setVisible(true);
                previousVisit.setResizable(false);

                PatientInfoModel patient = patientController.getPatientInfo(Long.parseLong(visit.getPatientId()));
                Pregnancy pregnancy = visitController.getPregnancyById(visit.getPregnancyId());

                // Calculate the gestation
                int gestation = calculateGestation(visit.getPatientId(), visit);

                previousVisit.displayVisit(visit, pregnancy, patient, gestation);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Function to calculate the gestation from the gestation at registration to a given date
     * @param patientId: patient being looked at
     * @param visit: visit we're looking at
     * @return the gestation at the given visit
     */
    public int calculateGestation(String patientId, Visit visit) {
    	try {
	    	Pregnancy pregnancy = visitController.getActivePregnancy(patientId);
	        // Calculate the gestation
	        Visit firstVisit = visitController.getFirstVisit(pregnancy.getPregnancyId());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        long timeBetween = sdf.parse(visit.getVisitDate()).getTime() - sdf.parse(firstVisit.getVisitDate()).getTime();
	        int weeksBetween = (int)TimeUnit.DAYS.convert(timeBetween, TimeUnit.MILLISECONDS)/7;
	        return pregnancy.getGestation() + weeksBetween;
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	return -1; // Return -1 if we have an issue
    }

    public void patientSearch() {
        String search = patientSearchPanel.patientSearchTextField.getText();
        try {
            long patientId = Long.parseLong(search);
            Patient patient = patientController.getBasePatient(patientId);
            if (patient != null) {
                displayPatientInfo(patientId);
            } else {
                patientController.patientSearchView.searchInvalid();
            }
        } catch (Exception ex) {
            patientController.patientSearchView.searchInvalid();
        }
    }


    public void saveVisit() {
        PatientInfoModel patientInfo = visitController.saveVisit();
        if (patientInfo != null) {
            patientController.savePatientInfo(patientInfo); 
            try {
                long patientId = Long.parseLong(patientInfo.getPatientId());
                displayPatientInfo(patientId);
                homeMenu.tabPanel.setEnabledAt(VISIT_TAB,false);
                homeMenu.tabPanel.setEnabledAt(HOME_TAB, true);
            }catch(Exception e){
                //TODO: Failed to find patient information
                e.printStackTrace();
            }
        }
    }

    public void cancelVisit() {
    	visitPanel.clear();
    	homeMenu.tabPanel.setSelectedIndex(PATIENT_TAB);
    	homeMenu.tabPanel.setEnabledAt(VISIT_TAB,false);
        homeMenu.tabPanel.setEnabledAt(HOME_TAB, true);
    }

    public void displayPatientInfo(long patientId) {             
        Pregnancy activePregnancy = visitController.getActivePregnancy(patientId+"");
        List<Visit> allVisits = visitController.getAllVisits(patientId+"");
        Visit latestVisit = visitController.getLatestPatientVisit(patientId+"");
        if (activePregnancy != null) {
        	int gestation = calculateGestation(patientId+"", latestVisit);
            patientController.displayPatient(patientId, activePregnancy, latestVisit, allVisits, (gestation > 0) ? gestation+"" : "N/A");
        } else {
            patientController.displayPatient(patientId, null, latestVisit, allVisits, "N/A");
        }

        PatientInfoModel patientInfo = patientController.getPatientInfo(patientId);

        // Swap to patient tab
        homeMenu.tabPanel.setSelectedIndex(PATIENT_TAB);
        homeMenu.tabPanel.setEnabledAt(PATIENT_TAB, true);
    }

    public void startNewVisit() {
        try {
        	String patientId = patientInfoPanel.nhisLabel.getText();
            long patientID = Long.parseLong(patientId);
            
        	// Check if active pregnancy already exists
            Pregnancy pregnancy = visitController.getActivePregnancy(patientId);
            if (pregnancy != null && !pregnancy.getEDD().equals("")) {
		    	int choice = JOptionPane.showOptionDialog(homeMenu,
			        			"Is this the first visit of a new pregnancy?",
			        			"New Pregnancy?",
			        			JOptionPane.YES_NO_OPTION,
			        			JOptionPane.QUESTION_MESSAGE,
			        			null,
			        			null,
			        			null);
		    	
		    	// 0 = yes, 1 = no
		    	if (choice == 0) {
		    		visitController.terminateLatestPregnancy(patientId);
		    	}
            }
            
            PatientInfoModel patientInfo = patientController.getPatientInfo(patientID);
            visitController.displayVisit(patientID, patientInfo);
            homeMenu.tabPanel.setSelectedIndex(VISIT_TAB);
            homeMenu.tabPanel.setEnabledAt(VISIT_TAB,true);
            homeMenu.tabPanel.setEnabledAt(HOME_TAB, false);

        }catch(Exception e) {
            e.printStackTrace();

        }

    }
      
	  public void generateReport() {
	    //add popup/alert/dialog to show generated 
	    
	    Object[] options = {"CSV", "JSON"};
	    String exportOption = (String)JOptionPane.showInputDialog(
	                        homeMenu,
	                        "Export as",
	                        "Export",
	                        JOptionPane.PLAIN_MESSAGE,
	                        null,
	                        options,
	                        "CSV");
	    
	    System.out.println("EXPORTING AS "+exportOption);
	  
	        Date date = (Date) patientController.patientSearchView.datePicker.getValue();
	        
	        int year = date.getYear()+1900;
	        int month = date.getMonth()+1;
	        System.out.println("GENERATING REPORT FOR "+month+" "+year);
		

		// Generate and Display report
		monthlyController.generate(exportOption,month,year);

		homeMenu.tabPanel.setSelectedIndex(MONTHLY_TAB);
		homeMenu.tabPanel.setEnabledAt(MONTHLY_TAB, true);
    }

}
