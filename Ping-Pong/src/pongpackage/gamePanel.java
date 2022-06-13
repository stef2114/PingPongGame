package pongpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

/*public class gamePanel extends JPanel implements Runnable{
	
	static final int WIDTH=1000;
	static final int HEIGHT=(int)(WIDTH/9*5);
	static final Dimension SIZE=new Dimension(WIDTH,HEIGHT);
	static final int BALL_DIAMETER=30;
	static final int PADDLE_WIDTH=25,PADDLE_HEIGHT=100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1,paddle2;
	Ball ball;
	Score score;
	Timer timer;
	boolean running=true;
	
	gamePanel(){
		newPaddles();
		newBall();
		score=new Score(WIDTH,HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SIZE);
		
		gameThread=new Thread(this);
		gameThread.start();
		//timer=new Timer(75,(ActionListener) this);
		//timer.start();
		
		
	}
	
	public void newBall() {
		random=new Random();
		ball=new Ball(WIDTH/2-(BALL_DIAMETER/2),random.nextInt(HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	public void newPaddles() {
		paddle1=new Paddle(0,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2=new Paddle(WIDTH-PADDLE_WIDTH,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		image=createImage(getWidth(),getHeight());
		graphics=image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}

	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		
		if(ball.y<=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		
		if(ball.y>=HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		
		if(ball.intersects(paddle1)) {
			ball.xVelocity*=-1;
			ball.xVelocity++;
			if(ball.yVelocity>0) {
				ball.yVelocity++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		if(ball.intersects(paddle2)) {
			ball.xVelocity*=-1;
			ball.xVelocity++;
			if(ball.yVelocity>0) {
				ball.yVelocity++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		if(paddle1.y<=0) {
		
			paddle1.y=0;
		}
		if(paddle1.y >= HEIGHT-PADDLE_HEIGHT) {
			paddle1.y=HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle2.y<=0) {
			paddle2.y=0;
		}
		if(paddle2.y >= HEIGHT-PADDLE_HEIGHT) {
			paddle2.y=HEIGHT-PADDLE_HEIGHT;
		}
		
		if(ball.x<=0) {
			score.player2++;
			newPaddles();
			newBall();
		}
		if(ball.x>=WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta = 0;
		while(true) {
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			if(delta>=1) {
				move();
				checkCollision();
				repaint();
				delta--;
				System.out.println("TEST");
			}
		}
	}
	
	public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
	
}
*/
public class gamePanel extends JPanel implements ActionListener{
	
	static final int WIDTH=1000,DELAY=10;
	static final int HEIGHT=(int)(WIDTH/9*5);
	static final Dimension SIZE=new Dimension(WIDTH,HEIGHT);
	static final int BALL_DIAMETER=30;
	static final int PADDLE_WIDTH=25,PADDLE_HEIGHT=100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1,paddle2;
	Ball ball;
	Score score;
	Timer timer;
	boolean running;
	
	gamePanel(){
		newPaddles();
		newBall();
		score=new Score(WIDTH,HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SIZE);
		startGame();
	}
	
	public void startGame() {
		running=true;
		timer=new Timer(DELAY,this);
		timer.start();
	}
	
	public void newBall() {
		random=new Random();
		ball=new Ball(WIDTH/2-(BALL_DIAMETER/2),random.nextInt(HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	public void newPaddles() {
		paddle1=new Paddle(0,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2=new Paddle(WIDTH-PADDLE_WIDTH,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		image=createImage(getWidth(),getHeight());
		graphics=image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}

	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		
		if(ball.y<=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		
		if(ball.y>=HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		
		if(ball.intersects(paddle1)) {
			ball.xVelocity*=-1;
			ball.xVelocity++;
			if(ball.yVelocity>0) {
				ball.yVelocity++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		if(ball.intersects(paddle2)) {
			ball.xVelocity*=-1;
			ball.xVelocity++;
			if(ball.yVelocity>0) {
				ball.yVelocity++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		if(paddle1.y<=0) {
			paddle1.y=0;
		}
		if(paddle1.y >= HEIGHT-PADDLE_HEIGHT) {
			paddle1.y=HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle2.y<=0) {
			paddle2.y=0;
		}
		if(paddle2.y >= HEIGHT-PADDLE_HEIGHT) {
			paddle2.y=HEIGHT-PADDLE_HEIGHT;
		}
		
		if(ball.x<=0) {
			score.player2++;
			newPaddles();
			newBall();
		}
		if(ball.x>=WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkCollision();
		}
		repaint();
		
	}
	
	public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
	
}
