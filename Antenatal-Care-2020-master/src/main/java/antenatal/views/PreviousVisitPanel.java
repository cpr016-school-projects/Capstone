package antenatal.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import antenatal.models.PatientInfoModel;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;

public class PreviousVisitPanel extends JFrame {

    JLabel dateLabel;
    JLabel patientIDLabel;
    JLabel gestationValue;
    JLabel hemoglobin0Value;
    JLabel hemoglobin36Value;
    JLabel weightValue;
    JLabel fundalHeightValue;
    JLabel bloodPressureValue;
    JTextPane complaintsValue;
    JTextPane remarksValue;
    JCheckBox checkboxITN;
    JCheckBox chckbxReferred;


    public PreviousVisitPanel() {
        setResizable(false);

        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);

        JLabel visitDateLabel = new JLabel("Visited on:");
        springLayout.putConstraint(SpringLayout.NORTH, visitDateLabel, 10, SpringLayout.NORTH, getContentPane());
        visitDateLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        springLayout.putConstraint(SpringLayout.WEST, visitDateLabel, 10, SpringLayout.WEST, getContentPane());
        getContentPane().add(visitDateLabel);

        dateLabel = new JLabel("YYYY-mm-dd");
        springLayout.putConstraint(SpringLayout.NORTH, dateLabel, 0, SpringLayout.NORTH, visitDateLabel);
        springLayout.putConstraint(SpringLayout.WEST, dateLabel, 6, SpringLayout.EAST, visitDateLabel);
        getContentPane().add(dateLabel);

        patientIDLabel = new JLabel("00000000");
        springLayout.putConstraint(SpringLayout.NORTH, patientIDLabel, 0, SpringLayout.NORTH, visitDateLabel);
        getContentPane().add(patientIDLabel);

        JSeparator separator = new JSeparator();
        springLayout.putConstraint(SpringLayout.WEST, separator, 10, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, separator, -10, SpringLayout.EAST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, patientIDLabel, 0, SpringLayout.EAST, separator);
        springLayout.putConstraint(SpringLayout.NORTH, separator, 6, SpringLayout.SOUTH, visitDateLabel);
        getContentPane().add(separator);

        JLabel gestationLabel = new JLabel("Gestation");
        gestationLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        springLayout.putConstraint(SpringLayout.NORTH, gestationLabel, 6, SpringLayout.SOUTH, separator);
        springLayout.putConstraint(SpringLayout.WEST, gestationLabel, 0, SpringLayout.WEST, visitDateLabel);
        gestationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(gestationLabel);

        gestationValue = new JLabel("7 weeks");
        springLayout.putConstraint(SpringLayout.NORTH, gestationValue, 6, SpringLayout.SOUTH, gestationLabel);
        springLayout.putConstraint(SpringLayout.WEST, gestationValue, 0, SpringLayout.WEST, visitDateLabel);
        springLayout.putConstraint(SpringLayout.EAST, gestationValue, 0, SpringLayout.EAST, visitDateLabel);
        gestationValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(gestationValue);

        JLabel hemoglobin0Label = new JLabel("Hemoglobin at registration");
        springLayout.putConstraint(SpringLayout.NORTH, hemoglobin0Label, 0, SpringLayout.NORTH, gestationLabel);
        springLayout.putConstraint(SpringLayout.WEST, hemoglobin0Label, 72, SpringLayout.EAST, gestationLabel);
        hemoglobin0Label.setForeground(UIManager.getColor("Button.darkShadow"));
        hemoglobin0Label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(hemoglobin0Label);

        hemoglobin0Value = new JLabel("0.0gm/dl");
        springLayout.putConstraint(SpringLayout.NORTH, hemoglobin0Value, 0, SpringLayout.NORTH, gestationValue);
        springLayout.putConstraint(SpringLayout.WEST, hemoglobin0Value, 72, SpringLayout.EAST, gestationValue);
        hemoglobin0Value.setHorizontalAlignment(SwingConstants.CENTER);
        hemoglobin0Value.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(hemoglobin0Value);

