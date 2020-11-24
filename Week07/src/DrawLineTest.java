import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLineTest extends JFrame {
	
	
	
	
	public DrawLineTest() {
		setTitle("DrawLineTest");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyCanvas canvas = new MyCanvas();
		add(canvas, "Center");
				
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	//도화지 클래스
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawLine(50, 160, 450, 160);
			g.drawLine(250, 50, 250, 350);
			
		}
	}
	
	

	public static void main(String[] args) {
		new DrawLineTest();
	}

}
