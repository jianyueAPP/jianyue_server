/**  
* @title: DeleteArticleServlet.java
* @package adminview
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月16日 下午7:46:39
* @version V1.0  
*/ 
package adminview;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DaoFactory;
import model.Article;

public class DeleteArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//HttpSession session = req.getSession();
	//String string = (String) session.getAttribute("deleteid");
	 //if(req.getParameter("deleteid")==null)System.out.println("null null null");;
	//System.out.println("id="+string);
	 int deleteid;
	 try {
	     	String deleteidstr =req.getParameter("deleteid");
	     	//System.out.println(deleteidstr);
	     	//System.out.println("bbb");;
	     	Article article = new Article();
	     	deleteid = Integer.parseInt(deleteidstr);
		article.setId(deleteid);
		DaoFactory df = new DaoFactory();
		df.getArticleDao().deleteArticle(article);
	 }catch (Exception e) {
	     
	}finally {
	    int pageNos=(int) req.getAttribute("pageNos");
	    resp.sendRedirect(req.getContextPath()+"/articlelist.html");
	}
	
	
	
	
    }
    
}
