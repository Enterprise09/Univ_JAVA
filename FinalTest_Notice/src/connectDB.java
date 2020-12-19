import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class connectDB {
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���������� Driver�� �ε� �Ǿ����ϴ�.");
			String url = "jdbc:mysql://localhost:3306/javatest?serverTimezone=UTC";
			String user = "root";
			String pw = "010909xogh";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("���������� ������ �Ǿ����ϴ�.");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;		
	}
	
	public void stopConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���������� DB������ �����Ǿ����ϴ�.");
	}
	
	public String deleteNoticed(String caption) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();	
		String result = null;
		try {
			pstmt = conn.prepareStatement("delete from notice where caption = ?");
			pstmt.setString(1, caption);
			pstmt.executeUpdate();
			System.out.println(caption + " ���� �����Ǿ����ϴ�.");
			result = caption +  "���� �����Ǿ����ϴ�.";
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("�������� �ʴ� ���Դϴ�.");
			result = caption + "�������� �ʴ� ���Դϴ�.";
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stopConnection(conn);
		return result;
	}
	
	public String updateNoticed(String content, String caption) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();	
		String result = null;	
		try {
			pstmt = conn.prepareStatement("update notice set content = ? where caption = ?");
			pstmt.setString(1, content);
			pstmt.setString(2, caption);
			pstmt.executeUpdate();
			System.out.println(caption + " ���� �����Ǿ����ϴ�.");
			result = "���� �����Ǿ����ϴ�.";
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("�������� �ʴ� ���Դϴ�.");
			result = caption + " �� �������� �ʴ� ���Դϴ�.";
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stopConnection(conn);
		return result;
	}
	
	public String serchNoticed(String caption) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		conn = getConnection();		
		try {
			pstmt = conn.prepareStatement("select * from notice where caption = ?");
			pstmt.setString(1, caption);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getString("content");
			System.out.println(caption + " �� �˻��Ǿ����ϴ�.");
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("�������� �ʴ� ���Դϴ�.");
			result = caption + "�������� �ʴ� ���Դϴ�.";
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stopConnection(conn);
		return result;
		
	}
}
