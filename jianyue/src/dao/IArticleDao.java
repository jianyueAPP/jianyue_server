/**  
* @title: IArticleDao.java
* @package dao
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月11日 下午11:22:16
* @version V1.0  
*/ 
package dao;

import java.util.List;

import model.Article;


public interface IArticleDao {
    public void addArticle(Article article);
    public void deleteArticle(Article article);
    public void updateArticle(Article article);
    public List<Article> searchArticle(String condition);
    public List<Article> listArticle();
}
