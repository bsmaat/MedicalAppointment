import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class AddPatient extends JPanel implements ActionListener {

	JTextField name, address, dob;
	JLabel lbName, lbAddress, lbDob;
	JButton btnAdd, btnClose, btnCreateDB, btnPrintRecords;
	JPanel panelButtons;
	public AddPatient() {
		setBorder(new EmptyBorder(10,10,10,10));
		
		this.setLayout(new MigLayout());
		
		
		name = new JTextField(20);
		address = new JTextField(20);
		dob = new JTextField(20);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		btnCreateDB = new JButton("Create");
		btnCreateDB.addActionListener(this);
		btnPrintRecords = new JButton("Print Records");
		btnPrintRecords.addActionListener(this);
		panelButtons = new JPanel();
		
		lbName = new JLabel("Name:");
		lbName.setHorizontalAlignment(JLabel.RIGHT);
		lbAddress = new JLabel("Address:");
		lbAddress.setHorizontalAlignment(JLabel.RIGHT);
		lbDob = new JLabel("Date of Birth:");
		lbDob.setHorizontalAlignment(JLabel.RIGHT);
	
		
		add(lbName); add(name, "wrap");
		add(lbAddress); add(address, "wrap");
		add(lbDob); add(dob, "wrap");
		
		panelButtons.add(btnAdd);
		panelButtons.add(btnClose);
		panelButtons.add(btnCreateDB);
		panelButtons.add(btnPrintRecords);
		add(panelButtons, "span");
		
	}

	public void setFields(String name, String address) {
		this.name.setText(name);
		this.address.setText(address);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if (e.getActionCommand().equals("Add"))
		if (e.getSource() == btnAdd) {
			System.out.println("test");
			//DBWork.createDB();
			DBWork.addPatientRecord(new Patient(0, name.getText(), address.getText(), 0));
			//DBWork.readPatientRecord();
		}
		//create the database and the table
		if (e.getSource() == btnCreateDB) {
			DBWork.createDB();
		}
		//print the db records in the console
		if (e.getSource() == btnPrintRecords) {
			DBWork.readPatientRecord();
		}
		//close the window
		if (e.getSource() == btnClose) {
			JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
			f.dispose();
		}

	}
	
}
