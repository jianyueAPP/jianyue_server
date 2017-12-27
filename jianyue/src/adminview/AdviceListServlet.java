/**  
* @title: AdviceListServlet.java
* @package adminview
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年12月26日 下午7:44:27
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

import dao.AdviceDao;
import dao.DaoFactory;
import model.Advice;
import model.Article;

public class AdviceListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Advice> list = new ArrayList<Advice>();
        
        String advicecon = request.getParameter("advicecon");
        String condition = "";
        if(advicecon!=null) {
            
            condition += " content=\"_"+advicecon+"\"";
        }
       
        
        if(condition!="")
            list=new AdviceDao().searchArticle(condition);
        else 
            list=new AdviceDao().listArticle();
        HttpSession session = request.getSession();
        // 将数据存到session中以便于在前台获取
        session.setAttribute("advicelist", list);
        //获取当前页的页数并转为int类型,最终将数据存到session中
        int pageNosAdvice;
        if (request.getParameter("pageNosAdvice") == null
                || Integer.parseInt(request.getParameter("pageNosAdvice")) < 1) {
            pageNosAdvice = 1;
        } else {
            pageNosAdvice = Integer.parseInt(request.getParameter("pageNosAdvice"));
        }
        session.setAttribute("pageNosAdvice", pageNosAdvice);
        // 定义总页数并存到session中
        
        int onePageSizeAdvice = 10;
        int countPageAdvice = (list.size()+onePageSizeAdvice)/onePageSizeAdvice;
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("countPageAdvice", countPageAdvice);
        session.setAttribute("onepagesizeAdvice", onePageSizeAdvice);
        request.getRequestDispatcher("advicelist.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
