import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawAarcTest extends JFrame {
	
	public DrawAarcTest() {
		setTitle("DrawAarcTest");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Mycanvus canvus = new Mycanvus();
		add(canvus, "Center");
		
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	}

	
	class Mycanvus extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawArc(100, 70, 300, 300, 45, 180);
			g.drawArc(50, 100, 400, 250, 120, 270);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawAarcTest();
	}

}
