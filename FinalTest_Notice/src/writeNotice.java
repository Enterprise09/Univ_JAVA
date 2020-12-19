import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class writeNotice extends JFrame implements ActionListener{
	
	JTextField writer;
	JTextField caption;
	JTextArea content;
	JButton regist;
	JButton reset;
	
	public writeNotice() {
		setTitle("관리자 공지사항 등록");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		
		JLabel lbl1 = new JLabel("글쓴이");
		JLabel lbl2 = new JLabel("제목");
		
		writer = new JTextField(10);
		caption = new JTextField(10);
		
		pan1.add(lbl1);
		pan1.add(writer);
		pan1.add(lbl2);
		pan1.add(caption);
		
		content = new JTextArea(20, 50);
		
		regist = new JButton("등록");
		reset = new JButton("초기화");
		regist.addActionListener(this);
		reset.addActionListener(this);
		pan2.add(regist);
		pan2.add(reset);
		
		add(pan1, "North");
		add(content, "Center");
		add(pan2, "South");
		
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		connectDB connect = new connectDB();
		conn = connect.getConnection();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String nday = year + "-" + month + "-" + day;
		
		
		if(e.getSource().equals(regist)) {
			String writer = this.writer.getText();
			String caption = this.caption.getText();
			String content = this.content.getText();
			
			try {
				pstmt = conn.prepareStatement("insert into notice(writer, caption, content, regisdate) values(?, ?, ?, ?)");
				pstmt.setString(1, writer);
				pstmt.setString(2, caption);
				pstmt.setString(3, content);
				pstmt.setString(4, nday);
				pstmt.executeUpdate();
				
				System.out.println("작성하신 공지가 등록되었습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		}else {
			writer.setText("");
			caption.setText("");
			content.setText("");
		}		
	}

	public static void main(String[] args) {		
		new writeNotice();
	}

	

}
