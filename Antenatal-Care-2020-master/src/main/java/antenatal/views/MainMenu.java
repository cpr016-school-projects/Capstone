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
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import antenatal.models.PatientInfoModel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.BevelBorder;


public class MainMenu extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabPanel;
	
	public PatientSearchPanel homePanel;
	public PatientInfoPanel patientInfoPanel;
	public InitialVisitPanel visitInfoPanel;

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		
		setTitle("Antenatal Care Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		tabPanel = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.setSelectedIndex(-1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tabPanel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tabPanel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tabPanel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tabPanel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(tabPanel);
	}
}
