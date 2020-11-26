import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InetAdressTest extends JFrame implements ActionListener {

	JTextField tf;
	JTextArea ta;
	JPanel p1;
	
	public InetAdressTest() {
		setTitle("InetAdress ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf = new JTextField(20);
		ta = new JTextArea();
		
		JLabel lbl1 = new JLabel("ȣ��Ʈ �̸� : ");
		JLabel lbl2 = new JLabel("�˻��� ȣ��Ʈ �̸��� �Է��� �ּ���.");
		
		JButton btn = new JButton("�˻����");
		btn.addActionListener(this);
		
		JPanel p1 = new JPanel();
		p1.add(lbl1);
		p1.add(tf);
		p1.add(btn);
		
		add(p1, "North");
		add(ta, "Center");
		add(lbl2, "South");
		
		setBounds(1000, 200, 500, 400);
		setVisible(true);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		String host = "";
		
		//ta�� ���ִ� ���ڿ� �����
		ta.setText("");
		
		//tf�� �ִ� ���ڿ��� url�� ����
		host = tf.getText();
		try {
			ip = InetAddress.getByName(host);
			ta.append("getHostName() : " + ip.getHostName() + "\n");
			ta.append("getHostAdress() : " + ip.getAddress() + "\n");
			ta.append("toString() : " + ip.toString() + "\n");
			
			byte[] ipAddr = ip.getAddress();
			ta.append("getAdress() : " + Arrays.toString(ipAddr) + "\n");
			
			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			ta.append("getAdress() _ ������ �� 256���� : " + result + "\n\n");
			
			ip = InetAddress.getLocalHost();
			ta.append("getHostName() : " + ip.getHostName() + "\n");
			ta.append("getLocalHost() : " + ip.getHostAddress() + "\n");
			
		}
		catch (UnknownHostException e1) {
			System.out.println("�� �� ���� ȣ��Ʈ�Դϴ�.");
		}
		
		
	}

	public static void main(String[] args) {
		new InetAdressTest();
	}

}
