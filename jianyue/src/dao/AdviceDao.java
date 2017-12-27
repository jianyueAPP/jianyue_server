/**  
* @title: AdviceDao.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年12月26日 下午7:19:37
* @version V1.0  
*/ 
package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import model.Advice;
import model.Article;
import sql.mySqlHelper;

public class AdviceDao {
    
    public void addAdvice(String content) {
	String sql = "insert into t_advice values(null,?,?,1)";
	String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	String[] parameters = {time, content};
	boolean result = new mySqlHelper().executeUpdate(sql, parameters);
    } 
    public void deleteAdvice(Advice advice) {
	// TODO Auto-generated method stub
       String sql = "update t_advice set status=? where id=?";
	   String parameters[] = {"0" ,advice.getId()+""};
	   boolean al = new mySqlHelper().executeUpdate(sql, parameters);
    }
    public  List<Advice> listArticle() {
	// TODO Auto-generated method stub
    
   	

		String sql = "select * from t_advice where 1=?"; // 因为要应和函数，所以加了个无关紧要的数
		String[] parameters = { "1" };
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		ArrayList<Advice> newAl = new ArrayList<Advice>();
		// 二次业务封装
		for (int i = 0; i < al.size(); i++) {
			Object obj[] = (Object[]) al.get(i);
			Advice temp = new Advice();
			temp.setId(Integer.parseInt(obj[0].toString()));
			temp.setContent(obj[2].toString());
			temp.setTime(obj[1].toString());
			temp.setStatus(Integer.parseInt(obj[3].toString()));
			newAl.add(temp);
		}
		return newAl;

    }
    
    public  List<Advice> searchArticle(String condition) {
   	// TODO Auto-generated method stub
       
      	

   		String sql = "select * from t_advice where " + condition; // 因为要应和函数，所以加了个无关紧要的数
   		String[] parameters = null;
   		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
   		ArrayList<Advice> newAl = new ArrayList<Advice>();
   		// 二次业务封装
   		for (int i = 0; i < al.size(); i++) {
   			Object obj[] = (Object[]) al.get(i);
   			Advice temp = new Advice(Integer.parseInt(obj[0].toString()), obj[1].toString(), obj[2].toString(),Integer.parseInt(obj[3].toString()));
   			newAl.add(temp);
   		}
   		return newAl;

       }
}
