import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class showNotice extends JFrame{
	
	 JTable table;
	 JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	 String[][] data;
	 String[] title = {"번호", "작성자", "제목", "내용", "등록일자"};
	 Font font = new Font("맑은 고딕", Font.BOLD, 20);
	 
	public showNotice() {
		setTitle("사용자 공지사항 확인");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel("공지사항");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(font);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int i = 0;
		int j = 0;
		
		String number;
		String writer;
		String caption;
		String content;
		String regisdate;
		try {
			connectDB db = new connectDB();
			conn = db.getConnection();
			
			//행과 열의 개수 가져오기
			pstmt = conn.prepareStatement("select count(*) from notice");
			rs = pstmt.executeQuery();
			rs.next();
			int num = rs.getInt(1);
			int row = 5;
			System.out.println("행의 개수 : " + num);	
			
			data = new String[num][5];
			
			
			pstmt = conn.prepareStatement("select * from notice");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				number = rs.getString("number");
				writer = rs.getString("writer");
				caption = rs.getString("caption");
				content = rs.getString("content");
				regisdate = rs.getString("regisdate");
				
				
				System.out.println(number);
				System.out.println(writer);
				System.out.println(caption);
				System.out.println(content);	
				System.out.println(regisdate);
				
				j = 0;
				data[i][j] = number;
				j += 1;
				data[i][j] = writer;
				j += 1;
				data[i][j] = caption;
				j += 1;
				data[i][j] = content;
				j += 1;
				data[i][j] = regisdate;
				i += 1;				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		table = new JTable(data, title);
		scroll = new JScrollPane(table);
		
		
		add(scroll, "Center");
		pack();
		add(lbl, "North");
		
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new showNotice();
	}

}
