import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class AppTable extends JPanel {

	public AppTable() {
		//String[] day names for table
/*		String[] colNames = {
				"9:00", 
				"10:00",
				"11:00",
				"12:00",
				"13:00",
				"14:00",
				"15:00",
				"16:00"};*/
		String[] colNames = {
				"Time",
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		
		int numRows = 36; //number of rows
		
		//model for table
/*		DefaultTableModel model = new DefaultTableModel(numRows, colNames.length) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};*/
		
		AppTableModel model = new AppTableModel(numRows, colNames);
		
		model.setColumnIdentifiers(colNames);
		JTable table = new JTable(model);
		//fill the time cells
		int rowNum = 0;
		for (int hour = 9; hour <= 17; hour++) {
			for (int min = 0; min < 60; min+=15) {
				table.setValueAt(Integer.toString(hour) + ":" + Integer.toString(min), rowNum, 0);
				rowNum++;
			}
		}
		JScrollPane scrollPane = new JScrollPane(table);
		
		//sets size of JScrollPane to JTable
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		table.setDefaultRenderer(Object.class, new AppTableCellRenderer());
		
		//add mouse listerner
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable t = (JTable) me.getSource();
				Point p = me.getPoint();
				int row = t.rowAtPoint(p);
				int col = t.columnAtPoint(p);
				if (me.getClickCount() == 2) {
					System.out.println(Integer.toString(row) + ":" + Integer.toString(col));
				}
			}
		});
		this.add(scrollPane);
	}
	
}

@SuppressWarnings("serial")
class MyTableCellRenderer extends DefaultTableCellRenderer {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
		//DefaultTableModel model = (DefaultTableModel) table.getModel();
		Component c = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		c.setBackground(Color.RED);
		return c;
	}
	
}
