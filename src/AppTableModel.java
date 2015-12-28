import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class AppTableModel extends DefaultTableModel {

	List<Color> rowColours = Arrays.asList(
			Color.RED,
			Color.GREEN,
			Color.CYAN,
			Color.YELLOW
			);
	
	
	public AppTableModel(Integer numRow, String[] columnNames) {
		super(numRow, columnNames.length);
	}
	
	public void setRowColour(int row, Color c) {
		rowColours.set(row, c);
		fireTableRowsUpdated(row,row);
	}
	
	public Color getRowColour(int row) {
		if (row == 0) {
			return rowColours.get(0);
		} else
			return rowColours.get(1);
	}
	
	public Color getColumnColour(int col) {
		if (col == 0) {
			return rowColours.get(3);
		} else
			return rowColours.get(2);
	}
	
/*	public int getColumnCount() {
		return columnNames.length;
	}*/
	
/*	public int getRowCount() {
		return data.length;
	}*/

/*	public Object getValueAt(int row, int col) {
		return data[row][col];
	}*/
	
/*	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}*/
	
	//make cells not editable
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
/*	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}*/

	
	
}

//custom table renderer for colouring the columns accordingly
@SuppressWarnings("serial")
class AppTableCellRenderer extends DefaultTableCellRenderer {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
		//System.out.println("HERE");
		AppTableModel model = (AppTableModel) table.getModel();
		Component c = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		c.setBackground(model.getColumnColour(column));
		return c;
	}
	
}

