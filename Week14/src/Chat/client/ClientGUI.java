package Chat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
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
			System.out.println("�������� ������ ���� ���� ���� ����!");
			
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
		ta.setEditable(false); 	//������ �Ұ����� TextArea�� ����
		tf.requestFocus();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.requestFocus();
		String str = tf.getText();
		

	}
	
	public void giveAndTake() {
		System.out.println(this.getClass().getName() + "3. InputOutput =>");
		
		
	}

}
