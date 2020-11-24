import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MenuTest2 extends JFrame implements ActionListener {

	JMenuBar mBar;
	JMenu mAttack, mMove;
	JMenuItem aGun, aBoom, aLaser;
	JMenuItem mForward, mBack;
	JLabel lbl;
	//JTextField jt;
		
	
	
	public MenuTest2() {
		setTitle("�޴��̺�Ʈ ����2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl = new JLabel(" ");
		lbl.setBackground(Color.WHITE);
		lbl.setOpaque(true);
		
		mBar = new JMenuBar();
		
		mAttack = new JMenu("����");
		aGun = new JMenuItem("��");
		aBoom = new JMenuItem("��ź");
		aLaser = new JMenuItem("������");
		mAttack.add(aGun);
		mAttack.add(aBoom);
		mAttack.add(aLaser);
		
		aGun.addActionListener(this);
		aBoom.addActionListener(this);
		aLaser.addActionListener(this);
		
		
		mMove = new JMenu("�̵�");
		mForward = new JMenuItem("����");
		mBack = new JMenuItem("����");
		mMove.add(mForward);
		mMove.add(mBack);
		
		mForward.addActionListener(this);
		mBack.addActionListener(this);
		
		
		mBar.add(mAttack);
		mBar.add(mMove);
		
		//jt = new JTextField(20);
		//add(jt, "South");
		add(lbl, "South");
		
		setJMenuBar(mBar);
		
		setBounds(1000, 200, 400, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aGun) {
			//jt.setText("������");
			lbl.setText("������");
		}
		else if(e.getSource() == aBoom) {
			//jt.setText("�� ~ ��");
			lbl.setText("�� ~ ��");
		}
		else if(e.getSource() == aLaser) {
			//jt.setText("�� ~ ��");
			lbl.setText("�� ~ ��");
		}
		else if(e.getSource() == mForward) {
			//jt.setText("�����մϴ�.");
			lbl.setText("�����մϴ�.");
		}
		else if(e.getSource() == mBack) {
			//jt.setText("�����մϴ�.");
			lbl.setText("�����մϴ�.");
		}
	}

	public static void main(String[] args) {
		new MenuTest2();
	}

}
