import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ListPatients extends JPanel {

	JList<String> list;
	DefaultListModel<String> listModel; 
	
	String[] colNames = {
			"ID",
			"NAME",
			"ADDRESS"
	};
	
	int rowCount = 0;

	public ListPatients() {
		DefaultTableModel model = new DefaultTableModel(rowCount, colNames.length) {
			//make cells not editable
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		model.setColumnIdentifiers(colNames);
		
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400,400));
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = DBWork.readPatientRecord();
		for (int i=0; i < patientList.size(); i++) {
			model.addRow(new Object[]{Integer.toString(patientList.get(i).getId()), patientList.get(i).getName(), patientList.get(i).getAddress()});
		}
		//sets size of JScrollPane to JTable
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		
		this.add(scrollPane);
		
		//add mouse listener and listen for double click
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable t = (JTable) me.getSource();
				Point p = me.getPoint();
				int row = t.rowAtPoint(p);
				//int col = t.columnAtPoint(p);
				if (me.getClickCount() == 2) {
					System.out.println(t.getValueAt(row,  0));
					Patient patient;
					int id = Integer.parseInt(t.getValueAt(row,0).toString());
					//patient = DBWork.getPatientFromID((Integer)t.getValueAt(row,0));
					patient = DBWork.getPatientFromID(id);
					JFrame f = new JFrame("Patient Info");
					AddPatient patientView = new AddPatient();
					patientView.setFields(patient.getName(), patient.getAddress());
					f.getContentPane().add(patientView);
					f.pack();
					
					f.setVisible(true);
				}
			}
		});
		
	}

	
}
