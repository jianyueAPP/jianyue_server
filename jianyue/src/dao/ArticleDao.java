/**  
* @title: ArticleDao.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月15日 下午7:37:36
* @version V1.0  
*/ 
package dao;

import java.util.ArrayList;
import java.util.List;

import basic.BasicService;
import model.Article;
import model.Pager;
import sql.mySqlHelper;

public class ArticleDao extends BasicService implements IArticleDao {

    @Override
	//添加文章
    public void addArticle(Article article) {
	// TODO Auto-generated method stub
       String sql = "insert into t_article values(null,?,?,?,?,1)";
       String title = article.getTitle() + "";
	   String author = article.getAuthor() + "";
	   String link = article.getLink() + "";
	   String tag = article.getTags() + "";
	   String[] parameters = {title, author, link, tag};
	   boolean result = new mySqlHelper().executeUpdate(sql, parameters);
    }

    @Override
	//删除文章
    public void deleteArticle(Article article) {
	// TODO Auto-generated method stub
       String sql = "update t_article set status=? where article_id=?";
	   String parameters[] = {"0" ,article.getId()+""};
	   boolean al = new mySqlHelper().executeUpdate(sql, parameters);
    }

    @Override
	//更新文章
    public void updateArticle(Article article) {
	// TODO Auto-generated method stub
       String sql = "update t_article set title=?,author=?,link=?,tag=? where article_id=?";
	   String parameters[] = {article.getTitle(),article.getAuthor(),article.getLink(),article.getTags(),article.getId()+""};
	   boolean al = new mySqlHelper().executeUpdate(sql, parameters);
    }


    @Override
	//获取文章列表
    public  List<Article> listArticle() {
	// TODO Auto-generated method stub
    
   	

		String sql = "select * from t_article where 1=?"; // 因为要应和函数，所以加了个无关紧要的数
		String[] parameters = { "1" };
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		ArrayList<Article> newAl = new ArrayList<Article>();
		// 二次业务封装
		for (int i = 0; i < al.size(); i++) {
			Object obj[] = (Object[]) al.get(i);
			Article temp = new Article();
			temp.setId(Integer.parseInt(obj[0].toString()));
			temp.setTitle(obj[1].toString());
			temp.setAuthor(obj[2].toString());
			temp.setLink(obj[3].toString());
			temp.setTags(obj[4].toString());
			temp.setStatus(Integer.parseInt(obj[5].toString()));
			newAl.add(temp);
		}
		return newAl;

    }


    @Override
	//查询文章列表（有条件）
    public List<Article> searchArticle(String condition) {
	// TODO Auto-generated method stub
	System.out.println(condition);
        String sql = "select * from t_article where "+condition; // 因为要应和函数，所以加了个无关紧要的数
		String[] parameters = null;
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		ArrayList<Article> newAl = new ArrayList<Article>();
		// 二次业务封装
		for (int i = 0; i < al.size(); i++) {
			Object obj[] = (Object[]) al.get(i);
			Article temp = new Article();
			temp.setId(Integer.parseInt(obj[0].toString()));
			temp.setTitle(obj[1].toString());
			temp.setAuthor(obj[2].toString());
			temp.setLink(obj[3].toString());
			temp.setTags(obj[4].toString());
			temp.setStatus(Integer.parseInt(obj[5].toString()));
			newAl.add(temp);
		}
		return newAl;
    }
}
