/**  
* @title: DaoFactory.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月15日 下午7:28:46
* @version V1.0  
*/ 
package dao;

public class DaoFactory {
    public IAdminDao getAdminDao() {
	return new AdminDao();
    }
    public IArticleDao getArticleDao() {
	return new ArticleDao();
    }
}
