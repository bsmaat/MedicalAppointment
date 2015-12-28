import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class ListPatients2 extends JPanel {

	JList<String> list;
	DefaultListModel<String> listModel; 
	
	public ListPatients2() {
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(5);
		JScrollPane listScrollPane = new JScrollPane(list);
		listScrollPane.setPreferredSize(new Dimension(300,300));
		add(listScrollPane);
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = DBWork.readPatientRecord();
		for (int i=0; i < patientList.size(); i++) {
			listModel.addElement(Integer.toString(patientList.get(i).getId()) + " : " +  patientList.get(i).getName() + ", " + patientList.get(i).getAddress());
		}
	}
	
}
