import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawRectTest extends JFrame {
	
	public DrawRectTest() {
		setTitle("DrawRectTest");
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
			g.drawRect(50, 150, 400, 250);
			g.drawRect(150, 70, 250, 350);
			
		}
	}

	public static void main(String[] args) {
		new DrawRectTest();
	}

}
