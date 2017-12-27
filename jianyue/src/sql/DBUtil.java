package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	//�������
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	//�������ݿ�Ĳ���
	/*private static final String URL="jdbc:mysql://localhost/jianyue?useUnicode=true&amp;characterEncoding=UTF-8";
	    private static final String NAME="root";
	    private static final String PASSWORD="BigUp888";*/
	    private static final String URL="jdbc:mysql://localhost:3306/jianyue";
	    private static final String NAME="jianyue";
	    private static final String PASSWORD="123456789";
	//�������ݿ�
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection(URL, NAME, PASSWORD);
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	
	//�ر���Դ�ĺ���
	public static void close(ResultSet rs,Statement ps,Connection ct){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		if(ps!=null){
			try{
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			ps=null;
		}
		if(ct!=null){
			try{
				ct.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			ct=null;
		}
	}
}
