package antenatal.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import antenatal.models.PatientInfoModel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import antenatal.models.PatientInfoModel.BloodGroup;
import antenatal.models.PatientInfoModel.Sickling;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import antenatal.models.Visit.BloodPressure;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import antenatal.controllers.VisitController.VisitDTO;

import java.util.regex.*;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class InitialVisitPanel extends JPanel {

	public final int THIS_TAB = 2;

	public JLabel visitDate;
	public JButton btnSubmitInfo;
	public JLabel lblPatientNumber;
	public JLabel lblNumber;
	public JTabbedPane tabPanel;
	private JTextField eddEntry;
	private JTextField gestationEntry;
	private JLabel gestationLabel;
	private JTextField hemoglobin0Entry;
	private JLabel hemoglobing0Label;
	private JLabel gestationHelper;
	private JLabel hemoglobinHelper_2;
	private JTextField hemoglobin36Entry;
	private JLabel hemoglobin36Label;
	private JLabel hemoglobinHelper;
	private JLabel heightLabel;
	private JTextField heightEntry;
	private JLabel heightHelper;
	private JTextField txtParity;
	private JLabel parityLabel;
	private JComboBox<BloodGroup> bloodGroupComboBox;
	private JLabel bloodGroupLabel;
	private JCheckBox chckbxPositive;
	private JComboBox<Sickling.Type> sicklingComboBox;
	private JLabel sicklingTypeLabel;
	private JSeparator separator;
	private JLabel sicklingLabel;
	private JLabel PmtctLabel;
	private JSeparator separator_1;
	private JCheckBox chckbxPretestCounseling;
	private JCheckBox chckbxPosttestCounseling;
	private JCheckBox chckbxPositive_1;
	private JCheckBox chckbxAntiretroviral;
	private JSeparator separator_3;
	private JLabel ttLabel;
	private JCheckBox chckbxProtected;
	private JCheckBox chckbxTT1;
	private JCheckBox chckbxTT2;
	private JCheckBox chckbxTT3;
	private JCheckBox chckbxTT4;
	private JCheckBox chckbxTT5;
	private JLabel weightLabel;
	private JTextField weightEntry;
	private JTextField fundalHeightEntry;
	private JLabel fundalHeightLabel;
	private JTextField txtSystolic;
	private JLabel bpSeperator;
	private JTextField txtDiastolic;
	private JLabel bloodPressureLabel;
	private JLabel bloodPressureHelper;
	private JLabel fundalHeightHelper;
	private JLabel weightHelper;
	private JCheckBox chckbxVenerealDiseaseLab;
	private JSeparator separator_4;
	private JLabel iptLabel;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JEditorPane complaintEntry;
	private JEditorPane remarkEntry;
	private JLabel remarksLabel;
	private JCheckBox chckbxBloodFilm;
	private JCheckBox chckbxItnInUse;
	private JCheckBox chckbxReferred;
	private JTextPane venerealDiseaseLabLabel;
	public JLabel saveFailedAlert;
	public JButton btnCancel;
	private JCheckBox chckbxTerminatePregnancy;

	public InitialVisitPanel() {

		setBounds(100, 100, 804, 568);

		SpringLayout sl_this = new SpringLayout();
		this.setLayout(sl_this);

		JLabel visitLabel = new JLabel("Visit");
		visitLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(sl_this.NORTH, visitLabel, 10, sl_this.NORTH, this);
		sl_this.putConstraint(sl_this.WEST, visitLabel, 10, sl_this.WEST, this);
		visitLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(visitLabel);

		JSeparator separator_2 = new JSeparator();
		sl_this.putConstraint(sl_this.NORTH, separator_2, 6, SpringLayout.SOUTH, visitLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_2, 0, SpringLayout.WEST, visitLabel);
		sl_this.putConstraint(sl_this.SOUTH, separator_2, 8, sl_this.SOUTH, visitLabel);
		this.add(separator_2);

		visitDate = new JLabel();
		sl_this.putConstraint(SpringLayout.NORTH, visitDate, 0, SpringLayout.NORTH, visitLabel);
		sl_this.putConstraint(SpringLayout.WEST, visitDate, 6, SpringLayout.EAST, visitLabel);
		visitDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		visitDate.setText("YYYY/MM/DD");
		this.add(visitDate);


		btnSubmitInfo = new JButton("Submit Info");
		sl_this.putConstraint(SpringLayout.SOUTH, btnSubmitInfo, -10, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.EAST, btnSubmitInfo, 0, SpringLayout.EAST, separator_2);
		this.add(btnSubmitInfo);

		lblPatientNumber = new JLabel("Patient: ");
		lblPatientNumber.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.NORTH, lblPatientNumber, -1, SpringLayout.NORTH, visitLabel);
		lblPatientNumber.setFont(new Font("Dialog", Font.PLAIN, 16));
		this.add(lblPatientNumber);

		lblNumber = new JLabel("0000000");
		sl_this.putConstraint(SpringLayout.EAST, separator_2, 0, SpringLayout.EAST, lblNumber);
		sl_this.putConstraint(SpringLayout.EAST, lblNumber, -10, SpringLayout.EAST, this);
		sl_this.putConstraint(SpringLayout.EAST, lblPatientNumber, -6, SpringLayout.WEST, lblNumber);
		sl_this.putConstraint(SpringLayout.NORTH, lblNumber, 0, SpringLayout.NORTH, visitLabel);
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(lblNumber);

		JLabel eddLabel = new JLabel("Est' Day of Delivery");
		sl_this.putConstraint(SpringLayout.NORTH, eddLabel, 6, SpringLayout.SOUTH, separator_2);
		sl_this.putConstraint(SpringLayout.WEST, eddLabel, 0, SpringLayout.WEST, visitLabel);
		add(eddLabel);

		eddEntry = new JTextField();
		eddEntry.setForeground(new Color(0, 0, 0));
		sl_this.putConstraint(SpringLayout.NORTH, eddEntry, 6, SpringLayout.SOUTH, eddLabel);
		sl_this.putConstraint(SpringLayout.WEST, eddEntry, 0, SpringLayout.WEST, visitLabel);
		add(eddEntry);
		eddEntry.setColumns(14);

		JLabel eddFormatHelper = new JLabel("YYYY-MM-DD");
		sl_this.putConstraint(SpringLayout.NORTH, eddFormatHelper, 6, SpringLayout.SOUTH, eddEntry);
		sl_this.putConstraint(SpringLayout.EAST, eddFormatHelper, 0, SpringLayout.EAST, eddEntry);
		eddFormatHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		add(eddFormatHelper);

		gestationEntry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, gestationEntry, 0, SpringLayout.NORTH, eddEntry);
		sl_this.putConstraint(SpringLayout.WEST, gestationEntry, 50, SpringLayout.EAST, eddEntry);
		add(gestationEntry);
		gestationEntry.setColumns(14);

		gestationLabel = new JLabel("Gestation at Registration");
		sl_this.putConstraint(SpringLayout.WEST, gestationLabel, 0, SpringLayout.WEST, gestationEntry);
		sl_this.putConstraint(SpringLayout.SOUTH, gestationLabel, 0, SpringLayout.SOUTH, eddLabel);
		add(gestationLabel);

		hemoglobin0Entry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, hemoglobin0Entry, 0, SpringLayout.NORTH, eddEntry);
		sl_this.putConstraint(SpringLayout.WEST, hemoglobin0Entry, 50, SpringLayout.EAST, gestationEntry);
		hemoglobin0Entry.setColumns(14);
		add(hemoglobin0Entry);

		hemoglobing0Label = new JLabel("Hemoglobin at Registration");
		sl_this.putConstraint(SpringLayout.WEST, hemoglobing0Label, 0, SpringLayout.WEST, hemoglobin0Entry);
		sl_this.putConstraint(SpringLayout.SOUTH, hemoglobing0Label, 0, SpringLayout.SOUTH, eddLabel);
		add(hemoglobing0Label);

		gestationHelper = new JLabel("(in weeks)");
		gestationHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.SOUTH, gestationHelper, 0, SpringLayout.SOUTH, eddFormatHelper);
		sl_this.putConstraint(SpringLayout.EAST, gestationHelper, 0, SpringLayout.EAST, gestationEntry);
		add(gestationHelper);

		hemoglobinHelper_2 = new JLabel("(in gm/dl)");
		hemoglobinHelper_2.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.SOUTH, hemoglobinHelper_2, 0, SpringLayout.SOUTH, eddFormatHelper);
		sl_this.putConstraint(SpringLayout.EAST, hemoglobinHelper_2, 0, SpringLayout.EAST, hemoglobin0Entry);
		add(hemoglobinHelper_2);

		hemoglobin36Entry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, hemoglobin36Entry, 0, SpringLayout.NORTH, eddEntry);
		sl_this.putConstraint(SpringLayout.WEST, hemoglobin36Entry, 50, SpringLayout.EAST, hemoglobin0Entry);
		hemoglobin36Entry.setColumns(14);
		add(hemoglobin36Entry);

		hemoglobin36Label = new JLabel("Hemoglobin at 36 weeks");
		sl_this.putConstraint(SpringLayout.WEST, hemoglobin36Label, 0, SpringLayout.WEST, hemoglobin36Entry);
		sl_this.putConstraint(SpringLayout.SOUTH, hemoglobin36Label, 0, SpringLayout.SOUTH, eddLabel);
		add(hemoglobin36Label);

		hemoglobinHelper = new JLabel("(in gm/dl)");
		sl_this.putConstraint(SpringLayout.NORTH, hemoglobinHelper, 0, SpringLayout.NORTH, eddFormatHelper);
		sl_this.putConstraint(SpringLayout.EAST, hemoglobinHelper, 0, SpringLayout.EAST, hemoglobin36Entry);
		hemoglobinHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		add(hemoglobinHelper);

		heightLabel = new JLabel("Height at Registration");
		sl_this.putConstraint(SpringLayout.NORTH, heightLabel, 25, SpringLayout.SOUTH, eddFormatHelper);
		sl_this.putConstraint(SpringLayout.WEST, heightLabel, 0, SpringLayout.WEST, eddEntry);
		add(heightLabel);

		heightEntry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, heightEntry, 6, SpringLayout.SOUTH, heightLabel);
		sl_this.putConstraint(SpringLayout.WEST, heightEntry, 0, SpringLayout.WEST, visitLabel);
		add(heightEntry);
		heightEntry.setColumns(14);

		heightHelper = new JLabel("(in cm)");
		heightHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.NORTH, heightHelper, 6, SpringLayout.SOUTH, heightEntry);
		sl_this.putConstraint(SpringLayout.EAST, heightHelper, 0, SpringLayout.EAST, heightEntry);
		add(heightHelper);

		txtParity = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, txtParity, 0, SpringLayout.NORTH, heightEntry);
		sl_this.putConstraint(SpringLayout.WEST, txtParity, 50, SpringLayout.EAST, heightEntry);
		add(txtParity);
		txtParity.setColumns(10);

		parityLabel = new JLabel("Parity");
		sl_this.putConstraint(SpringLayout.NORTH, parityLabel, 0, SpringLayout.NORTH, heightLabel);
		sl_this.putConstraint(SpringLayout.WEST, parityLabel, 0, SpringLayout.WEST, txtParity);
		add(parityLabel);

		bloodGroupComboBox = new JComboBox<BloodGroup>();
		sl_this.putConstraint(SpringLayout.WEST, bloodGroupComboBox, 50, SpringLayout.EAST, txtParity);
		sl_this.putConstraint(SpringLayout.EAST, bloodGroupComboBox, 135, SpringLayout.EAST, txtParity);
		bloodGroupComboBox.setModel(new DefaultComboBoxModel<BloodGroup>(BloodGroup.values()));
		add(bloodGroupComboBox);

		bloodGroupLabel = new JLabel("Blood Group");
		sl_this.putConstraint(SpringLayout.WEST, bloodGroupLabel, 120, SpringLayout.EAST, parityLabel);
		sl_this.putConstraint(SpringLayout.NORTH, bloodGroupComboBox, 6, SpringLayout.SOUTH, bloodGroupLabel);
		sl_this.putConstraint(SpringLayout.NORTH, bloodGroupLabel, 0, SpringLayout.NORTH, heightLabel);
		add(bloodGroupLabel);

		chckbxPositive = new JCheckBox("Positive");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxPositive, -1, SpringLayout.NORTH, heightEntry);
		sl_this.putConstraint(SpringLayout.WEST, chckbxPositive, 50, SpringLayout.EAST, bloodGroupComboBox);
		add(chckbxPositive);

		sicklingComboBox = new JComboBox<Sickling.Type>();
		sl_this.putConstraint(SpringLayout.EAST, sicklingComboBox, 0, SpringLayout.EAST, hemoglobin36Entry);
		sicklingComboBox.setModel(new DefaultComboBoxModel<Sickling.Type>(Sickling.Type.values()));
		add(sicklingComboBox);

		sicklingTypeLabel = new JLabel("Type:");
		sl_this.putConstraint(SpringLayout.WEST, sicklingComboBox, 6, SpringLayout.EAST, sicklingTypeLabel);
		sl_this.putConstraint(SpringLayout.NORTH, sicklingTypeLabel, 3, SpringLayout.NORTH, heightEntry);
		sl_this.putConstraint(SpringLayout.WEST, sicklingTypeLabel, 50, SpringLayout.EAST, chckbxPositive);
		add(sicklingTypeLabel);

		separator = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator, 139, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.SOUTH, separator, -3, SpringLayout.NORTH, chckbxPositive);
		sl_this.putConstraint(SpringLayout.NORTH, sicklingComboBox, 4, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, chckbxPositive);
		sl_this.putConstraint(SpringLayout.EAST, separator, -14, SpringLayout.EAST, this);
		add(separator);

		sicklingLabel = new JLabel("Sickling");
		sl_this.putConstraint(SpringLayout.WEST, sicklingLabel, 0, SpringLayout.WEST, separator);
		sl_this.putConstraint(SpringLayout.SOUTH, sicklingLabel, 0, SpringLayout.NORTH, separator);
		add(sicklingLabel);

		PmtctLabel = new JLabel("Prevention of Mother to Child Transmission");
		sl_this.putConstraint(SpringLayout.NORTH, PmtctLabel, 25, SpringLayout.SOUTH, heightHelper);
		sl_this.putConstraint(SpringLayout.WEST, PmtctLabel, 0, SpringLayout.WEST, heightEntry);
		add(PmtctLabel);

		separator_1 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_1, 0, SpringLayout.SOUTH, PmtctLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_1, 10, SpringLayout.WEST, this);
		add(separator_1);

		chckbxPretestCounseling = new JCheckBox("Pretest Counseling");
		sl_this.putConstraint(SpringLayout.SOUTH, separator_1, -4, SpringLayout.NORTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.NORTH, chckbxPretestCounseling, 6, SpringLayout.SOUTH, PmtctLabel);
		sl_this.putConstraint(SpringLayout.WEST, chckbxPretestCounseling, 0, SpringLayout.WEST, visitLabel);
		add(chckbxPretestCounseling);

		chckbxPosttestCounseling = new JCheckBox("Posttest Counseling");
		sl_this.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, chckbxPosttestCounseling);
		sl_this.putConstraint(SpringLayout.NORTH, chckbxPosttestCounseling, 0, SpringLayout.NORTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.WEST, chckbxPosttestCounseling, 6, SpringLayout.EAST, chckbxPretestCounseling);
		add(chckbxPosttestCounseling);

		chckbxPositive_1 = new JCheckBox("Postive");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxPositive_1, 6, SpringLayout.SOUTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.WEST, chckbxPositive_1, 0, SpringLayout.WEST, visitLabel);
		add(chckbxPositive_1);

		chckbxAntiretroviral = new JCheckBox("Anti-retroviral drugs given");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxAntiretroviral, 0, SpringLayout.NORTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.EAST, chckbxAntiretroviral, 0, SpringLayout.EAST, chckbxPosttestCounseling);
		add(chckbxAntiretroviral);

		chckbxProtected = new JCheckBox("Pre-Protected");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxProtected, 0, SpringLayout.NORTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.WEST, chckbxProtected, 50, SpringLayout.EAST, chckbxPosttestCounseling);
		add(chckbxProtected);
		chckbxProtected.setEnabled(false);

		ttLabel = new JLabel("Tetanus Boosters");
		sl_this.putConstraint(SpringLayout.NORTH, ttLabel, 0, SpringLayout.NORTH, PmtctLabel);
		sl_this.putConstraint(SpringLayout.WEST, ttLabel, 0, SpringLayout.WEST, chckbxProtected);
		add(ttLabel);

		chckbxTT1 = new JCheckBox("Booster 1");
		sl_this.putConstraint(SpringLayout.WEST, chckbxTT1, 6, SpringLayout.EAST, chckbxProtected);
		sl_this.putConstraint(SpringLayout.SOUTH, chckbxTT1, 0, SpringLayout.SOUTH, chckbxPretestCounseling);
		add(chckbxTT1);
		chckbxTT1.setEnabled(false);


		chckbxTT2 = new JCheckBox("Booster 2");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxTT2, 0, SpringLayout.NORTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.WEST, chckbxTT2, 6, SpringLayout.EAST, chckbxTT1);
		add(chckbxTT2);
		chckbxTT2.setEnabled(false);


		chckbxTT3 = new JCheckBox("Booster 3");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxTT3, 0, SpringLayout.NORTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.WEST, chckbxTT3, 0, SpringLayout.WEST, chckbxProtected);
		add(chckbxTT3);
		chckbxTT3.setEnabled(false);


		chckbxTT4 = new JCheckBox("Booster 4");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxTT4, 0, SpringLayout.NORTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.WEST, chckbxTT4, 0, SpringLayout.WEST, chckbxTT1);
		add(chckbxTT4);
		chckbxTT4.setEnabled(false);


		chckbxTT5 = new JCheckBox("Booster 5");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxTT5, 0, SpringLayout.NORTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.WEST, chckbxTT5, 0, SpringLayout.WEST, chckbxTT2);
		add(chckbxTT5);
		chckbxTT5.setEnabled(false);


		separator_3 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_3, 0, SpringLayout.NORTH, separator_1);
		sl_this.putConstraint(SpringLayout.WEST, separator_3, 0, SpringLayout.WEST, chckbxProtected);
		sl_this.putConstraint(SpringLayout.SOUTH, separator_3, 2, SpringLayout.NORTH, separator_1);
		sl_this.putConstraint(SpringLayout.EAST, separator_3, 0, SpringLayout.EAST, chckbxTT2);
		add(separator_3);

		weightLabel = new JLabel("Weight");
		sl_this.putConstraint(SpringLayout.NORTH, weightLabel, 25, SpringLayout.SOUTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.WEST, weightLabel, 0, SpringLayout.WEST, visitLabel);
		add(weightLabel);

		weightEntry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, weightEntry, 6, SpringLayout.SOUTH, weightLabel);
		sl_this.putConstraint(SpringLayout.WEST, weightEntry, 0, SpringLayout.WEST, visitLabel);
		add(weightEntry);
		weightEntry.setColumns(10);

		fundalHeightEntry = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, fundalHeightEntry, 0, SpringLayout.NORTH, weightEntry);
		sl_this.putConstraint(SpringLayout.WEST, fundalHeightEntry, 50, SpringLayout.EAST, weightEntry);
		add(fundalHeightEntry);
		fundalHeightEntry.setColumns(10);

		fundalHeightLabel = new JLabel("Fundal Height");
		sl_this.putConstraint(SpringLayout.WEST, fundalHeightLabel, 0, SpringLayout.WEST, fundalHeightEntry);
		sl_this.putConstraint(SpringLayout.SOUTH, fundalHeightLabel, 0, SpringLayout.SOUTH, weightLabel);
		add(fundalHeightLabel);

		txtSystolic = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, txtSystolic, 0, SpringLayout.NORTH, weightEntry);
		sl_this.putConstraint(SpringLayout.WEST, txtSystolic, 50, SpringLayout.EAST, fundalHeightEntry);
		add(txtSystolic);
		txtSystolic.setColumns(4);

		bpSeperator = new JLabel("/");
		sl_this.putConstraint(SpringLayout.SOUTH, bpSeperator, 0, SpringLayout.SOUTH, txtSystolic);
		sl_this.putConstraint(SpringLayout.WEST, bpSeperator, 6, SpringLayout.EAST, txtSystolic);
		bpSeperator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(bpSeperator);

		txtDiastolic = new JTextField();
		sl_this.putConstraint(SpringLayout.NORTH, txtDiastolic, 0, SpringLayout.NORTH, weightEntry);
		sl_this.putConstraint(SpringLayout.WEST, txtDiastolic, 6, SpringLayout.EAST, bpSeperator);
		txtDiastolic.setColumns(4);
		add(txtDiastolic);

		bloodPressureLabel = new JLabel("Blood Pressure");
		sl_this.putConstraint(SpringLayout.WEST, bloodPressureLabel, 0, SpringLayout.WEST, txtSystolic);
		sl_this.putConstraint(SpringLayout.SOUTH, bloodPressureLabel, 0, SpringLayout.SOUTH, weightLabel);
		add(bloodPressureLabel);

		bloodPressureHelper = new JLabel("(in mmHg)");
		bloodPressureHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.NORTH, bloodPressureHelper, 6, SpringLayout.SOUTH, txtDiastolic);
		sl_this.putConstraint(SpringLayout.EAST, bloodPressureHelper, 0, SpringLayout.EAST, txtDiastolic);
		add(bloodPressureHelper);

		fundalHeightHelper = new JLabel("(in cm)");
		fundalHeightHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.NORTH, fundalHeightHelper, 6, SpringLayout.SOUTH, fundalHeightEntry);
		sl_this.putConstraint(SpringLayout.EAST, fundalHeightHelper, 0, SpringLayout.EAST, fundalHeightEntry);
		add(fundalHeightHelper);

		weightHelper = new JLabel("(in kg)");
		weightHelper.setForeground(UIManager.getColor("Button.darkShadow"));
		sl_this.putConstraint(SpringLayout.NORTH, weightHelper, 6, SpringLayout.SOUTH, weightEntry);
		sl_this.putConstraint(SpringLayout.EAST, weightHelper, 0, SpringLayout.EAST, weightEntry);
		add(weightHelper);

		separator_4 = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator_4, 0, SpringLayout.NORTH, separator_1);
		sl_this.putConstraint(SpringLayout.EAST, separator_4, 0, SpringLayout.EAST, separator);
		sl_this.putConstraint(SpringLayout.WEST, separator_4, 50, SpringLayout.EAST, separator_3);
		add(separator_4);

		iptLabel = new JLabel("IPT");
		sl_this.putConstraint(SpringLayout.NORTH, iptLabel, 0, SpringLayout.NORTH, PmtctLabel);
		sl_this.putConstraint(SpringLayout.WEST, iptLabel, 0, SpringLayout.WEST, separator_4);
		add(iptLabel);

		checkBox_1 = new JCheckBox("Dose 1");
		sl_this.putConstraint(SpringLayout.NORTH, checkBox_1, 0, SpringLayout.NORTH, chckbxPretestCounseling);
		sl_this.putConstraint(SpringLayout.WEST, checkBox_1, 0, SpringLayout.WEST, separator_4);
		add(checkBox_1);
		checkBox_1.setEnabled(false);

		checkBox_2 = new JCheckBox("Dose 2");
		sl_this.putConstraint(SpringLayout.NORTH, checkBox_2, 0, SpringLayout.NORTH, chckbxPositive_1);
		sl_this.putConstraint(SpringLayout.WEST, checkBox_2, 0, SpringLayout.WEST, separator_4);
		add(checkBox_2);
		checkBox_2.setEnabled(false);


		checkBox_3 = new JCheckBox("Dose 3");
		sl_this.putConstraint(SpringLayout.NORTH, checkBox_3, 6, SpringLayout.SOUTH, checkBox_2);
		sl_this.putConstraint(SpringLayout.WEST, checkBox_3, 0, SpringLayout.WEST, separator_4);
		add(checkBox_3);
		checkBox_3.setEnabled(false);


		chckbxVenerealDiseaseLab = new JCheckBox("");
		sl_this.putConstraint(SpringLayout.WEST, chckbxVenerealDiseaseLab, 0, SpringLayout.WEST, separator_4);
		sl_this.putConstraint(SpringLayout.NORTH, chckbxVenerealDiseaseLab, 25, SpringLayout.SOUTH, checkBox_3);
		add(chckbxVenerealDiseaseLab);

		JLabel complaintsLabel = new JLabel("Complaints");
		sl_this.putConstraint(SpringLayout.NORTH, complaintsLabel, 25, SpringLayout.SOUTH, weightHelper);
		sl_this.putConstraint(SpringLayout.WEST, complaintsLabel, 0, SpringLayout.WEST, weightEntry);
		add(complaintsLabel);

		complaintEntry = new JEditorPane();
		complaintEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		sl_this.putConstraint(SpringLayout.NORTH, complaintEntry, 6, SpringLayout.SOUTH, complaintsLabel);
		sl_this.putConstraint(SpringLayout.WEST, complaintEntry, 10, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.SOUTH, complaintEntry, 0, SpringLayout.SOUTH, btnSubmitInfo);
		sl_this.putConstraint(SpringLayout.EAST, complaintEntry, 0, SpringLayout.EAST, separator_1);
		add(complaintEntry);

		remarkEntry = new JEditorPane();
		remarkEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		sl_this.putConstraint(SpringLayout.NORTH, remarkEntry, 0, SpringLayout.NORTH, complaintEntry);
		sl_this.putConstraint(SpringLayout.WEST, remarkEntry, 0, SpringLayout.WEST, separator_3);
		sl_this.putConstraint(SpringLayout.SOUTH, remarkEntry, 0, SpringLayout.SOUTH, btnSubmitInfo);
		sl_this.putConstraint(SpringLayout.EAST, remarkEntry, 0, SpringLayout.EAST, separator_3);
		add(remarkEntry);

		remarksLabel = new JLabel("Remarks");
		sl_this.putConstraint(SpringLayout.NORTH, remarksLabel, 0, SpringLayout.NORTH, complaintsLabel);
		sl_this.putConstraint(SpringLayout.WEST, remarksLabel, 0, SpringLayout.WEST, separator_3);
		add(remarksLabel);

		chckbxBloodFilm = new JCheckBox("Blood Film");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxBloodFilm, 25, SpringLayout.SOUTH, chckbxVenerealDiseaseLab);
		sl_this.putConstraint(SpringLayout.WEST, chckbxBloodFilm, 0, SpringLayout.WEST, separator_4);
		add(chckbxBloodFilm);

		chckbxItnInUse = new JCheckBox("ITN in use");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxItnInUse, 25, SpringLayout.SOUTH, chckbxBloodFilm);
		sl_this.putConstraint(SpringLayout.WEST, chckbxItnInUse, 0, SpringLayout.WEST, separator_4);
		add(chckbxItnInUse);

		chckbxReferred = new JCheckBox("Referred");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxReferred, 25, SpringLayout.SOUTH, chckbxItnInUse);
		sl_this.putConstraint(SpringLayout.WEST, chckbxReferred, 0, SpringLayout.WEST, separator_4);
		add(chckbxReferred);

		venerealDiseaseLabLabel = new JTextPane();
		venerealDiseaseLabLabel.setEditable(false);
		venerealDiseaseLabLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_this.putConstraint(SpringLayout.NORTH, venerealDiseaseLabLabel, 20, SpringLayout.SOUTH, checkBox_3);
		sl_this.putConstraint(SpringLayout.WEST, venerealDiseaseLabLabel, 0, SpringLayout.EAST, chckbxVenerealDiseaseLab);
		sl_this.putConstraint(SpringLayout.SOUTH, venerealDiseaseLabLabel, -18, SpringLayout.NORTH, chckbxBloodFilm);
		venerealDiseaseLabLabel.setBackground(UIManager.getColor("Button.background"));
		venerealDiseaseLabLabel.setText("Venereal Disease\nLab Results");
		add(venerealDiseaseLabLabel);

		saveFailedAlert = new JLabel("");
		saveFailedAlert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveFailedAlert.setForeground(Color.RED);
		sl_this.putConstraint(SpringLayout.SOUTH, saveFailedAlert, -6, SpringLayout.NORTH, btnSubmitInfo);
		sl_this.putConstraint(SpringLayout.EAST, saveFailedAlert, 0, SpringLayout.EAST, btnSubmitInfo);
		add(saveFailedAlert);

		btnCancel = new JButton("Cancel");
		sl_this.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnSubmitInfo);
		sl_this.putConstraint(SpringLayout.EAST, btnCancel, -6, SpringLayout.WEST, btnSubmitInfo);
		add(btnCancel);

		chckbxTerminatePregnancy = new JCheckBox("Pregnancy Terminated");
		sl_this.putConstraint(SpringLayout.NORTH, chckbxTerminatePregnancy, 15, SpringLayout.SOUTH, chckbxReferred);
		sl_this.putConstraint(SpringLayout.WEST, chckbxTerminatePregnancy, 0, SpringLayout.WEST, separator_4);
		add(chckbxTerminatePregnancy);
	}

	public void createTab(JTabbedPane tabPane) {
		tabPanel = tabPane;
		tabPanel.addTab("Visit Information", null, this, null);
		tabPanel.setEnabledAt(THIS_TAB, false);
	}

	public VisitDTO populateDTO() {
		resetBorders();

		Double weight = 0.0;
		Double fundalHeight = 0.0;
		Double height = 0.0;
		Double hemoglobin0 = 0.0;
		Double hemoglobin36 = 0.0;
		Integer gestation = 0;
		Integer parity = 0;
		int systolic = 0;
		int diastolic = 0;

		StringBuilder entriesFailed = new StringBuilder();
		ArrayList<String> failedEntries = new ArrayList<String>();


		VisitDTO dto;

		String edd = eddEntry.getText();

		boolean valid = true;

		if (!Pattern.matches("[12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])", edd)) {
			failedEntries.add("Date");
			eddEntry.setBorder(new LineBorder(Color.RED,2));
			valid = false;
		}

		try {
			weight = Double.parseDouble(weightEntry.getText());   
			if(weight < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Weight");
			weightEntry.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			fundalHeight = Double.parseDouble(fundalHeightEntry.getText());
			if(fundalHeight < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Fundal Height");
			fundalHeightEntry.setBorder(new LineBorder(Color.RED,2));

			valid = false;              
		}

		try {
			height = Double.parseDouble(heightEntry.getText());
			if(height < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Height");
			heightEntry.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			hemoglobin0 = Double.parseDouble(hemoglobin0Entry.getText());
			if(hemoglobin0 < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Hemoglobin 0");
			hemoglobin0Entry.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			hemoglobin36 = Double.parseDouble(hemoglobin36Entry.getText());
			if(hemoglobin36 < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Hemoglobin 36");
			hemoglobin36Entry.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			gestation = Integer.parseInt(gestationEntry.getText());
			if(gestation < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Gestation");
			gestationEntry.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			parity = Integer.parseInt(txtParity.getText());
			if(parity < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Parity");
			txtParity.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			systolic = Integer.parseInt(txtSystolic.getText());
			if(systolic < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Systolic BP");
			txtSystolic.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		try {
			diastolic = Integer.parseInt(txtDiastolic.getText());
			if(diastolic < 0) {
				throw new Exception();
			}
		}catch(Exception e){
			failedEntries.add("Diastolic BP");
			txtDiastolic.setBorder(new LineBorder(Color.RED,2));
			valid = false;              
		}

		PatientInfoModel.BloodGroup bloodGroup = (BloodGroup)bloodGroupComboBox.getSelectedItem();
		PatientInfoModel.Sickling sickling = new Sickling(chckbxPositive.isSelected(), (Sickling.Type) sicklingComboBox.getSelectedItem());

		boolean venerealDiseaseLab = chckbxVenerealDiseaseLab.isSelected();
		boolean pretest = chckbxPretestCounseling.isSelected();
		boolean testResult = chckbxPositive_1.isSelected();
		boolean posttest = chckbxPosttestCounseling.isSelected();
		boolean antiretroviral = chckbxAntiretroviral.isSelected();
		boolean itn = chckbxItnInUse.isSelected();
		boolean terminated = chckbxTerminatePregnancy.isSelected();

		PatientInfoModel.TT tt = new PatientInfoModel.TT();
		tt.setPreviouslyProtected(chckbxProtected.isSelected());
		tt.setFirstDoseGiven(chckbxTT1.isSelected());
		tt.setSecondDoseGiven(chckbxTT2.isSelected());
		tt.setThirdDoseGiven(chckbxTT3.isSelected());
		tt.setFourthDoseGiven(chckbxTT4.isSelected());
		tt.setFifthDoseGiven(chckbxTT5.isSelected());

		String complaint = complaintEntry.getText();
		String remark = remarkEntry.getText();
		boolean referred = chckbxReferred.isSelected();

		PatientInfoModel.IPT ipt = new PatientInfoModel.IPT(checkBox_1.isSelected(), checkBox_2.isSelected(), checkBox_3.isSelected());

		BloodPressure bloodPressure = new BloodPressure(systolic,diastolic);

		if(!valid) {
			String error = String.join(", ", failedEntries);
			System.out.println("Not valid");
			JOptionPane.showMessageDialog(null, error+" were not in the correct format, please verify your entries.","Save Failed",JOptionPane.ERROR_MESSAGE);

		}else {
			dto = new VisitDTO(edd, height, weight, fundalHeight, hemoglobin0, hemoglobin36, gestation, parity, bloodGroup, sickling,venerealDiseaseLab, pretest, testResult,
					posttest, antiretroviral, tt, ipt, bloodPressure, complaint, remark, referred, itn, terminated);
			return dto; 
		}
		return null;
	}

	public void displayInitialVisit(String patientId) {
		lblNumber.setText(patientId);
		chckbxProtected.setEnabled(true);
		chckbxTT1.setEnabled(true);
		checkBox_1.setEnabled(true);
		sicklingComboBox.setEnabled(false);
	}
	
	public void displayNewPregnancyVisit(PatientInfoModel patientInfoModel) {
		resetBorders();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		visitDate.setText(sdf.format(new Date()));
		
		lblNumber.setText(patientInfoModel.getPatientId());
		chckbxPositive.setSelected(patientInfoModel.getSickling().isStatus());
		sicklingComboBox.setSelectedItem(patientInfoModel.getSickling().getType());
		if(patientInfoModel.getSickling().isStatus()) {
			chckbxPositive.setEnabled(false);;
		}
		
		if (patientInfoModel.isPmtctTestResult()) {
			chckbxPositive_1.setSelected(patientInfoModel.isPmtctTestResult());
			chckbxPretestCounseling.setSelected(patientInfoModel.isPmtctPretestCounseling());
			chckbxPosttestCounseling.setSelected(patientInfoModel.isPmtctPosttestCounseling());
			chckbxAntiretroviral.setSelected(patientInfoModel.isPmtctAntiretroviralDrugsGiven());

			if(chckbxPositive_1.isSelected()) {
				chckbxPositive_1.setEnabled(false);
			}else {
				chckbxPositive_1.setEnabled(true);
			}

			if(chckbxPretestCounseling.isSelected()) {
				chckbxPretestCounseling.setEnabled(false);
			}else {
				chckbxPretestCounseling.setEnabled(true);
			}

			if(chckbxPosttestCounseling.isSelected()) {
				chckbxPosttestCounseling.setEnabled(false);
			}else {
				chckbxPosttestCounseling.setEnabled(true);
			}

			if(chckbxAntiretroviral.isSelected()) {
				chckbxAntiretroviral.setEnabled(false);
			}else {
				chckbxAntiretroviral.setEnabled(true);
			}
		}
		
		bloodGroupComboBox.setSelectedItem(patientInfoModel.getBloodGroup());
		bloodGroupComboBox.setEnabled(false);
		
		//TT checkboxes
		chckbxProtected.setSelected(patientInfoModel.getTt().previouslyProtected);
		chckbxTT1.setSelected(patientInfoModel.getTt().isFirstDoseGiven());
		chckbxTT2.setSelected(patientInfoModel.getTt().isSecondDoseGiven());
		chckbxTT3.setSelected(patientInfoModel.getTt().isThirdDoseGiven());
		chckbxTT4.setSelected(patientInfoModel.getTt().isFourthDoseGiven());
		chckbxTT5.setSelected(patientInfoModel.getTt().isFifthDoseGiven());

		//IPT checkboxes
		checkBox_1.setSelected(patientInfoModel.getIpt().isFirstDoseGiven());
		checkBox_2.setSelected(patientInfoModel.getIpt().isSecondDoseGiven());
		checkBox_3.setSelected(patientInfoModel.getIpt().isThirdDoseGiven());
		
		switch (patientInfoModel.getTt().getNumberOfShots()) {

		case 5:
			break;
		case 4:
			chckbxTT5.setEnabled(true);
			break;
		case 3:
			chckbxTT4.setEnabled(true);
			break;
		case 2:
			chckbxTT3.setEnabled(true);
			break;
		case 1:
			chckbxTT2.setEnabled(true);
			break;
		case 0:
			chckbxProtected.setEnabled(true);
			chckbxTT1.setEnabled(true);
			break;
		}

		switch (patientInfoModel.getIpt().getNumberOfShots()) {
		case 2:
			checkBox_3.setEnabled(true);
			break;
		case 1:
			checkBox_2.setEnabled(true);
			break;

		case 0:
			checkBox_1.setEnabled(true);
			break;
		}
		
	}

	public void displaySubsequentVisit(PatientInfoModel patientInfoModel, Pregnancy pregnancy){



		resetBorders();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		visitDate.setText(sdf.format(new Date()));
		lblNumber.setText(patientInfoModel.getPatientId());
		String edd = pregnancy.getEDD();

		if (edd.equals("")){
			edd = "yyyy-mm-dd";
		}

		eddEntry.setText(edd);
		eddEntry.setEnabled(false);

		gestationEntry.setText(pregnancy.getGestation().toString());
		gestationEntry.setEnabled(false);
		hemoglobin0Entry.setText(pregnancy.getHemoglobin0().toString());
		hemoglobin0Entry.setEnabled(false);
		hemoglobin36Entry.setText(pregnancy.getHemoglobin36().toString());
		if(pregnancy.getGestation() < 36 || pregnancy.getHemoglobin36() != 0) {
			hemoglobin36Entry.setEnabled(false);
		}else {           
			hemoglobin36Entry.setEnabled(true);
		}
		heightEntry.setText(patientInfoModel.getHeight().toString());
		heightEntry.setEnabled(false);
		txtParity.setText(patientInfoModel.getParity()+""); 
		txtParity.setEnabled(false);
		bloodGroupComboBox.setSelectedItem(patientInfoModel.getBloodGroup());
		bloodGroupComboBox.setEnabled(false);


		//Sickling combobox & checkbox
		chckbxPositive.setSelected(patientInfoModel.getSickling().isStatus());
		sicklingComboBox.setSelectedItem(patientInfoModel.getSickling().getType());
		if(patientInfoModel.getSickling().isStatus()) {
			chckbxPositive.setEnabled(false);;
		}

		chckbxPositive.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				sicklingComboBox.setEnabled(chckbxPositive.isSelected());
				if(!chckbxPositive.isSelected()) {
					sicklingComboBox.setSelectedItem(Sickling.Type.None);
				}
			}

		});

		sicklingComboBox.setEnabled(false);

		//PMTCT checkboxes
		chckbxPositive_1.setSelected(patientInfoModel.isPmtctTestResult());
		chckbxPretestCounseling.setSelected(patientInfoModel.isPmtctPretestCounseling());
		chckbxPosttestCounseling.setSelected(patientInfoModel.isPmtctPosttestCounseling());
		chckbxAntiretroviral.setSelected(patientInfoModel.isPmtctAntiretroviralDrugsGiven());

		if(chckbxPositive_1.isSelected()) {
			chckbxPositive_1.setEnabled(false);
		}else {
			chckbxPositive_1.setEnabled(true);

		}

		if(chckbxPretestCounseling.isSelected()) {
			chckbxPretestCounseling.setEnabled(false);
		}else {
			chckbxPretestCounseling.setEnabled(true);

		}

		if(chckbxPosttestCounseling.isSelected()) {
			chckbxPosttestCounseling.setEnabled(false);
		}else {
			chckbxPosttestCounseling.setEnabled(true);

		}

		if(chckbxAntiretroviral.isSelected()) {
			chckbxAntiretroviral.setEnabled(false);
		}else {
			chckbxAntiretroviral.setEnabled(true);

		}




		//TT checkboxes
		chckbxProtected.setSelected(patientInfoModel.getTt().previouslyProtected);
		chckbxTT1.setSelected(patientInfoModel.getTt().isFirstDoseGiven());
		chckbxTT2.setSelected(patientInfoModel.getTt().isSecondDoseGiven());
		chckbxTT3.setSelected(patientInfoModel.getTt().isThirdDoseGiven());
		chckbxTT4.setSelected(patientInfoModel.getTt().isFourthDoseGiven());
		chckbxTT5.setSelected(patientInfoModel.getTt().isFifthDoseGiven());

		//IPT checkboxes
		checkBox_1.setSelected(patientInfoModel.getIpt().isFirstDoseGiven());
		checkBox_2.setSelected(patientInfoModel.getIpt().isSecondDoseGiven());
		checkBox_3.setSelected(patientInfoModel.getIpt().isThirdDoseGiven());

		chckbxVenerealDiseaseLab.setSelected(patientInfoModel.isVenerealDiseaseLab());

		if(chckbxVenerealDiseaseLab.isSelected()) {
			chckbxVenerealDiseaseLab.setEnabled(false);
		}

		switch (patientInfoModel.getTt().getNumberOfShots()) {

		case 5:
			break;
		case 4:
			chckbxTT5.setEnabled(true);
			break;
		case 3:
			chckbxTT4.setEnabled(true);
			break;
		case 2:
			chckbxTT3.setEnabled(true);
			break;
		case 1:
			chckbxTT2.setEnabled(true);
			break;
		case 0:
			chckbxProtected.setEnabled(true);
			chckbxTT1.setEnabled(true);
			break;
		}




		switch (patientInfoModel.getIpt().getNumberOfShots()) {
		case 2:
			checkBox_3.setEnabled(true);
			break;
		case 1:
			checkBox_2.setEnabled(true);
			break;

		case 0:
			checkBox_1.setEnabled(true);
			break;
		}
	}

	public void resetBorders() {
		eddEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		gestationEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		hemoglobin0Entry.setBorder(new LineBorder(new Color(227,227,227),1));
		hemoglobin36Entry.setBorder(new LineBorder(new Color(227,227,227),1));
		heightEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		txtParity.setBorder(new LineBorder(new Color(227,227,227),1));
		weightEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		fundalHeightEntry.setBorder(new LineBorder(new Color(227,227,227),1));
		txtSystolic.setBorder(new LineBorder(new Color(227,227,227),1));
		txtDiastolic.setBorder(new LineBorder(new Color(227,227,227),1));
	}

	public void clear() {

		lblNumber.setText("");

		String edd = "yyyy-mm-dd";

		eddEntry.setText(edd);
		hemoglobin36Entry.setText("");
		hemoglobin0Entry.setText("");
		gestationEntry.setText("");
		txtParity.setText("");
		fundalHeightEntry.setText("");
		visitDate.setText("");
		weightEntry.setText("");
		complaintEntry.setText("");
		remarkEntry.setText("");
		heightEntry.setText("");
		
		eddEntry.setEnabled(true);
		hemoglobin36Entry.setEnabled(true);
		gestationEntry.setEnabled(true);
		hemoglobin0Entry.setEnabled(true);
		txtParity.setEnabled(true);
		heightEntry.setEnabled(true);


		chckbxVenerealDiseaseLab.setSelected(false);
		chckbxPositive.setSelected(false);
		sicklingComboBox.setSelectedItem(PatientInfoModel.Sickling.Type.AS);
		chckbxPositive_1.setSelected(false);
		chckbxPretestCounseling.setSelected(false);
		chckbxPosttestCounseling.setSelected(false);
		chckbxAntiretroviral.setSelected(false);
		chckbxTerminatePregnancy.setSelected(false);

		chckbxBloodFilm.setSelected(false);
		chckbxItnInUse.setSelected(false);
		chckbxReferred.setSelected(false);

		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);

		checkBox_1.setEnabled(false);
		checkBox_2.setEnabled(false);
		checkBox_3.setEnabled(false);



		txtSystolic.setText("");
		txtDiastolic.setText("");

		chckbxProtected.setEnabled(false);
		chckbxTT1.setEnabled(false);
		chckbxTT2.setEnabled(false);
		chckbxTT3.setEnabled(false);
		chckbxTT4.setEnabled(false);
		chckbxTT5.setEnabled(false);
	}
}