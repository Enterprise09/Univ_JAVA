import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FillRectOverTest extends JFrame {
	
	public FillRectOverTest() {
		setTitle("Fill메소드 연습");
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
			g.setColor(new Color(0, 255, 255));
			g.fillOval(100, 80, 300, 300);
			
			g.setColor(Color.BLUE);
			g.fillRect(50, 150, 400, 250);
			
		}
	}

	public static void main(String[] args) {
		new FillRectOverTest();
	}

}