        JLabel hemoglobin36Label = new JLabel("Hemoglobin at 36 weeks");
        springLayout.putConstraint(SpringLayout.EAST, hemoglobin0Label, -43, SpringLayout.WEST, hemoglobin36Label);
        springLayout.putConstraint(SpringLayout.NORTH, hemoglobin36Label, 0, SpringLayout.NORTH, gestationLabel);
        springLayout.putConstraint(SpringLayout.WEST, hemoglobin36Label, 318, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, hemoglobin36Label, 0, SpringLayout.EAST, patientIDLabel);
        hemoglobin36Label.setForeground(UIManager.getColor("Button.darkShadow"));
        hemoglobin36Label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(hemoglobin36Label);

        hemoglobin36Value = new JLabel("0.0gm/dl");
        springLayout.putConstraint(SpringLayout.EAST, hemoglobin0Value, -49, SpringLayout.WEST, hemoglobin36Value);
        springLayout.putConstraint(SpringLayout.NORTH, hemoglobin36Value, 0, SpringLayout.NORTH, gestationValue);
        springLayout.putConstraint(SpringLayout.WEST, hemoglobin36Value, 315, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, hemoglobin36Value, 0, SpringLayout.EAST, patientIDLabel);
        hemoglobin36Value.setHorizontalAlignment(SwingConstants.CENTER);
        hemoglobin36Value.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(hemoglobin36Value);

        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weightLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(weightLabel);

        weightValue = new JLabel("120kg");
        springLayout.putConstraint(SpringLayout.WEST, weightLabel, 0, SpringLayout.WEST, weightValue);
        springLayout.putConstraint(SpringLayout.SOUTH, weightLabel, -6, SpringLayout.NORTH, weightValue);
        springLayout.putConstraint(SpringLayout.EAST, weightLabel, 0, SpringLayout.EAST, weightValue);
        springLayout.putConstraint(SpringLayout.NORTH, weightValue, 116, SpringLayout.NORTH, getContentPane());
        weightValue.setHorizontalAlignment(SwingConstants.CENTER);
        weightValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(weightValue);

        JLabel fundalHeightLabel = new JLabel("Fundal height");
        springLayout.putConstraint(SpringLayout.EAST, fundalHeightLabel, -54, SpringLayout.EAST, getContentPane());
        fundalHeightLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        fundalHeightLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(fundalHeightLabel);

        fundalHeightValue = new JLabel("0.0cm");
        springLayout.putConstraint(SpringLayout.SOUTH, fundalHeightLabel, -6, SpringLayout.NORTH, fundalHeightValue);
        springLayout.putConstraint(SpringLayout.EAST, weightValue, -89, SpringLayout.WEST, fundalHeightValue);
        springLayout.putConstraint(SpringLayout.NORTH, fundalHeightValue, 0, SpringLayout.NORTH, weightValue);
        springLayout.putConstraint(SpringLayout.WEST, fundalHeightValue, 0, SpringLayout.WEST, fundalHeightLabel);
        springLayout.putConstraint(SpringLayout.EAST, fundalHeightValue, -57, SpringLayout.EAST, getContentPane());
        fundalHeightValue.setHorizontalAlignment(SwingConstants.CENTER);
        fundalHeightValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(fundalHeightValue);

        JLabel bloodPressureLabel = new JLabel("Blood pressure");
        bloodPressureLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        springLayout.putConstraint(SpringLayout.WEST, bloodPressureLabel, 0, SpringLayout.WEST, visitDateLabel);
        bloodPressureLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(bloodPressureLabel);

        bloodPressureValue = new JLabel("120/60 mmHG");
        springLayout.putConstraint(SpringLayout.WEST, weightValue, 103, SpringLayout.EAST, bloodPressureValue);
        bloodPressureValue.setHorizontalAlignment(SwingConstants.CENTER);
        springLayout.putConstraint(SpringLayout.NORTH, bloodPressureValue, 116, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, bloodPressureLabel, -6, SpringLayout.NORTH, bloodPressureValue);
        springLayout.putConstraint(SpringLayout.WEST, bloodPressureValue, 0, SpringLayout.WEST, visitDateLabel);
        bloodPressureValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(bloodPressureValue);

