/**  
* @title: PageServlet.java
* @package adminview
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月15日 下午8:29:07
* @version V1.0  
*/ 
package adminview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import model.Article;

public class PageServlet extends HttpServlet {
   
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<Article> list = new ArrayList<Article>();
	        
	        String titlecondition = request.getParameter("titlecon");
	        String authorcondition = request.getParameter("authorcon");
	        String linkcondition = request.getParameter("linkcon");
	        String tagcondition = request.getParameter("tagcon");
	        String condition = "";
	        if(titlecondition!=null&&""!=titlecondition&&"null"!=titlecondition) {
	            if(""!=condition) {
	        	condition+=" and ";
	            }
	            condition += " title=\""+titlecondition+"\"";
	        }
	        if(authorcondition!=null&&""!=authorcondition&&"null"!=authorcondition) {
	            if(""!=condition) {
	        	condition+=" and ";
	            }
	            condition += " author=\""+authorcondition+"\"";
	        }
	        if(linkcondition!=null&&""!=linkcondition&&"null"!=linkcondition) {
	            if(""!=condition) {
	        	condition+=" and ";
	            }
	            condition += " link=\""+linkcondition+"\"";
	        }
	        if(tagcondition!=null&&""!=tagcondition&&"null"!=tagcondition) {
	            if(""!=condition) {
	        	condition+=" and ";
	            }
	            condition += " tag=\""+tagcondition+"\"";
	        }
	        DaoFactory df = new DaoFactory();
	        if(condition!="")
	            list=df.getArticleDao().searchArticle(condition);
	        else 
	            list=df.getArticleDao().listArticle();
	        HttpSession session = request.getSession();
	        // 将数据存到session中以便于在前台获取
	        session.setAttribute("articlelist", list);
	        //获取当前页的页数并转为int类型,最终将数据存到session中
	        int pageNos;
	        if (request.getParameter("pageNos") == null
	                || Integer.parseInt(request.getParameter("pageNos")) < 1) {
	            pageNos = 1;
	        } else {
	            pageNos = Integer.parseInt(request.getParameter("pageNos"));
	        }
	        session.setAttribute("pageNos", pageNos);
	        // 定义总页数并存到session中
	        
	        int onePageSize = 10;
	        int countPage = (list.size()+onePageSize)/onePageSize;
	        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
	        session.setAttribute("countPage", countPage);
	        session.setAttribute("onepagesize", onePageSize);
	        request.getRequestDispatcher("adminindex.jsp").forward(request, response);
	    }

	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    }

	
}
