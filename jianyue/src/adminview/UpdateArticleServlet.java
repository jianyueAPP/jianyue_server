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

public class UpdateArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt( req.getParameter("id"));
	String title = req.getParameter("title");
	String author = req.getParameter("author");
	String link = req.getParameter("link");
	String tag = req.getParameter("tag");
	int pageNos = Integer.parseInt(req.getParameter("pageNos"));
	Article article = new Article(title, author, link, tag, 1);
	article.setId(id);
	DaoFactory df = new DaoFactory();
	df.getArticleDao().updateArticle(article);
	req.setAttribute("pageNos", pageNos);
//	req.setAttribute("id", id);
//	req.setAttribute("title", title);
//	req.setAttribute("author", title);
//	req.setAttribute("link", title);
//	req.setAttribute("tag", tag);
	resp.sendRedirect(req.getContextPath()+"/articlelist.html");
    }
    
}
