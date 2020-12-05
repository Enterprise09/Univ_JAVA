package Chat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JPanel implements ActionListener, Runnable {

	Socket s;
	JTextArea ta;
	JTextField tf;
	PrintWriter pw;
	BufferedReader br;
	
	public ClientGUI(String ip, int port) {
		System.out.println(this.getClass().getName() + "1. Start =>");
		initLayout();
		try {
			s = new Socket(ip, port);
			
		
		} catch (IOException e) {
			System.out.println("서버와의 연결을 위한 소켓 생성 실패!");
			
			
		}
		System.out.println(this.getClass().getName() + "2. Socket =>");
		
		
	}
	
	public void initLayout() {
		setLayout(new BorderLayout());
		ta = new JTextArea(20, 50);
		tf = new JTextField(50);
		add(ta, "Center");
		add(tf, "South");
		tf.addActionListener(this);
		ta.setEditable(false); 	//편집이 불가능한 TextArea를 만듬
		tf.requestFocus();
		
	}
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName() + "4.run =>");
		String line = null;
		try {
			while((line = br.readLine()) != null){
				ta.append(line + "\n");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.requestFocus();
		String str = tf.getText();
		pw.println(str);
		tf.setText("");
		
		

	}
	
	public void giveAndTake() {
		System.out.println(this.getClass().getName() + "3. InputOutput =>");
		try {
			pw = new PrintWriter(s.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			Thread t1 = new Thread(this);
			t1.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
