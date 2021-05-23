package antenatal.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTabbedPane;

import antenatal.models.PatientInfoModel;
import antenatal.models.PatientInfoModel.BloodGroup;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;

public class MonthlyReportPanel extends JPanel {

	public final int THIS_TAB = 3;
	
	public JTabbedPane tabPane;
	JLabel titleLabel;
	private JLabel attendanceValue;
	private JLabel mothersLabel;
	private JLabel mothersValue;
	private JLabel attendanceLabel;
	private JLabel parity0Label;
	private JLabel regLabel;
	private JLabel fourvisitsLabel;
	private JLabel fourvisitsValue;
	private JLabel regValue;
	private JLabel parity1Label;
	private JLabel parity3Label;
	private JLabel parity5Label;
	private JLabel parity0Value;
	private JLabel parity3Value;
	private JLabel parity1Value;
	private JLabel parity5Value;
	private JLabel age20Label;
	private JLabel age15Label;
	private JLabel age10Label;
	private JLabel age15Value;
	private JLabel age10Value;
	private JLabel age20Value;
	private JLabel age25Value;
	private JLabel ageTitle;
	private JLabel age25Label;
	private JLabel age30Label;
	private JLabel age35Label;
	private JLabel age30Value;
	private JLabel age35Value;
	private JLabel haemo1Value;
	private JLabel haemo2Value;
	private JLabel haemo3Value;
	private JLabel haemo4Value;
	private JLabel haemo5Value;
	private JLabel haemo6Value;
	private JLabel durTitle;
	private JLabel dur1Label;
	private JLabel dur2Label;
	private JLabel dur3Label;
	private JLabel dur1Value;
	private JLabel dur2Value;
	private JLabel dur3Value;
	private JLabel iptTitle;
	private JLabel ipt1Label;
	private JLabel ipt2Label;
	private JLabel ipt2Value;
	private JLabel ipt3Label;
	private JLabel ipt3Value;
	private JLabel ipt1Value;
	private JLabel itnTitle;
	private JLabel itn1Label;
	private JLabel itn1Value;
	private JLabel itn2Label;
	private JLabel itn2Value;
	private JLabel pmtctTitle;
	private JLabel pmtct1Label;
	private JLabel pmtct1Value;
	private JLabel pmtct2Label;
	private JLabel pmtct2Value;
	private JLabel pmtct3Label;
	private JLabel pmtct3Value;
	private JLabel ttValue;
	private JLabel monthLabel;
	private JLabel monthValue;
	private JLabel yearLabel;
	private JLabel yearValue;
	
	public MonthlyReportPanel() {
		SpringLayout sl_this = new SpringLayout();
		this.setLayout(sl_this);
		
		titleLabel = new JLabel("Monthly Report");
		titleLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(titleLabel);
		
		JSeparator separator = new JSeparator();
		sl_this.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, separator);
		sl_this.putConstraint(SpringLayout.SOUTH, titleLabel, -6, SpringLayout.NORTH, separator);
		sl_this.putConstraint(SpringLayout.NORTH, separator, 67, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, separator, 21, SpringLayout.WEST, this);
		this.add(separator);
		
		attendanceValue = new JLabel("AttNumber");
		sl_this.putConstraint(SpringLayout.NORTH, attendanceValue, 117, SpringLayout.NORTH, this);
		attendanceValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(attendanceValue);
		
		mothersLabel = new JLabel("Mothers Under 5ft:");
		sl_this.putConstraint(SpringLayout.WEST, mothersLabel, 10, SpringLayout.WEST, this);
		add(mothersLabel);
		
		mothersValue = new JLabel("mothersValue");
		sl_this.putConstraint(SpringLayout.WEST, mothersValue, 6, SpringLayout.EAST, mothersLabel);
		sl_this.putConstraint(SpringLayout.NORTH, mothersLabel, 1, SpringLayout.NORTH, mothersValue);
		mothersValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(mothersValue);
		
		attendanceLabel = new JLabel("Attendances:");
		sl_this.putConstraint(SpringLayout.NORTH, attendanceLabel, 118, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, attendanceValue, 6, SpringLayout.EAST, attendanceLabel);
		add(attendanceLabel);
		
		parity0Label = new JLabel("0:");
		parity0Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(parity0Label);
		
		JLabel parityTitle = new JLabel("<HTML><U>Parity</HTML></U>");
		parityTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(parityTitle);
		
