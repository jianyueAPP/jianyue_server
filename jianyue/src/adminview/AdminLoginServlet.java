package adminview;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import model.Admin;
import model.Article;
import model.Pager;

/**
 * Servlet implementation class AdminLoginServlet
 */
//@WebServlet("/adminlogin.html")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    	
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		System.out.println(username+"  "+password);
		Admin admin = new Admin(username, password);
		//TODO 查找
		DaoFactory df = new DaoFactory();
		//boolean checkedAdmin =true;
		boolean checkedAdmin = df.getAdminDao().isAdmin(admin);
		List<Article> articlelist = df.getArticleDao().listArticle();
		request.setAttribute("articlelist", articlelist);
		HttpSession session = request.getSession();
		        // 将数据存到session中以便于在前台获取
		session.setAttribute("loginUser",admin);
		if(checkedAdmin) {
		    int pageNos =1;
		    response.sendRedirect(request.getContextPath()+"/articlelist.html"+"?"+"pageNos="+pageNos);
		}else {
		    response.sendRedirect(request.getContextPath()+"/admincheckerror.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
