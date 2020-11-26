import java.awt.Color;

import javax.swing.JFrame;

public class ThreadTest2 extends JFrame {	
	
	public ThreadTest2() {
		// TODO Auto-generated constructor stub
		setTitle("È­¸é»ö º¯°æ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ColorThread t1 = new ColorThread();
		t1.start();
		
		setBounds(1000, 200, 300, 250);
		setVisible(true);
	}
	
	class ColorThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			getContentPane().setBackground(Color.GREEN);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			setTitle("»¡°­È­¸é");
			getContentPane().setBackground(Color.RED);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			setTitle("³ë¶ûÈ­¸é");
			getContentPane().setBackground(Color.YELLOW);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			setTitle("ÆÄ¶ûÈ­¸é");
			getContentPane().setBackground(Color.BLUE);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTest2();
	}

}
