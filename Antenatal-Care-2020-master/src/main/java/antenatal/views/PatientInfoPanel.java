package antenatal.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import antenatal.models.PatientInfoModel;
import antenatal.models.PatientInfoModel.BloodGroup;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class PatientInfoPanel extends JPanel {

	public final int THIS_TAB = 1;

	public JTabbedPane tabPane;
	JLabel patientInfoLabel;
	public JLabel patientNameLabel;
	public JLabel patientAgeLabel;
	public JLabel patientGenderLabel;
	public JLabel patientAddressLabel;
	public JLabel patientTribeLabel;
	public JLabel nhisLabel;
	public JLabel parityDisplay;
	public JLabel heightDisplay;
	public JLabel weightDisplay;
	private JLabel bloodGroupLabel;
	private JLabel bloodGroupDisplay;
	private JLabel venerealDiseaseLabel;
	private JLabel venerealDiseaseDisplay;
	private JLabel sicklingLabel;
	private JLabel lastVisitLabel;
	private JLabel lastVisitDateDisplay;
	private JSeparator separator_3;
	private JCheckBox ttFirstCheckbox;
	private JCheckBox ttSecondCheckbox;
	private JCheckBox ttThirdCheckbox;
	private JCheckBox ttProtectedCheckbox;
	private JLabel iptLabel;
	private JSeparator separator_5;
	private JCheckBox iptFirstCheckbox;
	private JCheckBox iptSecondCheckbox;
	private JCheckBox iptThirdCheckbox;
	private JLabel sicklingStatusDisplay;
	private JLabel sicklingTypeDisplay;
	private JCheckBox pmctcPretestCheckbox;
	private JCheckBox pmctcTestCheckbox;
	private JCheckBox pmctcPosttestCheckbox;
	private JCheckBox pmctcAntiretroviralCheckbox;
	private JLabel visitListLabel;
	public JButton newVisitBtn;
	public JList<Visit> visitsList;
	public JButton btnPreviousVisit;
	private JLabel visitListHelperLabel;
	private JLabel gestationDisplay;

	public PatientInfoPanel() {
		SpringLayout sl_this = new SpringLayout();
		this.setLayout(sl_this);

		patientInfoLabel = new JLabel("Patient Information");
		patientInfoLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		patientInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_this.putConstraint(SpringLayout.NORTH, patientInfoLabel, 10, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, patientInfoLabel, 10, SpringLayout.WEST, this);
		this.add(patientInfoLabel);

		patientNameLabel = new JLabel("Last, First");
		sl_this.putConstraint(SpringLayout.WEST, patientNameLabel, 0, SpringLayout.WEST, patientInfoLabel);
		patientNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(patientNameLabel);

		JSeparator separator = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, patientNameLabel, 15, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.NORTH, separator, 6, SpringLayout.SOUTH, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, separator, 8, SpringLayout.SOUTH, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator, 442, SpringLayout.WEST, this);
		this.add(separator);

		patientAgeLabel = new JLabel("202");
		patientAgeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientAgeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, patientAgeLabel, 0, SpringLayout.NORTH, patientNameLabel);
		sl_this.putConstraint(SpringLayout.EAST, patientAgeLabel, 0, SpringLayout.EAST, separator);
		this.add(patientAgeLabel);

		patientGenderLabel = new JLabel("Male");
		patientGenderLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, patientGenderLabel, 0, SpringLayout.NORTH, patientNameLabel);
		sl_this.putConstraint(SpringLayout.EAST, patientGenderLabel, -59, SpringLayout.WEST, patientAgeLabel);
		this.add(patientGenderLabel);

		patientAddressLabel = new JLabel("Fake Address");
		sl_this.putConstraint(SpringLayout.NORTH, patientAddressLabel, 15, SpringLayout.SOUTH, patientNameLabel);
		sl_this.putConstraint(SpringLayout.WEST, patientAddressLabel, 0, SpringLayout.WEST, patientInfoLabel);
		patientAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(patientAddressLabel);

		patientTribeLabel = new JLabel("Patient Tribe");
		patientTribeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientTribeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, patientTribeLabel, 0, SpringLayout.NORTH, patientAddressLabel);
		sl_this.putConstraint(SpringLayout.EAST, patientTribeLabel, 0, SpringLayout.EAST, separator);
		this.add(patientTribeLabel);

		JSeparator separator_1 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_1, 40, SpringLayout.SOUTH, patientAddressLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_1, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, separator);
		this.add(separator_1);

		JLabel parityLabel = new JLabel("Parity");
		sl_this.putConstraint(SpringLayout.NORTH, parityLabel, 6, SpringLayout.SOUTH, separator_1);
		sl_this.putConstraint(SpringLayout.WEST, parityLabel, 0, SpringLayout.WEST, patientInfoLabel);
		this.add(parityLabel);

		JLabel heightLabel = new JLabel("Height (cm)");
		sl_this.putConstraint(SpringLayout.NORTH, heightLabel, 6, SpringLayout.SOUTH, separator_1);
		sl_this.putConstraint(SpringLayout.WEST, heightLabel, 131, SpringLayout.EAST, parityLabel);
		this.add(heightLabel);

		JLabel weightLabel = new JLabel("Weight (kg)");
		sl_this.putConstraint(SpringLayout.NORTH, weightLabel, 6, SpringLayout.SOUTH, separator_1);
		sl_this.putConstraint(SpringLayout.WEST, weightLabel, 0, SpringLayout.WEST, patientTribeLabel);
		sl_this.putConstraint(SpringLayout.EAST, weightLabel, 0, SpringLayout.EAST, separator_1);
		this.add(weightLabel);

		nhisLabel = new JLabel("NHIS");
		nhisLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		sl_this.putConstraint(SpringLayout.WEST, nhisLabel, 74, SpringLayout.EAST, patientInfoLabel);
		nhisLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_this.putConstraint(SpringLayout.SOUTH, nhisLabel, 0, SpringLayout.SOUTH, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.EAST, nhisLabel, 0, SpringLayout.EAST, separator);
		this.add(nhisLabel);

		parityDisplay = new JLabel("N/A");
		sl_this.putConstraint(SpringLayout.NORTH, parityDisplay, 6, SpringLayout.SOUTH, parityLabel);
		sl_this.putConstraint(SpringLayout.WEST, parityDisplay, 0, SpringLayout.WEST, patientInfoLabel);
		parityDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(parityDisplay);

		heightDisplay = new JLabel("N/A");
		sl_this.putConstraint(SpringLayout.NORTH, heightDisplay, 6, SpringLayout.SOUTH, heightLabel);
		sl_this.putConstraint(SpringLayout.WEST, heightDisplay, 0, SpringLayout.WEST, heightLabel);
		heightDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(heightDisplay);

		weightDisplay = new JLabel("N/A");
		sl_this.putConstraint(SpringLayout.NORTH, weightDisplay, 6, SpringLayout.SOUTH, weightLabel);
		sl_this.putConstraint(SpringLayout.WEST, weightDisplay, 0, SpringLayout.WEST, weightLabel);
		weightDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(weightDisplay);

		bloodGroupLabel = new JLabel("Blood Group");
		sl_this.putConstraint(SpringLayout.NORTH, bloodGroupLabel, 16, SpringLayout.SOUTH, parityDisplay);
		sl_this.putConstraint(SpringLayout.WEST, bloodGroupLabel, 0, SpringLayout.WEST, patientInfoLabel);
		add(bloodGroupLabel);

		bloodGroupDisplay = new JLabel("N/A");
		bloodGroupDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, bloodGroupDisplay, 6, SpringLayout.SOUTH, bloodGroupLabel);
		sl_this.putConstraint(SpringLayout.WEST, bloodGroupDisplay, 0, SpringLayout.WEST, patientInfoLabel);
		add(bloodGroupDisplay);

		venerealDiseaseLabel = new JLabel("Venereal Disease Lab");
		sl_this.putConstraint(SpringLayout.NORTH, venerealDiseaseLabel, 0, SpringLayout.NORTH, bloodGroupLabel);
		sl_this.putConstraint(SpringLayout.WEST, venerealDiseaseLabel, 0, SpringLayout.WEST, heightLabel);
		add(venerealDiseaseLabel);

		venerealDiseaseDisplay = new JLabel("N/A");
		venerealDiseaseDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, venerealDiseaseDisplay, 0, SpringLayout.NORTH, bloodGroupDisplay);
		sl_this.putConstraint(SpringLayout.WEST, venerealDiseaseDisplay, 0, SpringLayout.WEST, heightLabel);
		add(venerealDiseaseDisplay);

		sicklingLabel = new JLabel("Sickling");
		sl_this.putConstraint(SpringLayout.NORTH, sicklingLabel, 16, SpringLayout.SOUTH, bloodGroupDisplay);
		sl_this.putConstraint(SpringLayout.WEST, sicklingLabel, 0, SpringLayout.WEST, patientInfoLabel);
		add(sicklingLabel);

		lastVisitLabel = new JLabel("Last Visit:");
		lastVisitLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.WEST, lastVisitLabel, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, lastVisitLabel, -6, SpringLayout.NORTH, separator_1);
		lastVisitLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lastVisitLabel);

		lastVisitDateDisplay = new JLabel("YYYY/MM/DD");
		lastVisitDateDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		lastVisitDateDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_this.putConstraint(SpringLayout.SOUTH, lastVisitDateDisplay, -6, SpringLayout.NORTH, separator_1);
		sl_this.putConstraint(SpringLayout.EAST, lastVisitDateDisplay, 0, SpringLayout.EAST, separator);
		add(lastVisitDateDisplay);

		JSeparator separator_2 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_2, 6, SpringLayout.SOUTH, sicklingLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_2, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator_2, 0, SpringLayout.EAST, venerealDiseaseLabel);
		add(separator_2);

		sicklingStatusDisplay = new JLabel("Negative");
		sicklingStatusDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.NORTH, sicklingStatusDisplay, 6, SpringLayout.SOUTH, separator_2);
		sl_this.putConstraint(SpringLayout.WEST, sicklingStatusDisplay, 0, SpringLayout.WEST, patientInfoLabel);
		add(sicklingStatusDisplay);

		sicklingTypeDisplay = new JLabel("Type");
		sicklingTypeDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.WEST, sicklingTypeDisplay, 0, SpringLayout.WEST, heightLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, sicklingTypeDisplay, 0, SpringLayout.SOUTH, sicklingStatusDisplay);
		add(sicklingTypeDisplay);

		JLabel pmctcLabel = new JLabel("PMCTC");
		sl_this.putConstraint(SpringLayout.NORTH, pmctcLabel, 16, SpringLayout.SOUTH, sicklingStatusDisplay);
		sl_this.putConstraint(SpringLayout.WEST, pmctcLabel, 0, SpringLayout.WEST, patientInfoLabel);
		add(pmctcLabel);

		separator_3 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_3, 6, SpringLayout.SOUTH, pmctcLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_3, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, separator_3, 8, SpringLayout.SOUTH, pmctcLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator_3, 0, SpringLayout.EAST, separator_2);
		add(separator_3);

		pmctcPretestCheckbox = new JCheckBox("Pre-test Counseling");
		pmctcPretestCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, pmctcPretestCheckbox, 6, SpringLayout.SOUTH, separator_3);
		sl_this.putConstraint(SpringLayout.WEST, pmctcPretestCheckbox, 0, SpringLayout.WEST, patientInfoLabel);
		add(pmctcPretestCheckbox);

		pmctcTestCheckbox = new JCheckBox("Positive");
		pmctcTestCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, pmctcTestCheckbox, 6, SpringLayout.SOUTH, pmctcPretestCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, pmctcTestCheckbox, 0, SpringLayout.WEST, patientInfoLabel);
		add(pmctcTestCheckbox);

		pmctcPosttestCheckbox = new JCheckBox("Post-test Counseling");
		pmctcPosttestCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, pmctcPosttestCheckbox, 0, SpringLayout.NORTH, pmctcPretestCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, pmctcPosttestCheckbox, 6, SpringLayout.EAST, pmctcPretestCheckbox);
		add(pmctcPosttestCheckbox);

		pmctcAntiretroviralCheckbox = new JCheckBox("Anti-retroviral Drugs Given");
		pmctcAntiretroviralCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, pmctcAntiretroviralCheckbox, 6, SpringLayout.SOUTH, pmctcPretestCheckbox);
		sl_this.putConstraint(SpringLayout.EAST, pmctcAntiretroviralCheckbox, 0, SpringLayout.EAST, pmctcPosttestCheckbox);
		add(pmctcAntiretroviralCheckbox);

		JSeparator separator_4 = new JSeparator();
		sl_this.putConstraint(SpringLayout.WEST, separator_4, 0, SpringLayout.WEST, lastVisitDateDisplay);
		sl_this.putConstraint(SpringLayout.NORTH, separator_4, 0, SpringLayout.NORTH, separator_2);
		sl_this.putConstraint(SpringLayout.WEST, separator_4, 25, SpringLayout.EAST, separator_2);
		sl_this.putConstraint(SpringLayout.EAST, separator_4, 0, SpringLayout.EAST, separator);
		add(separator_4);

		JLabel ttLabel = new JLabel("TT");
		sl_this.putConstraint(SpringLayout.NORTH, ttLabel, 0, SpringLayout.NORTH, sicklingLabel);
		sl_this.putConstraint(SpringLayout.WEST, ttLabel, 0, SpringLayout.WEST, separator_4);
		add(ttLabel);

		ttFirstCheckbox = new JCheckBox("First Dose");
		ttFirstCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, ttFirstCheckbox, 6, SpringLayout.SOUTH, separator_4);
		sl_this.putConstraint(SpringLayout.WEST, ttFirstCheckbox, 0, SpringLayout.WEST, separator_4);
		add(ttFirstCheckbox);

		ttSecondCheckbox = new JCheckBox("SecondDose");
		ttSecondCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, ttSecondCheckbox, 6, SpringLayout.SOUTH, ttFirstCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, ttSecondCheckbox, 0, SpringLayout.WEST, separator_4);
		add(ttSecondCheckbox);

		ttThirdCheckbox = new JCheckBox("Third Dose");
		ttThirdCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, ttThirdCheckbox, 6, SpringLayout.SOUTH, ttSecondCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, ttThirdCheckbox, 0, SpringLayout.WEST, separator_4);
		add(ttThirdCheckbox);

		ttProtectedCheckbox = new JCheckBox("Protected");
		ttProtectedCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, ttProtectedCheckbox, 6, SpringLayout.SOUTH, ttThirdCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, ttProtectedCheckbox, 0, SpringLayout.WEST, separator_4);
		add(ttProtectedCheckbox);

		iptLabel = new JLabel("IPT");
		sl_this.putConstraint(SpringLayout.NORTH, iptLabel, 16, SpringLayout.SOUTH, pmctcTestCheckbox);
		sl_this.putConstraint(SpringLayout.WEST, iptLabel, 0, SpringLayout.WEST, patientInfoLabel);
		add(iptLabel);

		separator_5 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_5, 6, SpringLayout.SOUTH, iptLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_5, 0, SpringLayout.WEST, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, separator_5, 8, SpringLayout.SOUTH, iptLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator_5, 0, SpringLayout.EAST, separator);
		add(separator_5);

		iptFirstCheckbox = new JCheckBox("First Dose");
		iptFirstCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, iptFirstCheckbox, 6, SpringLayout.SOUTH, separator_5);
		sl_this.putConstraint(SpringLayout.WEST, iptFirstCheckbox, 0, SpringLayout.WEST, patientInfoLabel);
		add(iptFirstCheckbox);

		iptSecondCheckbox = new JCheckBox("Second Dose");
		iptSecondCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.NORTH, iptSecondCheckbox, 0, SpringLayout.NORTH, iptFirstCheckbox);
		add(iptSecondCheckbox);

		iptThirdCheckbox = new JCheckBox("Third Dose");
		iptThirdCheckbox.setEnabled(false);
		sl_this.putConstraint(SpringLayout.EAST, iptSecondCheckbox, -57, SpringLayout.WEST, iptThirdCheckbox);
		sl_this.putConstraint(SpringLayout.NORTH, iptThirdCheckbox, 6, SpringLayout.SOUTH, separator_5);
		sl_this.putConstraint(SpringLayout.WEST, iptThirdCheckbox, 0, SpringLayout.WEST, patientGenderLabel);
		add(iptThirdCheckbox);

		visitListLabel = new JLabel("Previous Visits");
		visitListLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		visitListLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_this.putConstraint(SpringLayout.NORTH, visitListLabel, 0, SpringLayout.NORTH, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.WEST, visitListLabel, 50, SpringLayout.EAST, nhisLabel);
		add(visitListLabel);

		JSeparator separator_6 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_6, 6, SpringLayout.SOUTH, visitListLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_6, 0, SpringLayout.WEST, visitListLabel);
		sl_this.putConstraint(SpringLayout.EAST, separator_6, -10, SpringLayout.EAST, this);
		add(separator_6);

		newVisitBtn = new JButton("New Visit");
		sl_this.putConstraint(SpringLayout.SOUTH, newVisitBtn, 0, SpringLayout.SOUTH, patientInfoLabel);
		sl_this.putConstraint(SpringLayout.EAST, newVisitBtn, 0, SpringLayout.EAST, separator_6);
		add(newVisitBtn);

		visitsList = new JList<Visit>();
		visitsList.setFixedCellHeight(40);
		visitsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		visitsList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		sl_this.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, patientNameLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, scrollPane, -50, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, visitListLabel);
		sl_this.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		scrollPane.setViewportView(visitsList);
		add(scrollPane);

		btnPreviousVisit = new JButton("View Visit");
		sl_this.putConstraint(SpringLayout.SOUTH, visitsList, -6, SpringLayout.NORTH, btnPreviousVisit);
		sl_this.putConstraint(SpringLayout.SOUTH, btnPreviousVisit, -10, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.EAST, btnPreviousVisit, 0, SpringLayout.EAST, separator_6);
		add(btnPreviousVisit);

		visitListHelperLabel = new JLabel("Select a visit to view");
		sl_this.putConstraint(SpringLayout.NORTH, visitListHelperLabel, 6, SpringLayout.SOUTH, visitsList);
		sl_this.putConstraint(SpringLayout.WEST, visitListHelperLabel, 0, SpringLayout.WEST, visitListLabel);
		visitListHelperLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		visitListHelperLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(visitListHelperLabel);
		
		JLabel gestationLabel = new JLabel("Gestation");
		sl_this.putConstraint(SpringLayout.WEST, gestationLabel, 0, SpringLayout.WEST, patientTribeLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, gestationLabel, 0, SpringLayout.SOUTH, bloodGroupLabel);
		add(gestationLabel);
		
		gestationDisplay = new JLabel("N/A");
		gestationDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_this.putConstraint(SpringLayout.WEST, gestationDisplay, 0, SpringLayout.WEST, patientTribeLabel);
		sl_this.putConstraint(SpringLayout.SOUTH, gestationDisplay, 0, SpringLayout.SOUTH, bloodGroupDisplay);
		add(gestationDisplay);
	}

	public void createTab(JTabbedPane tabPanel) {
		tabPane = tabPanel;
		tabPane.addTab("Patient Information", null, this, null);
		tabPane.setEnabledAt(THIS_TAB, false);
	}

	public void displayBasePatientInfo(String nhisNumber, String fullName, String age, String gender, String address, String tribe) {
		nhisLabel.setText(nhisNumber);
		patientNameLabel.setText(fullName);
		patientAgeLabel.setText(age);
		patientGenderLabel.setText(gender);
		patientAddressLabel.setText(address);
		patientTribeLabel.setText(tribe);
	}

	public void populatePatientInfo(PatientInfoModel patientInfo, Pregnancy pregnancy, Visit visit, String gestation) {
		if (patientInfo != null) {
			parityDisplay.setText(patientInfo.getParity()+"");
			heightDisplay.setText(patientInfo.getHeight()+"");
			weightDisplay.setText(visit != null ? visit.getWeight()+"" : "N/A");
			bloodGroupDisplay.setText(patientInfo.getBloodGroup().toString());
			venerealDiseaseDisplay.setText(patientInfo.isVenerealDiseaseLab() ? "Reactive" : "Non-Reactive");
			sicklingStatusDisplay.setText(patientInfo.getSickling().isStatus() ? "Positive" : "Negative");
			sicklingTypeDisplay.setText(patientInfo.getSickling().getType().toString());
			pmctcPretestCheckbox.setSelected(patientInfo.isPmtctPretestCounseling());
			pmctcTestCheckbox.setSelected(patientInfo.isPmtctTestResult());
			pmctcPosttestCheckbox.setSelected(patientInfo.isPmtctPosttestCounseling());
			pmctcAntiretroviralCheckbox.setSelected(patientInfo.isPmtctAntiretroviralDrugsGiven());
			ttFirstCheckbox.setSelected(patientInfo.getTt().isFirstDoseGiven());
			ttSecondCheckbox.setSelected(patientInfo.getTt().isSecondDoseGiven());
			ttThirdCheckbox.setSelected(patientInfo.getTt().isThirdDoseGiven());
			ttProtectedCheckbox.setSelected(patientInfo.getTt().isPreviouslyProtected());
			iptFirstCheckbox.setSelected(patientInfo.getIpt().isFirstDoseGiven());
			iptSecondCheckbox.setSelected(patientInfo.getIpt().isSecondDoseGiven());
			iptThirdCheckbox.setSelected(patientInfo.getIpt().isThirdDoseGiven());
			lastVisitDateDisplay.setText(visit != null ? visit.getVisitDate() : "");
			gestationDisplay.setText(gestation);
		}
	}

	public void populateVisitList(List<Visit> allVisits) {
		if (allVisits == null || allVisits.size() == 0) {
			visitsList.setEnabled(false);
			btnPreviousVisit.setEnabled(false);
			visitListHelperLabel.setText("No previous visits found.");
		} else {
			visitsList.setEnabled(true);
			btnPreviousVisit.setEnabled(true);
			visitListHelperLabel.setText("Select a previous visit to view.");

			visitsList.setListData(new Vector<Visit>(allVisits));
			visitsList.setCellRenderer(new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (renderer instanceof JLabel && value instanceof Visit) {
						((JLabel) renderer).setText(" Visit from: " + ((Visit) value).getVisitDate());
						((JLabel) renderer).setFont(new Font("Tahoma", Font.PLAIN, 16));
						((JLabel) renderer).setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					}
					return renderer;
				}
			});
		}
	}
}

