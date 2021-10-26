package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelSurface extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model;
	ArrayList<Form> forms;
	private final String[] headers = { "Form", "Surface" };
	/**
	 * Constructs the model of the table showing the surfaces.
	 * @param model of the game
	 */
	
	public TableModelSurface(Model model) {
		this.model=model;
		this.forms = model.getForms();
		
	}
	@Override
	public int getRowCount() {
		
		return this.forms.size();
	}

	@Override
	public int getColumnCount() {
		
		 return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        
		switch (columnIndex) {

		case 0:
			// Name of the form
			return this.forms.get(rowIndex).getName();

		case 1:
			// Surface of the form
			return this.forms.get(rowIndex).getSurface();
		
	default:
		throw new IllegalArgumentException();
		}
		
	}
	@Override
	public String getColumnName(int columnIndex) {
		return headers[columnIndex];
	}
	
}
		

	
	
	
