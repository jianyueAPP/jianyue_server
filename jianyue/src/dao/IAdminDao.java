/**  
* @title: IAdminDao.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月15日 下午7:25:43
* @version V1.0  
*/ 
package dao;

import model.Admin;

public interface IAdminDao {
    public boolean isAdmin(Admin admin);
	public Admin load(String adminname,String password);
	public void update(Admin admin,String password);
}
