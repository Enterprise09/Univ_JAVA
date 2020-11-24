import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Action1 extends JFrame implements ActionListener {
	JButton btn;
	JLabel lbl;
	public Action1() {
		setTitle("ActopmEvemt와 ActionListener");
		setLayout(new FlowLayout());
		btn = new JButton("Click");
		lbl = new JLabel("버튼을 클릭하세요~");
		btn.addActionListener(this);
		add(btn);
		add(lbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(900, 200, 150, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lbl.setText("★버튼이 클리되었습니다.");
		btn.setBackground(Color.MAGENTA);
	}

	public static void main(String[] args) {
		new Action1();

	}

}