        JLabel complaintsLabel = new JLabel("Complaints");
        complaintsLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        springLayout.putConstraint(SpringLayout.NORTH, complaintsLabel, 30, SpringLayout.SOUTH, bloodPressureValue);
        springLayout.putConstraint(SpringLayout.WEST, complaintsLabel, 0, SpringLayout.WEST, visitDateLabel);
        complaintsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(complaintsLabel);

        complaintsValue = new JTextPane();
        springLayout.putConstraint(SpringLayout.NORTH, complaintsValue, 6, SpringLayout.SOUTH, complaintsLabel);
        springLayout.putConstraint(SpringLayout.WEST, complaintsValue, 10, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, complaintsValue, -10, SpringLayout.SOUTH, getContentPane());
        complaintsValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        complaintsValue.setText("Complaint...");
        complaintsValue.setBackground(UIManager.getColor("Panel.background"));
        complaintsValue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        complaintsValue.setEditable(false);
        getContentPane().add(complaintsValue);

        JLabel remarksLabel = new JLabel("Remark");
        remarksLabel.setForeground(UIManager.getColor("Button.darkShadow"));
        springLayout.putConstraint(SpringLayout.NORTH, remarksLabel, 0, SpringLayout.NORTH, complaintsLabel);
        springLayout.putConstraint(SpringLayout.WEST, remarksLabel, 121, SpringLayout.EAST, complaintsLabel);
        remarksLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(remarksLabel);

        remarksValue = new JTextPane();
        springLayout.putConstraint(SpringLayout.EAST, complaintsValue, -31, SpringLayout.WEST, remarksValue);
        springLayout.putConstraint(SpringLayout.NORTH, remarksValue, 6, SpringLayout.SOUTH, remarksLabel);
        springLayout.putConstraint(SpringLayout.SOUTH, remarksValue, -10, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, remarksValue, 185, SpringLayout.WEST, getContentPane());
        remarksValue.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        remarksValue.setText("Remark..");
        remarksValue.setBackground(UIManager.getColor("Panel.background"));
        remarksValue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        remarksValue.setEditable(false);
        getContentPane().add(remarksValue);

        checkboxITN = new JCheckBox("ITN in use");
        checkboxITN.setEnabled(false);
        springLayout.putConstraint(SpringLayout.NORTH, checkboxITN, -4, SpringLayout.NORTH, complaintsLabel);
        checkboxITN.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(checkboxITN);

        chckbxReferred = new JCheckBox("Referred");
        chckbxReferred.setEnabled(false);
        springLayout.putConstraint(SpringLayout.NORTH, chckbxReferred, 23, SpringLayout.SOUTH, checkboxITN);
        springLayout.putConstraint(SpringLayout.WEST, checkboxITN, 0, SpringLayout.WEST, chckbxReferred);
        springLayout.putConstraint(SpringLayout.WEST, chckbxReferred, 357, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, remarksValue, -20, SpringLayout.WEST, chckbxReferred);
        chckbxReferred.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        getContentPane().add(chckbxReferred);
    }



    public void displayVisit(Visit visit, Pregnancy pregnancy, PatientInfoModel patientInfoModel, int gestation) {
        dateLabel.setText(visit.getVisitDate());
        patientIDLabel.setText(visit.getPatientId());
        if (gestation > 0) {
        	gestationValue.setText(gestation+"");
    	} else {
    		gestationValue.setText("N/A");
    	}
        
        hemoglobin0Value.setText(pregnancy.getHemoglobin0().toString());
        if (gestation >= 36) {
            hemoglobin36Value.setText(pregnancy.getHemoglobin36().toString());
        } else {
            hemoglobin36Value.setText("N/A");
        }

        weightValue.setText(visit.getWeight()+"");
        fundalHeightValue.setText(visit.getFundalHeight()+"");
        bloodPressureValue.setText(visit.getBloodPressure().getSystolicBP()+" / "+visit.getBloodPressure().getDiastolicBP());
        complaintsValue.setText(visit.getComplaints());
        remarksValue.setText(visit.getRemarks());
        checkboxITN.setSelected(visit.isItnInUse());
        chckbxReferred.setSelected(visit.getReferred());
    }
}
