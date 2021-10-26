package main;

import model.Model;
import util.Controller;
import view.GUIGame;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The main panel.
     */
	 JPanel master;

    private Launcher() {

        /* Title of the frame */
        setTitle("Patron-Conception");

        /* Size of the frame */
        setSize(650, 400);

        /* The program stops when the cross is clicked */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* The frame is resizable or not */
        setResizable(false);

        /* Position of the frame in the screen */
        setLocationRelativeTo(null);  // centering the frame
        
        /* Set master layout to GridBagLayout for vertical centering */
        master = new JPanel();
        master.setBackground(Color.GRAY);
        master.setLayout(new GridBagLayout());

        /* Add buttonsPanel */
        initButton();
        setContentPane(master);

    }

    /**
     * Initialize the button NEW GAME.
     */
    private void initButton() {
		JButton button = new JButton("NEW GAME");
		master.add(button);
		button.setVisible(true);
		button.setBackground(Color.RED);
		button.setForeground(Color.white);
		button.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
				
			}
			
		});
		
	}


	/**
     * Launches a new game.
     */
    private void newGame() {
    	Model model = new Model();
		GUIGame game = new GUIGame(model);
		
		
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, game);

        dispose();
    }

    public static void main(String[] args) {
        new Launcher().setVisible(true);
    }

}

