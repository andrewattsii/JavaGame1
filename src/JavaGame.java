import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
				x-=5;
			}
			
			if(keyCode == e.VK_RIGHT) {
				x+=5;
			}
			
			if(keyCode == e.VK_UP) {
				y-=5;
			}
			
			if(keyCode == e.VK_DOWN) {
				y+=5;
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