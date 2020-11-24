import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class RadioTest extends JFrame implements ItemListener {

	JTextArea ta;
	String[] radioItems = {"���Ʈ", "���̽�ũ��", "�Ƹ޸�ī��", "ī���", "����"};
	JRadioButton[] radios = new JRadioButton[radioItems.length];
	
	public RadioTest() {
		setTitle("���� ��ư�� ItemEvent ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel("�ݸ��ִ� �Ľ��� �����ϼ���.��");
		Font font = new Font("���� ����", Font.BOLD, 15);
		lbl.setFont(font);
		ta = new JTextArea();

		ButtonGroup group = new ButtonGroup();
		JPanel pan = new JPanel();
		
		for (int i = 0; i < radioItems.length; i++) {
			radios[i] = new JRadioButton(radioItems[i]);
			radios[i].addItemListener(this);
			group.add(radios[i]);
			pan.add(radios[i]);
		}
		
		add(lbl, "North");
		add(ta, "Center");
		add(pan, "South");
		
		setBounds(900, 200, 300, 200);
		setVisible(true);
		}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton eRadio = (JRadioButton) e.getSource();
		if(eRadio == radios[0]) {
			ta.setText(eRadio.getText() + "�����ϼ̽��ϴ�.");
		}
		else if(eRadio == radios[1]) {
			
		}
		else if(eRadio == radios[2]) {
			
		}
		else if(eRadio == radios[3]) {
			
		}
		else if(eRadio == radios[4]) {
			
		}
		
	}

	public static void main(String[] args) {
		new RadioTest();
	}

}