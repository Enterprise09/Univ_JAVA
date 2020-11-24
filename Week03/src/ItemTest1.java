import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ItemTest1 extends JFrame implements ItemListener {

	String[] checkStrs = {"딸기", "사과", "포도", "자몽", "레몬"};
	int[] prices = {12000, 15000, 20000, 15000, 10000};
	JCheckBox[] checks = new JCheckBox[checkStrs.length];
	JTextArea ta;
	
	public ItemTest1() {
		setTitle("과일 바구니");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel("바구니에 담을 과일을 선택해 주세요.");
		JPanel p1 = new JPanel();
		ta = new JTextArea();
		
		for (int i = 0; i < checkStrs.length; i++) {
			checks[i] = new JCheckBox(checkStrs[i]);
			p1.add(checks[i]);
			checks[i].addItemListener(this);
		}
		
		add(lbl, "North");
		add(ta, "Center");
		add(p1, "South");
		
		
		
		setBounds(900, 200, 500, 300);
		setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int total = 0;
		ta.setText(" ");
		for (int i = 0; i < checkStrs.length; i++) {
			if (checks[i].isSelected()) {
				ta.append("<< " + checkStrs[i] + "(" + prices[i] + "원) >>");
				total += prices[i];
			}
		}
		ta.append("\n선택된 장바구니 총액은 " + total + "원입니다.");
	}

	
	public static void main(String[] args) {
		new ItemTest1();
	}

}