		JLabel ttLabel = new JLabel("TT 2+ Vaccination:");
		sl_this.putConstraint(SpringLayout.WEST, ttLabel, 0, SpringLayout.WEST, attendanceLabel);
		add(ttLabel);
		
		regLabel = new JLabel("Registrants:");
		sl_this.putConstraint(SpringLayout.WEST, regLabel, 10, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.NORTH, ttLabel, 0, SpringLayout.NORTH, regLabel);
		add(regLabel);
		
		fourvisitsLabel = new JLabel("# making 4th visits:");
		sl_this.putConstraint(SpringLayout.NORTH, fourvisitsLabel, 118, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, fourvisitsLabel, 10, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.NORTH, regLabel, 16, SpringLayout.SOUTH, fourvisitsLabel);
		add(fourvisitsLabel);
		
		fourvisitsValue = new JLabel("4thVisits");
		sl_this.putConstraint(SpringLayout.NORTH, fourvisitsValue, -1, SpringLayout.NORTH, fourvisitsLabel);
		sl_this.putConstraint(SpringLayout.WEST, fourvisitsValue, 6, SpringLayout.EAST, fourvisitsLabel);
		fourvisitsValue.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(fourvisitsValue);
		
		regValue = new JLabel("regValue");
		sl_this.putConstraint(SpringLayout.NORTH, mothersValue, 17, SpringLayout.SOUTH, regValue);
		sl_this.putConstraint(SpringLayout.NORTH, regValue, 14, SpringLayout.SOUTH, fourvisitsValue);
		sl_this.putConstraint(SpringLayout.WEST, regValue, 6, SpringLayout.EAST, regLabel);
		regValue.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(regValue);
		
		parity1Label = new JLabel("1-2:");
		sl_this.putConstraint(SpringLayout.SOUTH, parityTitle, -6, SpringLayout.NORTH, parity1Label);
		sl_this.putConstraint(SpringLayout.NORTH, parity0Label, 0, SpringLayout.NORTH, parity1Label);
		sl_this.putConstraint(SpringLayout.NORTH, parity1Label, 235, SpringLayout.NORTH, this);
		parity1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(parity1Label);
		
		parity3Label = new JLabel("3-4:");
		sl_this.putConstraint(SpringLayout.NORTH, parity3Label, 6, SpringLayout.SOUTH, parity0Label);
		sl_this.putConstraint(SpringLayout.EAST, parity0Label, 0, SpringLayout.EAST, parity3Label);
		sl_this.putConstraint(SpringLayout.WEST, parity3Label, 10, SpringLayout.WEST, this);
		parity3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(parity3Label);
		
		parity5Label = new JLabel("5+:");
		sl_this.putConstraint(SpringLayout.NORTH, parity5Label, 0, SpringLayout.NORTH, parity3Label);
		parity5Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(parity5Label);
		
		parity0Value = new JLabel("0Value");
		sl_this.putConstraint(SpringLayout.NORTH, parity0Value, -1, SpringLayout.NORTH, parity0Label);
		parity0Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(parity0Value);
		
		parity3Value = new JLabel("3Value");
		sl_this.putConstraint(SpringLayout.EAST, parity0Value, 0, SpringLayout.EAST, parity3Value);
		sl_this.putConstraint(SpringLayout.NORTH, parity3Value, 0, SpringLayout.NORTH, parity3Label);
		sl_this.putConstraint(SpringLayout.WEST, parity3Value, 6, SpringLayout.EAST, parity3Label);
		parity3Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(parity3Value);
		
