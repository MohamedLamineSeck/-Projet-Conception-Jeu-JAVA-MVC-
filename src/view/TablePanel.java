package view;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.*;
import util.Observer;

@SuppressWarnings("exports")

public class TablePanel extends JPanel implements Observer{
	
	private static final long serialVersionUID = -7971071586275452169L;
	
	public AbstractTableModel table;
	public Model model;
	JLabel scoreLabel;
	JLabel computerScoreLabel;

	/**
	 * Constructor of the table panel.
	 * @param model the model of the game.
	 */
	public TablePanel(Model model) {
		
		this.model=model;
		model.addObserver(this);
		this.table= new TableModelSurface(model);
		JTable table = new JTable((TableModel) this.table);
		table.setShowGrid(false);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(200,120));
		add(scrollpane);
		
		scoreLabel = new JLabel("Surface:");
		scoreLabel.setPreferredSize(new Dimension(200, 30));
		scoreLabel.setVisible(true);
		
		
		add(scoreLabel);
		
		computerScoreLabel = new JLabel("Solve Surface:");
		scoreLabel.setPreferredSize(new Dimension(200, 30));
		scoreLabel.setVisible(true);
		
		add(computerScoreLabel);
		setVisible(true);
	}


	/**
	 * Updates the score every time a form has been added or removed.
	 * Check whether the user clicked the solve button or not so it can show the score 
	 * achieved by the computer.
	 */
	@Override
	public void update(Object obj) {
		
		this.scoreLabel.setText("Surface:"+ this.model.getScore());
		if(this.model.getSolve())
			this.computerScoreLabel.setText("Solve Surface:"+ this.model.getPlayerStrategy().getScore());
		this.table.fireTableDataChanged();
		
	}



}
