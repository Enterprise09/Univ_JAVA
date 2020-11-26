import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLTest extends JFrame implements ActionListener {

	JScrollPane scrollPane;
	JTextField tf;
	JTextArea ta;
	JPanel p1;
	
	public URLTest() {
		setTitle("InetAdress ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf = new JTextField(20);
		ta = new JTextArea();
		ta.setLineWrap(true);	//setLineWrap�޼ҵ带 true������ �����Ͽ� ���ι��� ��ũ�ѹٰ� ���� �Ʒ������� ���������� �Ѵ�.
		
		JScrollPane scrollPane = new JScrollPane(ta);
		
		JLabel lbl1 = new JLabel("ȣ��Ʈ �̸� : ");
		JLabel lbl2 = new JLabel("�˻��� ȣ��Ʈ �̸��� �Է��� �ּ���.");
		
		JButton btn = new JButton("�˻����");
		btn.addActionListener(this);
		
		JPanel p1 = new JPanel();
		p1.add(lbl1);
		p1.add(tf);
		p1.add(btn);
		
		add(p1, "North");
		add(scrollPane, "Center");
		add(lbl2, "South");
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String host = "";
		ta.setText("");
		host = tf.getText();
		try {
			URL url = new URL(host);
			URLConnection con = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = "";
			
			while((line = br.readLine()) != null) {
				ta.append(line + "\n");
			}
			
			br.close();
			
			
			
		} catch (MalformedURLException e1) {
			System.out.println("���Ŀ� ���� �ʴ� url �Դϴ�.");
			
		} catch (IOException e1) {
			System.out.println("���� ��ü�� �������� �ʾҽ��ϴ�.");
			
		}
		
	}

	public static void main(String[] args) {
		new URLTest();
	}

}
