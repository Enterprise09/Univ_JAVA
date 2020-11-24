import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawStringTest extends JFrame {
	
	
	
	public DrawStringTest() {
		setTitle("DrawString()");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyCanvas canvas = new MyCanvas();
		add(canvas, "Center");
				
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.RED);
			g.drawLine(50, 160, 450, 160);
			g.setColor(new Color(255, 255, 0));
			g.drawLine(250, 50, 250, 350);
		}
	}

	public static void main(String[] args) {
		new DrawStringTest();
	}

}
