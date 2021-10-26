
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import command.*;
import model.Model;
import state.InitialState;
import util.Controller;
import util.Observer;

public class PanelButtonClass extends JPanel implements Observer{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton cercle;
   
    private JButton rectangle;
    private JButton adjustment;
    private JButton redemension;
    private JButton delete;
    
    private JButton undo;
    private JButton redo;
    private JButton solve;
    private Model model;
    /**
     * Constructor creating all the buttons
     * @param model The model of the game.
     */
    public PanelButtonClass(Model model) {
    	
    	
    	this.model=model;
    	this.model.addObserver(this);
    
    	cercle = createButton("cercle");
        rectangle = createButton("rectangle");
        adjustment = createButton("adjustment");
        redemension = createButton("redemension");
        delete= createButton("delete");
        undo = createButton("undo");
        redo = createButton("redo");
        solve = createButton("solve");
       this.setLayout(new FlowLayout());
        this.add(cercle);
        
        this.add(rectangle);
        this.add(adjustment);
        this.add(redemension);
        this.add(delete);
        this.add(undo);
        this.add(redo);
        this.add(solve);
	}
	@SuppressWarnings("exports")
	public void addListener(ActionListener a) {
		this.cercle.addActionListener(a);
		
		this.rectangle.addActionListener(a);
		this.delete.addActionListener(a);
		this.redemension.addActionListener(a);
		this.adjustment.addActionListener(a);
		this.undo.addActionListener(a);
		this.redo.addActionListener(a);
		this.solve.addActionListener(a);
	}
	
	/**
	 * Observer method update that first check if isDrawingAllowed so he can enable or disable circle and rectangle button.
	 */
	@Override
	public void update(Object obj) {
		if(!this.model.isDrawingAllowed()) {
			this.rectangle.setEnabled(false);
			this.cercle.setEnabled(false);
			Controller.state.setState(new InitialState());
		}
		else 
			{this.rectangle.setEnabled(true);
			this.cercle.setEnabled(true);}
		
	}
	/**
	 * Method that creates button.
	 * @param s the name of the button.
	 * @return created button.
	 */
	
	public JButton createButton(String s) {
		JButton button = new JButton(s);
        button.setSize(25,25);
        button.setBackground(Color.RED);
        button.setForeground(Color.white);        
		return button;
	}
    
    
    
}
