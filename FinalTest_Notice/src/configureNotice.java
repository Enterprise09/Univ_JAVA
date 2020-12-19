import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class configureNotice extends JFrame implements ActionListener {
	
	JTextField caption;
	JTextArea content;
	JButton serch;
	JButton update;
	JButton delete;
	
	public configureNotice() {
		setTitle("관리자 공지사항 삭제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel("제목 입력");
		caption = new JTextField(10);
		content = new JTextArea(20, 50);
		serch = new JButton("검색");
		update = new JButton("수정");
		delete = new JButton("삭제");
		
		serch.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		
		pan1.add(lbl);
		pan1.add(caption);
		
		pan2.add(serch);
		pan2.add(update);
		pan2.add(delete);
		
		add(pan1, "North");
		add(content, "Center");
		add(pan2, "South");
		
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connectDB db = new connectDB();
		String caption = this.caption.getText();
		String result = null;
		if(e.getSource().equals(delete)) {
			result = db.deleteNoticed(caption);
			this.content.setText(result);
			
		}else if(e.getSource().equals(update)) {
			String content = this.content.getText();
			result = db.updateNoticed(content, caption);
			this.content.setText(result);
		}else if(e.getSource().equals(serch)) {
			result = db.serchNoticed(caption);
			this.content.setText(result);
		}
		
	}

	public static void main(String[] args) {
		new configureNotice();

	}

	

}
