
package view;

import model.Model;
import util.Observer;

import java.awt.BorderLayout;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("exports")
public class GUIGame extends JFrame implements Observer{
    
  
   
	private static final long serialVersionUID = 1L;
	Model model;
    private PanelClass panel;
    public PanelButtonClass panelButtonclass;
    public TablePanel table; 
    
   public static ArrayList<ViewObject> objects = new ArrayList<ViewObject>();
      /**
       * Constructor
       */
      public GUIGame(){
      this(new Model());
       } 
      /**
       * Constructor
       * @param model the model of the game.
       */
    public GUIGame(Model model){
        
        this.model = model;
        this.model.addObserver(this);
        panel = new PanelClass(this.model);
        
        table = new TablePanel(model);
       
        panelButtonclass = new PanelButtonClass(this.model);
        
        this.setLayout(new BorderLayout());
        this.add(panelButtonclass, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(this.table, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800,650);
        this.setVisible(true);
        
    }

  
   /**
    * Returns the panel containing the button.
    * @return the panel.
    */
public PanelButtonClass getButtonsPanel() {
		return panelButtonclass;
	}
	/**
	 * Add Listener to the game panel.
	 * @param m
	 */
public void addPanelListener(MouseListener m) { 
		this.panel.addMouseListener(m);
	}
	/**
	 * 
	 * @return the game panel.
	 */
public JComponent getPanel() {
	return this.panel;
}	
	/**
	 * Static method that add ViewObject to the static list objects.
	 * @param object The object to be added.
	 */
    public static void addObject(ViewObject object) {
    	objects.add(object);
    }

	@Override
	public void update(Object obj) {
		repaint();
	}
    
    
}
