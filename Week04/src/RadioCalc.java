import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioCalc extends JFrame implements ItemListener {

	JTextField text1, text2;
	String[] radioItems = {"더하기", "빼기", "곱하기", "나누기"};
	JRadioButton[] radios = new JRadioButton[radioItems.length];
	JLabel lbl;
	
	public RadioCalc() {
		setTitle("라디오 버튼 실습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		
		p1.add(text1); p1.add(text2);
		
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < radioItems.length; i++) {
			radios[i] = new JRadioButton(radioItems[i]);
			radios[i].addItemListener(this);
			group.add(radios[i]);
			p2.add(radios[i]);
		}
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		lbl = new JLabel();
		lbl.setFont(font);
		
		add(p1, "North");
		add(p2, "Center");
		add(lbl, "South");
		
		setBounds(1000, 200, 300, 200);
		setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		double d1 = Double.parseDouble(text1.getText());
		double d2 = Double.parseDouble(text2.getText());
		double d3 = 0;
		
		if(radios[0].isSelected()) {
			d3 = d1 + d2;
			lbl.setText(d1 + " + " + d2 + " = " +  d3);
		}
		else if(radios[1].isSelected()) {
			d3 = d1 - d2;
			lbl.setText(d1 + " - " + d2 + " = " +  d3);
		}
		else if(radios[2].isSelected()) {
			d3 = d1 * d2;
			lbl.setText(d1 + " × " + d2 + " = " +  d3);
		}
		else if(radios[3].isSelected()) {
			d3 = d1 - d2;
			lbl.setText(d1 + " ÷ " + d2 + " = " +  d3);
		}
		
	}

	public static void main(String[] args) {
		new RadioCalc();

	}

}
