import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MainFrame implements ActionListener, ItemListener {

	//add menu to frame
	JMenuBar menuBar;
	JMenu menuFile;
	JMenuItem mitmAddPatient, mitmListPatients;
	
	public MainFrame() {
		JFrame f = new JFrame("Medical Centre Appointment Scheduler");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = f.getContentPane();
		AppTable appTable = new AppTable();
		contentPane.add(appTable);
		
		//add menu to frame
		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		mitmAddPatient = new JMenuItem("Add Patient");
		mitmListPatients = new JMenuItem("List Patients");
		menuFile.add(mitmAddPatient);
		menuFile.add(mitmListPatients);
		mitmAddPatient.addActionListener(this);
		mitmListPatients.addActionListener(this);
		menuBar.add(menuFile);
		f.setJMenuBar(menuBar);
		
		
		f.setVisible(true);
		f.pack();
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mitmAddPatient) {
			System.out.println("HellO");
			JFrame fAddPatient = new JFrame("Add Patient");
			fAddPatient.getContentPane().add(new AddPatient());
			fAddPatient.pack();
			fAddPatient.setVisible(true);
		}
		
		if (e.getSource() == mitmListPatients) {
			JFrame fListPatients = new JFrame("List Patients");
			fListPatients.getContentPane().add(new ListPatients());
			fListPatients.pack();
			fListPatients.setVisible(true);
		}
	}

	public static void main(String[] args) {
/*		//change the look of the theme
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}*/
		
		MainFrame f = new MainFrame();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
