package pongpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Score extends Rectangle{
	
	static int WIDTH,HEIGHT;
	int player1;
	int player2;
	Score(int WIDTH,int HEIGHT){
		Score.HEIGHT=HEIGHT;
		Score.WIDTH=WIDTH;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		g.drawLine(WIDTH/2,0,WIDTH/2,HEIGHT);
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10),WIDTH/2-85,50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10),WIDTH/2+20,50);
	}

}
