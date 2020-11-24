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
	String[] btnItems = {"0", ".", "C", "+", "-", "°ø", "°¿"};
	JButton[] btns = new JButton[16];
	JButton btnEq;
	
	public Calculator() {
		setTitle("∞ËªÍ±‚");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl = new JLabel("0", JLabel.RIGHT);
		Font font = new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30);
		lbl.setFont(font);
		
		JPanel p = new JPanel(new GridLayout(4, 4));
		for (int i = 0; i < btns.length; i++) {
			if(i >= 9) {
				btns[i] = new JButton(btnItems[i-9]);
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
		btnEq.addActionListener(this);
		
		add(lbl, "North");
		add(p, "Center");
		add(btnEq, "South");
		
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}
	
	
	int init = 1;	//∞ËªÍ±‚ Ω««‡ √ ±‚ªÛ≈¬∏È 1, æ∆¥œ∏È 0		
	double d1, d2, d3;
	int op = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ebtn = (JButton) e.getSource();
		String s = lbl.getText();
				
		
//		0≈∞
		if(ebtn == btns[9]) {
			if(init > 0) {		//√ ±‚ªÛ≈¬¿Ã∏È
				init = 1;
				lbl.setText("0");
			}
			else {
				lbl.setText(s + "0");
			}
		}
		
//		1∫Œ≈Õ 9±Ó¡ˆ ≈∞
		for (int i = 0; i < 9; i++) {
			if(ebtn == btns[i]) {
				if(init == 1) {
					init = 0;
					lbl.setText((i + 1) + "");
				}
				else {
					s += i + 1;
					lbl.setText(s);
				}
			}
		}
		
//		.≈∞
		if(ebtn == btns[10]) {
			if(init == 1) {		//√ ±‚ªÛ≈¬¿Ã∏È
				init = 0;
				s += ".";
				lbl.setText(s);
			}else {
				s += ".";
				lbl.setText(s);
			}
		}
		
//		C(Clear)≈∞
		if(ebtn == btns[11]) {
			lbl.setText("0");	
			init = 1;	//√ ±‚ªÛ≈¬∑Œ πŸ≤ﬁ
		}
		
		
//		æÓ∂≤ ø¨ªÍ¿⁄∏¶ º±≈√«ﬂ¥¬¡ˆ ∆«¥‹
		for(int i = 12; i < 16; i++) {
			if(ebtn == btns[12]) {	
				d1 = Double.parseDouble(lbl.getText());
				init = 1;				
				op = 1;		//µ°º¿ : 1
			}
			else if(ebtn == btns[13]) {
				d1 = Double.parseDouble(lbl.getText());
				init = 1;
				op = 2;		//ª¨º¿ : 2
			}
			else if(ebtn == btns[14]) {
				d1 = Double.parseDouble(lbl.getText());
				init = 1;
				op = 3;		//∞ˆº¿ : 3
			}
			else if(ebtn == btns[15]) {
				d1 = Double.parseDouble(lbl.getText());
				init = 1;
				op = 4;		//≥™¥∞º¿ : 4
			}
		}
		
		if(ebtn == btnEq) {
			d2 = Double.parseDouble(lbl.getText());
			
			switch (op) {
			case 1: 	//µ°º¿
				d3 = d1 + d2;
				break;
			
			case 2 : 	//ª¨º¿
				d3 = d1 - d2;
				break;
			
			case 3 : 	//∞ˆº¿
				d3 = d1 * d2;
				break;
			
			case 4 : 	//≥™¥∞º¿
				d3 = d1 / d2;
				break;
			}
			lbl.setText(d3 + "");			
			
		}		

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
