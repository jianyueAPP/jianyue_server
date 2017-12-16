/**  
* @title: AddArticleServlet.java
* @package adminview
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月16日 下午5:21:49
* @version V1.0  
*/ 
package adminview;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.Article;

public class AddArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String title = req.getParameter("title");
	String author = req.getParameter("author");
	String link = req.getParameter("link");
	String tag = req.getParameter("tag");
	Article article = new Article(title, author, link, tag, 1);
	DaoFactory df = new DaoFactory();
	df.getArticleDao().addArticle(article);
	resp.sendRedirect(req.getContextPath()+"/addArticleInput.jsp");
    }
    
}