		parity1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.WEST, parity1Value, 135, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, parity1Label, -6, SpringLayout.WEST, parity1Value);
		parity1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(parity1Value);
		
		parity5Value = new JLabel("5Value");
		sl_this.putConstraint(SpringLayout.SOUTH, parity1Value, -4, SpringLayout.NORTH, parity5Value);
		sl_this.putConstraint(SpringLayout.WEST, parity5Value, 135, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, parity5Label, -6, SpringLayout.WEST, parity5Value);
		sl_this.putConstraint(SpringLayout.SOUTH, parity5Value, 0, SpringLayout.SOUTH, parity3Label);
		parity5Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(parity5Value);
		
		age20Label = new JLabel("20-24:");
		sl_this.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, age20Label);
		age20Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age20Label);
		
		age15Label = new JLabel("15-19:");
		sl_this.putConstraint(SpringLayout.NORTH, age15Label, 0, SpringLayout.NORTH, parity3Label);
		age15Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age15Label);
		
		age10Label = new JLabel("10-14:");
		sl_this.putConstraint(SpringLayout.NORTH, age10Label, 36, SpringLayout.SOUTH, mothersValue);
		sl_this.putConstraint(SpringLayout.EAST, age15Label, 0, SpringLayout.EAST, age10Label);
		age10Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age10Label);
		
		age15Value = new JLabel("15Value");
		sl_this.putConstraint(SpringLayout.EAST, attendanceLabel, 0, SpringLayout.EAST, age15Value);
		sl_this.putConstraint(SpringLayout.NORTH, age15Value, -1, SpringLayout.NORTH, parity3Label);
		sl_this.putConstraint(SpringLayout.WEST, age15Value, 6, SpringLayout.EAST, age15Label);
		age15Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age15Value);
		
		age10Value = new JLabel("10Value");
		sl_this.putConstraint(SpringLayout.WEST, age10Value, 288, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.SOUTH, age10Value, -4, SpringLayout.NORTH, age15Value);
		sl_this.putConstraint(SpringLayout.EAST, age10Label, -6, SpringLayout.WEST, age10Value);
		age10Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age10Value);
		
		age20Value = new JLabel("20Value");
		sl_this.putConstraint(SpringLayout.WEST, age20Value, 423, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, age20Label, -6, SpringLayout.WEST, age20Value);
		age20Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age20Value);
		
		age25Value = new JLabel("25Value");
		sl_this.putConstraint(SpringLayout.SOUTH, age20Value, -4, SpringLayout.NORTH, age25Value);
		sl_this.putConstraint(SpringLayout.NORTH, age25Value, -1, SpringLayout.NORTH, parity3Label);
		sl_this.putConstraint(SpringLayout.WEST, age25Value, 0, SpringLayout.WEST, age20Value);
		age25Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age25Value);
		
		ageTitle = new JLabel("<HTML><U>Age of Mother at Registration (years)</U></HTML>");
		sl_this.putConstraint(SpringLayout.NORTH, ageTitle, 0, SpringLayout.NORTH, parityTitle);
		sl_this.putConstraint(SpringLayout.WEST, ageTitle, 40, SpringLayout.WEST, attendanceLabel);
		ageTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(ageTitle);
		
		age25Label = new JLabel("25-29:");
		sl_this.putConstraint(SpringLayout.SOUTH, age20Label, -6, SpringLayout.NORTH, age25Label);
		sl_this.putConstraint(SpringLayout.NORTH, age25Label, 0, SpringLayout.NORTH, parity3Label);
		sl_this.putConstraint(SpringLayout.WEST, age25Label, 0, SpringLayout.WEST, age20Label);
		age25Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age25Label);
		
		age30Label = new JLabel("30-34:");
		age30Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age30Label);
		
		age35Label = new JLabel("35+:");
		sl_this.putConstraint(SpringLayout.SOUTH, age30Label, -6, SpringLayout.NORTH, age35Label);
		sl_this.putConstraint(SpringLayout.NORTH, age35Label, 0, SpringLayout.NORTH, parity3Label);
		sl_this.putConstraint(SpringLayout.EAST, age35Label, 0, SpringLayout.EAST, age30Label);
		age35Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(age35Label);
		
		age30Value = new JLabel("30Value");
		sl_this.putConstraint(SpringLayout.WEST, age30Value, 559, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, age30Label, -6, SpringLayout.WEST, age30Value);
		age30Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age30Value);
		
		age35Value = new JLabel("35Value");
		sl_this.putConstraint(SpringLayout.SOUTH, age30Value, -5, SpringLayout.NORTH, age35Value);
		sl_this.putConstraint(SpringLayout.NORTH, age35Value, 0, SpringLayout.NORTH, parity3Value);
		sl_this.putConstraint(SpringLayout.WEST, age35Value, 6, SpringLayout.EAST, age35Label);
		age35Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(age35Value);
		
		JSeparator separator_1 = new JSeparator();
		sl_this.putConstraint(SpringLayout.SOUTH, separator_1, -399, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.NORTH, separator_1, 40, SpringLayout.SOUTH, regLabel);
		sl_this.putConstraint(SpringLayout.WEST, separator_1, 37, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, separator_1, 37, SpringLayout.WEST, this);
		add(separator_1);
		
		JLabel haemoTitle = new JLabel("<HTML><U>Haemoglobin at Reg. & 36 Weeks</HTML></U>");
		haemoTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		sl_this.putConstraint(SpringLayout.WEST, haemoTitle, 183, SpringLayout.WEST, this);
		add(haemoTitle);
		
		JLabel haemo1Label = new JLabel("Clients w/HB at reg:");
		sl_this.putConstraint(SpringLayout.WEST, haemo1Label, 20, SpringLayout.WEST, this);
		haemo1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo1Label);
		
		haemo1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.NORTH, haemo1Value, 322, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, haemo1Value, 4, SpringLayout.EAST, haemo1Label);
		sl_this.putConstraint(SpringLayout.SOUTH, haemoTitle, -6, SpringLayout.NORTH, haemo1Value);
		sl_this.putConstraint(SpringLayout.NORTH, haemo1Label, 1, SpringLayout.NORTH, haemo1Value);
		haemo1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo1Value);
		
		JLabel haemo2Label = new JLabel("Clients HB<11gm/dl:");
		sl_this.putConstraint(SpringLayout.WEST, haemo2Label, 20, SpringLayout.WEST, this);
		haemo2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo2Label);
		
		haemo2Value = new JLabel("2Value");
		sl_this.putConstraint(SpringLayout.WEST, haemo2Value, 3, SpringLayout.EAST, haemo2Label);
		sl_this.putConstraint(SpringLayout.NORTH, haemo2Label, 1, SpringLayout.NORTH, haemo2Value);
		sl_this.putConstraint(SpringLayout.NORTH, haemo2Value, 6, SpringLayout.SOUTH, haemo1Value);
		haemo2Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo2Value);
		
		JLabel haemo4Label = new JLabel("Clients HB at 36w:");
		sl_this.putConstraint(SpringLayout.NORTH, haemo4Label, 0, SpringLayout.NORTH, haemo2Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo4Label, 0, SpringLayout.WEST, age15Label);
		haemo4Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo4Label);
		
		JLabel haemo3Label = new JLabel("Clients HB<7gm/dl:");
		sl_this.putConstraint(SpringLayout.NORTH, haemo3Label, 0, SpringLayout.NORTH, haemo1Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo3Label, 0, SpringLayout.WEST, age15Label);
		haemo3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo3Label);
		
		haemo3Value = new JLabel("3Value");
		sl_this.putConstraint(SpringLayout.NORTH, haemo3Value, -1, SpringLayout.NORTH, haemo1Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo3Value, 0, SpringLayout.WEST, age20Label);
		haemo3Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo3Value);
		
		haemo4Value = new JLabel("4Value");
		sl_this.putConstraint(SpringLayout.NORTH, haemo4Value, -1, SpringLayout.NORTH, haemo2Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo4Value, 0, SpringLayout.WEST, age20Label);
		haemo4Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo4Value);
		
		JLabel haemo5Label = new JLabel("Clients HB<11gm/dl @36w:");
		sl_this.putConstraint(SpringLayout.NORTH, haemo5Label, 0, SpringLayout.NORTH, haemo1Label);
		haemo5Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo5Label);
		
		JLabel haemo6Label = new JLabel("Clients HB<7gm/dl @36w:");
		sl_this.putConstraint(SpringLayout.WEST, haemo6Label, 23, SpringLayout.EAST, haemo4Value);
		sl_this.putConstraint(SpringLayout.WEST, haemo5Label, 0, SpringLayout.WEST, haemo6Label);
		sl_this.putConstraint(SpringLayout.NORTH, haemo6Label, 0, SpringLayout.NORTH, haemo2Label);
		haemo6Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(haemo6Label);
		
		haemo5Value = new JLabel("5Value");
		sl_this.putConstraint(SpringLayout.NORTH, haemo5Value, -1, SpringLayout.NORTH, haemo1Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo5Value, 6, SpringLayout.EAST, haemo5Label);
		haemo5Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo5Value);
		
		haemo6Value = new JLabel("6Value");
		sl_this.putConstraint(SpringLayout.NORTH, haemo6Value, -1, SpringLayout.NORTH, haemo2Label);
		sl_this.putConstraint(SpringLayout.WEST, haemo6Value, 6, SpringLayout.EAST, haemo6Label);
		haemo6Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(haemo6Value);
		
		durTitle = new JLabel("<HTML><U>Duration of Pregnancy at Registration</HTML></U>");
		sl_this.putConstraint(SpringLayout.WEST, durTitle, 54, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.WEST, parityTitle, 0, SpringLayout.WEST, durTitle);
		sl_this.putConstraint(SpringLayout.NORTH, durTitle, 80, SpringLayout.NORTH, haemoTitle);
		durTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(durTitle);
		
		dur1Label = new JLabel("1st Trim:");
		sl_this.putConstraint(SpringLayout.WEST, dur1Label, 0, SpringLayout.WEST, titleLabel);
		dur1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(dur1Label);
		
		dur2Label = new JLabel("2nd Trim:");
		sl_this.putConstraint(SpringLayout.NORTH, dur1Label, 0, SpringLayout.NORTH, dur2Label);
		sl_this.putConstraint(SpringLayout.NORTH, dur2Label, 6, SpringLayout.SOUTH, durTitle);
		sl_this.putConstraint(SpringLayout.WEST, dur2Label, 0, SpringLayout.WEST, haemo1Value);
		dur2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(dur2Label);
		
		dur3Label = new JLabel("3rd Trim:");
		sl_this.putConstraint(SpringLayout.NORTH, dur3Label, 6, SpringLayout.SOUTH, durTitle);
		sl_this.putConstraint(SpringLayout.WEST, dur3Label, 0, SpringLayout.WEST, age15Value);
		dur3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(dur3Label);
		
		dur1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.NORTH, dur1Value, -1, SpringLayout.NORTH, dur1Label);
		sl_this.putConstraint(SpringLayout.WEST, dur1Value, 6, SpringLayout.EAST, dur1Label);
		dur1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(dur1Value);
		
		dur2Value = new JLabel("2Value");
		sl_this.putConstraint(SpringLayout.NORTH, dur2Value, 6, SpringLayout.SOUTH, durTitle);
		sl_this.putConstraint(SpringLayout.WEST, dur2Value, 6, SpringLayout.EAST, dur2Label);
		dur2Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(dur2Value);
		
		dur3Value = new JLabel("3Value");
		sl_this.putConstraint(SpringLayout.NORTH, dur3Value, 5, SpringLayout.SOUTH, durTitle);
		sl_this.putConstraint(SpringLayout.WEST, dur3Value, 6, SpringLayout.EAST, dur3Label);
		dur3Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(dur3Value);
		
		iptTitle = new JLabel("<HTML><U>IPT</HTML></U>");
		sl_this.putConstraint(SpringLayout.WEST, iptTitle, 0, SpringLayout.WEST, regValue);
		iptTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(iptTitle);
		
		ipt1Label = new JLabel("IPT 1:");
		sl_this.putConstraint(SpringLayout.NORTH, ipt1Label, 40, SpringLayout.SOUTH, dur1Label);
		sl_this.putConstraint(SpringLayout.WEST, ipt1Label, 0, SpringLayout.WEST, titleLabel);
		ipt1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(ipt1Label);
		
		ipt2Label = new JLabel("IPT 2:");
		sl_this.putConstraint(SpringLayout.WEST, ipt2Label, 93, SpringLayout.WEST, ipt1Label);
		sl_this.putConstraint(SpringLayout.SOUTH, iptTitle, -6, SpringLayout.NORTH, ipt2Label);
		sl_this.putConstraint(SpringLayout.NORTH, ipt2Label, 457, SpringLayout.NORTH, this);
		ipt2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(ipt2Label);
		
		ipt2Value = new JLabel("2Value");
		sl_this.putConstraint(SpringLayout.NORTH, ipt2Value, 0, SpringLayout.NORTH, ipt2Label);
		sl_this.putConstraint(SpringLayout.WEST, ipt2Value, 43, SpringLayout.WEST, ipt2Label);
		ipt2Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(ipt2Value);
		
		ipt3Label = new JLabel("IPT 3:");
		sl_this.putConstraint(SpringLayout.NORTH, ipt3Label, 0, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, ipt3Label, 95, SpringLayout.WEST, ipt2Label);
		ipt3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(ipt3Label);
		
		ipt3Value = new JLabel("3Value");
		sl_this.putConstraint(SpringLayout.NORTH, ipt3Value, -1, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, ipt3Value, 6, SpringLayout.EAST, ipt3Label);
		ipt3Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(ipt3Value);
		
		ipt1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.NORTH, ipt1Value, 0, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, ipt1Value, 42, SpringLayout.WEST, ipt1Label);
		ipt1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(ipt1Value);
		
		itnTitle = new JLabel("<HTML><U>ITN USE</HTML></U>");
		sl_this.putConstraint(SpringLayout.NORTH, itnTitle, 0, SpringLayout.NORTH, iptTitle);
		sl_this.putConstraint(SpringLayout.WEST, itnTitle, 330, SpringLayout.WEST, iptTitle);
		itnTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(itnTitle);
		
		itn1Label = new JLabel("1st Visit:");
		sl_this.putConstraint(SpringLayout.NORTH, itn1Label, 0, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, itn1Label, 0, SpringLayout.WEST, age20Label);
		itn1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(itn1Label);
		
		itn1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.NORTH, itn1Value, -1, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, itn1Value, 70, SpringLayout.WEST, itn1Label);
		itn1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(itn1Value);
		
		itn2Label = new JLabel("2nd Visit:");
		sl_this.putConstraint(SpringLayout.NORTH, itn2Label, 0, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, itn2Label, 131, SpringLayout.WEST, itn1Label);
		itn2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(itn2Label);
		
		itn2Value = new JLabel("2Value");
		sl_this.putConstraint(SpringLayout.NORTH, itn2Value, -1, SpringLayout.NORTH, ipt1Label);
		sl_this.putConstraint(SpringLayout.WEST, itn2Value, 70, SpringLayout.WEST, itn2Label);
		itn2Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(itn2Value);
		
		pmtctTitle = new JLabel("<HTML><U>PMTCT</HTML></U>");
		sl_this.putConstraint(SpringLayout.WEST, pmtctTitle, 0, SpringLayout.WEST, haemoTitle);
		pmtctTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		add(pmtctTitle);
		
		pmtct1Label = new JLabel("# Counselled:");
		sl_this.putConstraint(SpringLayout.WEST, pmtct1Label, 0, SpringLayout.WEST, titleLabel);
		pmtct1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(pmtct1Label);
		
		pmtct1Value = new JLabel("1Value");
		sl_this.putConstraint(SpringLayout.NORTH, pmtct1Value, 38, SpringLayout.SOUTH, ipt2Value);
		sl_this.putConstraint(SpringLayout.WEST, pmtct1Value, 7, SpringLayout.EAST, pmtct1Label);
		sl_this.putConstraint(SpringLayout.NORTH, pmtct1Label, 1, SpringLayout.NORTH, pmtct1Value);
		pmtct1Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(pmtct1Value);
		
		pmtct2Label = new JLabel("#Tested:");
		sl_this.putConstraint(SpringLayout.SOUTH, pmtctTitle, -6, SpringLayout.NORTH, pmtct2Label);
		sl_this.putConstraint(SpringLayout.NORTH, pmtct2Label, 513, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, pmtct2Label, 0, SpringLayout.WEST, haemoTitle);
		pmtct2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(pmtct2Label);
		
		pmtct2Value = new JLabel("2Value");
		sl_this.putConstraint(SpringLayout.NORTH, pmtct2Value, -1, SpringLayout.NORTH, pmtct1Label);
		sl_this.putConstraint(SpringLayout.WEST, pmtct2Value, 70, SpringLayout.WEST, pmtct2Label);
		pmtct2Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(pmtct2Value);
		
		pmtct3Label = new JLabel("# + ve:");
		sl_this.putConstraint(SpringLayout.NORTH, pmtct3Label, 0, SpringLayout.NORTH, pmtct2Label);
		sl_this.putConstraint(SpringLayout.WEST, pmtct3Label, 120, SpringLayout.WEST, pmtct2Label);
		pmtct3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		add(pmtct3Label);
		
		pmtct3Value = new JLabel("3Value");
		sl_this.putConstraint(SpringLayout.NORTH, pmtct3Value, 0, SpringLayout.NORTH, pmtct3Label);
		sl_this.putConstraint(SpringLayout.WEST, pmtct3Value, 53, SpringLayout.WEST, pmtct3Label);
		pmtct3Value.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(pmtct3Value);
		
		ttValue = new JLabel("ttValue");
		sl_this.putConstraint(SpringLayout.NORTH, ttValue, -1, SpringLayout.NORTH, ttLabel);
		sl_this.putConstraint(SpringLayout.WEST, ttValue, 6, SpringLayout.EAST, ttLabel);
		ttValue.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(ttValue);
		
		monthLabel = new JLabel("Month:");
		sl_this.putConstraint(SpringLayout.NORTH, monthLabel, 91, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, monthLabel, 10, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.SOUTH, separator, -9, SpringLayout.NORTH, monthLabel);
		monthLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		add(monthLabel);
		
		monthValue = new JLabel("10Value");
		sl_this.putConstraint(SpringLayout.NORTH, monthValue, 9, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.WEST, monthValue, 60, SpringLayout.WEST, this);
		monthValue.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(monthValue);
		
		yearLabel = new JLabel("Year:");
		sl_this.putConstraint(SpringLayout.NORTH, yearLabel, 9, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.WEST, yearLabel, 0, SpringLayout.WEST, attendanceLabel);
		yearLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		add(yearLabel);
		
		yearValue = new JLabel("10Value");
		sl_this.putConstraint(SpringLayout.NORTH, yearValue, 9, SpringLayout.SOUTH, separator);
		sl_this.putConstraint(SpringLayout.WEST, yearValue, 40, SpringLayout.WEST, yearLabel);
		yearValue.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(yearValue);
	}
	
	public void createTab(JTabbedPane tabPanel) {
		tabPane = tabPanel;
		tabPane.addTab("Monthly Report", null, this, null);
		tabPane.setEnabledAt(THIS_TAB, false);
	}

	public void displayReport(int month, int year, int numReg, int numAtt, int num4thVisit, int[] age, 
		int below5ft, int[] parity, int[] hg, int[] durationPregnancyAtReg, int[] iptCounts,
		int TTVaccine2Plus, int[] pmtctCounts, int[] itn) {
			monthValue.setText(Integer.valueOf(month).toString());
			yearValue.setText(Integer.valueOf(year).toString());
			regValue.setText(Integer.valueOf(numReg).toString());
			attendanceValue.setText(Integer.valueOf(numAtt).toString());
			fourvisitsValue.setText(Integer.valueOf(num4thVisit).toString());
			age10Value.setText(Integer.valueOf(age[0]).toString());
			age15Value.setText(Integer.valueOf(age[1]).toString());
			age20Value.setText(Integer.valueOf(age[2]).toString());
			age25Value.setText(Integer.valueOf(age[3]).toString());
			age30Value.setText(Integer.valueOf(age[4]).toString());
			age35Value.setText(Integer.valueOf(age[5]).toString());
			mothersValue.setText(Integer.valueOf(below5ft).toString());
			parity0Value.setText(Integer.valueOf(parity[0]).toString());
			parity1Value.setText(Integer.valueOf(parity[1]).toString());
			parity3Value.setText(Integer.valueOf(parity[2]).toString());
			parity5Value.setText(Integer.valueOf(parity[3]).toString());
			haemo1Value.setText(Integer.valueOf(hg[0]).toString());
			haemo2Value.setText(Integer.valueOf(hg[1]).toString());
			haemo3Value.setText(Integer.valueOf(hg[2]).toString());
			haemo4Value.setText(Integer.valueOf(hg[3]).toString());
			haemo5Value.setText(Integer.valueOf(hg[4]).toString());
			haemo6Value.setText(Integer.valueOf(hg[5]).toString());
			dur1Value.setText(Integer.valueOf(durationPregnancyAtReg[0]).toString());
			dur2Value.setText(Integer.valueOf(durationPregnancyAtReg[1]).toString());
			dur3Value.setText(Integer.valueOf(durationPregnancyAtReg[2]).toString());
			ipt1Value.setText(Integer.valueOf(iptCounts[0]).toString());
			ipt2Value.setText(Integer.valueOf(iptCounts[1]).toString());
			ipt3Value.setText(Integer.valueOf(iptCounts[2]).toString());
			ttValue.setText(Integer.valueOf(TTVaccine2Plus).toString());
			pmtct1Value.setText(Integer.valueOf(pmtctCounts[0]).toString());
			pmtct2Value.setText(Integer.valueOf(pmtctCounts[1]).toString());
			pmtct3Value.setText(Integer.valueOf(pmtctCounts[2]).toString());
			itn1Value.setText(Integer.valueOf(itn[0]).toString());
			itn2Value.setText(Integer.valueOf(itn[1]).toString());
	}
}

