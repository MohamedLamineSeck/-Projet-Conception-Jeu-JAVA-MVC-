
package util;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import command.CommandHandler;
import model.Cercle;
import model.Model;
import model.Point;
import model.Rectangle;
import state.AdjustmentsState;
import state.CercleState;
import state.CurrentState;
import state.DeleteState;
import state.InitialState;
import state.RectangularState;
import state.RedemensionState;
import view.*;


public class Controller implements Observable{
	
	public ArrayList<Observer> observers;
	GUIGame gameView;
	Model model;
	public static CurrentState state = new CurrentState();
	
	public static CommandHandler handler = new CommandHandler();
	
	
	public Controller(Model model, GUIGame game) {
		this.model=model;
     	this.gameView=game;
		
		addPanelListeners();
		addButtonListeners();
		}
	
	public void addPanelListeners() {
		PanelClass panelClass = (PanelClass) this.gameView.getPanel();
		panelClass.addMouseListener(new MouseAdapter() {
			
	        public void mousePressed(MouseEvent e) {
	        	
	            PanelClass.startDrag = new Point(e.getX(), e.getY());
	            PanelClass.endDrag = PanelClass.startDrag;  
	            
	            Point p = new Point(e.getX(), e.getY());
	            Controller.state.mousePressed(p);
	            
	         
	          }

	          public void mouseReleased(MouseEvent e) {
	        	  
	        	 
	        	Controller.state.mouseReleased( PanelClass.startDrag, new Point( e.getX(), e.getY()));
	        	 PanelClass.startDrag= null;
	     	   	 PanelClass.endDrag = null;
	     	   	 model.setIsPainting(true);
	     	
	        	  
	            
	          }
	        });

	        panelClass.addMouseMotionListener(new MouseMotionAdapter() {
	          public void mouseDragged(MouseEvent e) {
	        	  Point p = new Point(e.getX(), e.getY());
	        	 Controller.state.mouseDragged(p);
	        	 model.setIsPainting(true);
	        	 
	         }
	        });
	      }
	
	
	
	public void addButtonListeners() {

		PanelButtonClass panelButtonClass = (PanelButtonClass) this.gameView.getButtonsPanel();
		
		panelButtonClass.addListener(new ActionListener() {

			

			@Override
			public void actionPerformed(ActionEvent e) {
				String string = (String) e.getActionCommand();
				
				
				switch(string){
				 case "cercle": //Ovde mzoe treba das e napravi komanda treba da prashame.
					 Controller.state.setState(new CercleState(model));
					 break;
				 case "rectangle":
					 Controller.state.setState(new RectangularState(model));
					 break;
				
				 case "adjustment":
					 Controller.state.setState(new AdjustmentsState(model));
					 break;
				 case "redemension":
					 Controller.state.setState(new RedemensionState(model));
					 break;
				 case "delete":
					 Controller.state.setState(new DeleteState(model));
					 break;
					 
				 case "undo":
					 Controller.handler.undo();
					
					 break;
				 case "redo":
					 Controller.handler.redo();
					
					 break;
				 case "solve":
					 model.setSolve(true);
					
					default:
						 Controller.state.setState(new InitialState());
						 
				}
					
				
			}
			
		}); 
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
		
	}

	@Override
	public void notifyObserver(Object obj) {
		for(Observer obs: this.observers) {
			obs.update(obj);
		}
		
		
	}
	
	
    
}
