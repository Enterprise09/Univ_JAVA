import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAddap1 extends JFrame {

	JLabel lbl;
	
	public MouseAddap1() {
		setTitle("Adapter 클래스 사용");
		setLayout(new FlowLayout());
		lbl = new JLabel("마우스를 동작해 보세요");
		add(lbl); 
		addMouseListener(new MyMouseAdapter());
		addMouseMotionListener(new MyMouseMotionAdapter());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 500, 300);
		setVisible(true);
	}
	
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			lbl.setText("마우스가 클릭되었습니다.");
		}
	}
	
	class MyMouseMotionAdapter extends MouseMotionAdapter{
		@Override
		public void mouseDragged(MouseEvent e) {
			lbl.setText("마우스가 드래그되었습니다. : ( " + e.getX() + ", " + e.getY() + " )");
		}
		
		
	}
	
	public static void main(String[] args) {
		new MouseAddap1();

	}

}
