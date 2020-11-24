import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawTest1 extends JFrame {
	
	
	
	
	public DrawTest1() {
		setTitle("그래픽 기본 클래스");
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
			g.drawRect(100, 50, 300, 250);
			
		}
	}
	
	

	public static void main(String[] args) {
		new DrawTest1();
	}

}
