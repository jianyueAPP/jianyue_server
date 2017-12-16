/**  
* @title: AdminDao.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月15日 下午7:26:44
* @version V1.0  
*/ 
package dao;

import java.util.ArrayList;

import basic.BasicService;
import model.Admin;
import sql.mySqlHelper;

public class AdminDao extends BasicService implements IAdminDao{

    @Override
	//调用load函数
    public boolean isAdmin(Admin admin) {

		Admin ad = load(admin.getAdminname(),admin.getPassword());
		if(ad==null)
			return false;
		return true;
    }

    @Override
	//判断该管理员是否正确
    public Admin load(String adminname, String password) {
	// TODO Auto-generated method stub

        String sql = "select * from t_admin where adminname=? and password=? ";
		String parameters[] = { adminname , password };
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		if (al.size() == 0) {
			return null;
		} else {
			Object[] objects = (Object[]) al.get(0);
            // 把对象数组封装到Admin对象中
			Admin admin = new Admin((String) objects[1],(String) objects[2]);			
			return admin;
		}

    }

    @Override
	//更新管理员的密码
    public void update(Admin admin, String password) {
	// TODO Auto-generated method stub

	   String sql = "update t_admin set password=? where admin_id=?";
	   String parameters[] = {password , admin.getId()+""};
	   boolean al = new mySqlHelper().executeUpdate(sql, parameters);
    }   
}
