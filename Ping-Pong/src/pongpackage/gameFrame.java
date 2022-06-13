package pongpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class gameFrame extends JFrame{
	
	gameFrame(){
		this.add(new gamePanel());
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
