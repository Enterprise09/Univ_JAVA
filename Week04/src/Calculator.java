import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {

	JLabel lbl;
	String[] btnItems = {"0", ".", "C", "+", "-", "×", "÷"};
	JButton[] btns = new JButton[16];
	JButton btnEq;
	
	public Calculator() {
		setTitle("계산기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl = new JLabel("0", JLabel.RIGHT);
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		lbl.setFont(font);
		
		JPanel p = new JPanel(new GridLayout(4, 4));
		for (int i = 0; i < btns.length; i++) {
			if(i >= 9) {
				btns[i] = new JButton(btnItems[i-9]);
				btns[i].addActionListener(this);
			}
			else {
				btns[i] = new JButton(i+1+"");
			}
			btns[i].setFont(font);
			btns[i].addActionListener(this);
			p.add(btns[i]);			
		}
		btnEq = new JButton(" = ");
		btnEq.setFont(font);
		
		add(lbl, "North");
		add(p, "Center");
		add(btnEq, "South");
		
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}
	
	
	int init = 1;	//계산기 실행 초기상태면 1, 아니면 0
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ebtn = (JButton) e.getSource();
		String s = lbl.getText();
		if(ebtn == btns[9]) {
			if(init == 1) {
				init = 1;
				lbl.setText("0");
			}
			else {
				s += "0";
				lbl.setText(s);
			}
		}
		
		
		for (int i = 0; i < 9; i++) {
			if(ebtn == btns[i]) {
				if(init == 1) {
					init = 0;
					lbl.setText((i + 1) + "");
				}
				else {
					s += (i + 1);
					lbl.setText(s);
				}
			}
		}
		
		

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
