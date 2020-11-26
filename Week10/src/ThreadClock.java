import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadClock extends JFrame implements Runnable {

	JLabel lbl1, lbl2;
	
	public ThreadClock() {
		setTitle("날짜와 시간");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl1 = new JLabel("", JLabel.CENTER);
		lbl2 = new JLabel("", JLabel.CENTER);
		lbl1.setFont(new Font("중고딕", Font.ITALIC, 20));
		lbl2.setFont(new Font("맑은고딕", Font.BOLD, 30));
		add(lbl1, "North");
		add(lbl2, "Center");
		
		setBounds(1000, 200, 400, 150);
		setVisible(true);	

	}
	
	@Override
	public void run() {
		int year, month, date, hour, min, sec;
		Calendar cal;
		String s1, s2;
		while(true) {
			cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			date = cal.get(Calendar.DATE);
			hour = cal.get(Calendar.HOUR);
			min = cal.get(Calendar.MINUTE);
			sec = cal.get(Calendar.SECOND);
			
			s1 = year + "년 " + month + "월 " + date + "일";
			s2 = hour + "시 "  + min + "분 " + sec + "초";
			
			lbl1.setText(s1);
			lbl2.setText(s2);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
		}
	}

	public static void main(String[] args) {
		ThreadClock t1 = new ThreadClock();
		Thread t = new Thread(t1);
		t.start();
	}

}
