import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EventFillOvalTest extends JFrame implements ItemListener {

	Color color = Color.BLACK;
	JRadioButton rbRed, rbGreen, rbBlue; 
	
	
	public EventFillOvalTest() {
		setTitle("라디오 버튼으로 타원 색상 변경하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel radioPan = new JPanel();
		ButtonGroup group = new ButtonGroup();
		rbRed = new JRadioButton("RED");
		rbGreen = new JRadioButton("GREEN");
		rbBlue = new JRadioButton("BLUE");
		
		rbRed.addItemListener(this);
		rbGreen.addItemListener(this);
		rbBlue.addItemListener(this);
		group.add(rbRed);
		group.add(rbGreen);
		group.add(rbBlue);
		
		radioPan.add(rbRed);
		radioPan.add(rbGreen);
		radioPan.add(rbBlue);
		
		Mycanvus canvus = new Mycanvus();
		
		add(radioPan, "North");
		add(canvus, "Center");
		
		setBounds(1000, 200, 600, 500);
		setVisible(true);
	}
	
	class Mycanvus extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(color);
			g.fillOval(150, 100, 300, 200);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(rbRed.isSelected()) {
			color = Color.RED;
		}
		else if(rbGreen.isSelected()) {
			color = Color.GREEN;
		}
		else if(rbBlue.isSelected()){
			color = Color.BLUE;
		}
		repaint();

	}

	public static void main(String[] args) {
		new EventFillOvalTest();
	}

}
