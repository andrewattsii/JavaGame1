import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.PrimitiveIterator.OfDouble;

import javax.imageio.IIOImage;
import javax.swing.JFrame;



public class JavaGame extends JFrame {
	
	int x , y;
	private Image dbImage;
	private Graphics dbg;
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT) {
				if(x <= 0) {
					x = 0;
				}
				else
				x += -5;
			}
			
			if(keyCode == e.VK_RIGHT) {
				if( x >= 480) {
					x = 480;
				}
				else
				x+= +5;
			}
			
			if(keyCode == e.VK_UP) {
				if(y <= 38) {
					y = 38;
				}
				else	
				y+= -5;
			}
			
			if(keyCode == e.VK_DOWN) {
				if (y >= 480) {
					y = 480;
				}
				else
				y+= +5;
			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			
		}
		
	}

	public JavaGame() {
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
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
		g.fillOval(x, y, 15, 15);
		
		repaint();
	}

	public static void main(String[] args) {
		new JavaGame();
	}
}