import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Key2 extends JFrame implements KeyListener {
	
	JButton btn;
	int curW = 70, curH = 30;
	
	public Key2() {
		setTitle("움직이는 버튼");
		setLayout(null);
		btn = new JButton("move");
		add(btn);
		btn.setBounds(50, 50, curW, curH);		//배치관리자를 null로 해서 button의 위치를 지정해야 한다.
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 300, 500, 300);
		setVisible(true);
		requestFocus();
	}	
	

	

	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		
		
		switch (KeyCode) {
		case KeyEvent.VK_UP:
			if (btn.getY() != 0) {
				btn.setLocation(btn.getX(), btn.getY()-10);
			}
			break;			
		case KeyEvent.VK_DOWN:
			if (btn.getY() != 300) {
				btn.setLocation(btn.getX(), btn.getY()+10);
			}
				break;
		case KeyEvent.VK_LEFT:
			if (btn.getX() != 0) {
				btn.setLocation(btn.getX()-10, btn.getY());
			}			
			break;
		case KeyEvent.VK_RIGHT:
			if (btn.getX() != 500) {
				btn.setLocation(btn.getX()+10, btn.getY());
			}
				break;
		case KeyEvent.VK_F1:
			btn.setBackground(Color.PINK);
			break;
		case KeyEvent.VK_F2:
			btn.setBackground(Color.ORANGE);
			break;	
		case KeyEvent.VK_F8:
			btn.setSize(curW+5, curH+5);
			curW += 5;
			curH += 5;
			break; 
		case KeyEvent.VK_F9:
			btn.setSize(curW-5, curH-5);
			curW -= 5;
			curH -= 5;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		new Key2();
	}

}
