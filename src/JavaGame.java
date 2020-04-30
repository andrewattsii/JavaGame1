import org.omg.PortableServer.THREAD_POLICY_ID;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.PrimitiveIterator.OfDouble;
import javax.imageio.IIOImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class JavaGame extends JFrame implements Runnable{


	int x , y, xDirection, yDirection;
	private Image dbImage;
	private Graphics dbg;
	Font font = new Font("Ariel", Font.BOLD, 30);
	Image sword ;

	public void run(){
		try{
			while(true);
			move();
			Thread.sleep(500);

		}
		catch (Exception e){
			System.out.println("Error");
		}
	}
	public void move(){
		x += xDirection;
		y += yDirection;
		if(x <= 0){
			x = 0;
		}
		if(x >= 200){
			x = 200;
		}
		if(y <= 50){
			y = 50;
		}
		if(y >= 250){
			y = 250;
		}

	}
	public void setXDirection(int xdir){
		xDirection = xdir;
	}
	public void setYDirection(int ydir){
		yDirection = ydir;
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT) {
				setXDirection(-1);
			}

			if(keyCode == e.VK_RIGHT) {
				setXDirection(+1);
			}

			if(keyCode == e.VK_UP) {
				setYDirection(-1);

			}

			if(keyCode == e.VK_DOWN) {
				setYDirection(+1);

			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT) {
				setXDirection(0);
			}

			if(keyCode == e.VK_RIGHT) {
				setXDirection(0);
			}

			if(keyCode == e.VK_UP) {
				setYDirection(0);

			}

			if(keyCode == e.VK_DOWN) {
				setYDirection(0);

			}
		}
		
	}

	public JavaGame() {
		ImageIcon i = new ImageIcon("C:/Users/andre/eclipse-workspace/FirstGame/src/fox.png");
		sword = i.getImage();
				
		
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setBackground(Color.yellow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 150;
		y = 150;
	}
	
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g) {
		g.setFont(font);
		g.drawString("Game", 190, 100);
		g.fillOval(x, y, 15, 15);
		g.drawImage(sword, x, y, this);
		
		repaint();
	}

	public static void main(String[] args) {
		JavaGame boom = new JavaGame();
		//threads
		Thread t1 = new Thread(boom);
		t1.start();
	}
}