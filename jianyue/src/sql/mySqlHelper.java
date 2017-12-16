package sql;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class mySqlHelper {
		// �趨�û���������

		static Connection ct = null;
		static PreparedStatement ps = null;
		static ResultSet rs = null;

		
		//�Ѳ�ѯ��װ��һ������
		//sql=select  ?,?,?from ? where ?=?.
		public ArrayList executeQuery(String sql,String []parameters){
			ArrayList al=new ArrayList();
			try{
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				if(parameters!=null) {
				    //��sql���ʺŸ�ֵ
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
				}
				
				rs=ps.executeQuery();
				//��仰�ǳ�����
				ResultSetMetaData rsmd=rs.getMetaData();
				//ͨ��rsmd���Եõ��ý�����ж�����
				int columnNum=rsmd.getColumnCount();
				//ѭ���Ĵ�al��ȡ�����ݣ�����װ��ArrayList��
				while(rs.next()){
					Object []objects=new Object[columnNum];
					for( int i=0;i<objects.length;i++){
						objects[i]=rs.getObject(i+1);
					}
					al.add(objects);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				DBUtil.close(rs, ps, ct);
			}
		}

		//��дһ��update/delete/insert
		//sql��ʽ�� update ���� set �ֶ���=�� where �ֶ�=��
		//parametersӦ����{��abc",23};
		public boolean executeUpdate(String sql,String[] parameters){
			boolean b=false;
			//1.����һ��ps
			try{
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				//������ֵ
				if(parameters!=null){
					for(int i=0;i<parameters.length;i++){
						ps.setString(i+1, parameters[i]);
					}
				}
				//ִ��
				int num=ps.executeUpdate();
				if(num==1){
					b=true;
				}

			}catch(Exception e){
				e.printStackTrace();//�����׶�
				//�׳��쳣���׳������쳣�����Ը����øú����ĺ���һ��ѡ��
				//���Դ���Ҳ���Է�������
				throw new RuntimeException(e.getMessage());
			}finally{
				//�ر���Դ
				DBUtil.close(rs,ps,ct);
			}
			return b;
		}
		
		
		//���û�ע���ʱ��õ��û�������id����ʱ��idӦ��Ϊ���ֵ��
		public String getmaxId(){
			String result;
			//1.����һ��ps
			try{
				String sql="select max(id) from users";
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				//ִ��
				Object objects = null;
				rs=ps.executeQuery();
				while(rs.next()){
					objects=rs.getObject(1);
				}
				result=""+objects;
			}catch(Exception e){
				e.printStackTrace();//�����׶�
				//�׳��쳣���׳������쳣�����Ը����øú����ĺ���һ��ѡ��
				//���Դ���Ҳ���Է�������
				throw new RuntimeException(e.getMessage());
			}finally{
				//�ر���Դ
				DBUtil.close(rs,ps,ct);
			}
			return result;
		}
		
		
		
		
}
