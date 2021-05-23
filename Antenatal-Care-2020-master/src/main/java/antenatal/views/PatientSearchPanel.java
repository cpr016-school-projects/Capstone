package antenatal.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import antenatal.models.PatientInfoModel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;


public class PatientSearchPanel extends JPanel {
	
	JLabel patientSearchLabel; 
	public JTextField patientSearchTextField;

	public JSpinner datePicker;

	JLabel patientSearchHelp; 
	public JButton searchBtn; 
	public JButton generateBtn;
	
	public PatientSearchPanel() {
		
	    setBounds(100, 100, 955, 724);
		SpringLayout sl_this = new SpringLayout();
		this.setLayout(sl_this);
		
		this.patientSearchLabel = new JLabel("Patient Search");
		sl_this.putConstraint(SpringLayout.WEST, patientSearchLabel, 384, SpringLayout.WEST, this);
		patientSearchLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(patientSearchLabel);
		
		patientSearchTextField = new JTextField();
		sl_this.putConstraint(SpringLayout.SOUTH, patientSearchLabel, -6, SpringLayout.NORTH, patientSearchTextField);
		sl_this.putConstraint(SpringLayout.NORTH, patientSearchTextField, 232, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, patientSearchTextField, 351, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, patientSearchTextField, -430, SpringLayout.EAST, this);
		this.add(patientSearchTextField);
		patientSearchTextField.setColumns(10);
		
		patientSearchHelp = new JLabel("Search by Patient NHIS Number");
		sl_this.putConstraint(SpringLayout.WEST, patientSearchHelp, 10, SpringLayout.WEST, patientSearchTextField);
		sl_this.putConstraint(SpringLayout.EAST, patientSearchHelp, 557, SpringLayout.WEST, this);
		this.add(patientSearchHelp);
		
		searchBtn = new JButton("Search");
		sl_this.putConstraint(SpringLayout.NORTH, patientSearchHelp, 5, SpringLayout.SOUTH, searchBtn);
		sl_this.putConstraint(SpringLayout.NORTH, searchBtn, -1, SpringLayout.NORTH, patientSearchTextField);
		sl_this.putConstraint(SpringLayout.WEST, searchBtn, 6, SpringLayout.EAST, patientSearchTextField);
		sl_this.putConstraint(SpringLayout.EAST, searchBtn, -325, SpringLayout.EAST, this);
		this.add(searchBtn);
		
		
		JLabel generateReportLabel = new JLabel("Generate Report");
		sl_this.putConstraint(SpringLayout.EAST, generateReportLabel, 0, SpringLayout.EAST, patientSearchLabel);
		generateReportLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(generateReportLabel);
		
		JSeparator separator = new JSeparator();
		sl_this.putConstraint(SpringLayout.NORTH, separator, 21, SpringLayout.SOUTH, patientSearchHelp);
		sl_this.putConstraint(SpringLayout.NORTH, generateReportLabel, 21, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.WEST, separator, 131, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, separator, -154, SpringLayout.EAST, this);
		add(separator);
		
		
		datePicker = new JSpinner(new SpinnerDateModel());
		sl_this.putConstraint(SpringLayout.NORTH, datePicker, 6, SpringLayout.SOUTH, generateReportLabel);
		sl_this.putConstraint(SpringLayout.WEST, datePicker, 355, SpringLayout.WEST, this);
		JSpinner.DateEditor de_datePicker = new JSpinner.DateEditor(datePicker, "MM-yyyy");
		datePicker.setEditor(de_datePicker);
		datePicker.setValue(new Date());
		add(datePicker);
		
		generateBtn = new JButton("Generate");
		sl_this.putConstraint(SpringLayout.EAST, datePicker, -6, SpringLayout.WEST, generateBtn);
		sl_this.putConstraint(SpringLayout.NORTH, generateBtn, -1, SpringLayout.NORTH, datePicker);
		sl_this.putConstraint(SpringLayout.WEST, generateBtn, 0, SpringLayout.WEST, searchBtn);
		add(generateBtn);
	}
	
	public void createTab(JTabbedPane tabPanel) {
		tabPanel.addTab("Home", null, this, null);
	}

	public void searchInvalid() {
		patientSearchHelp.setText("That search is not valid.");
	}

}


