import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawPolygonTest extends JFrame {
	
	public DrawPolygonTest() {
		// TODO Auto-generated constructor stub
		setTitle("DrawPolyganTest");
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
			int[] xpoint = {250, 50, 450};
			int[] ypoint = {50, 400, 400};
			
			g.drawPolygon(xpoint, ypoint, 3);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawPolygonTest();
	}

}
