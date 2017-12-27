/**  
* @title: GetArticleServlet.java
* @package action
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月17日 上午11:12:57
* @version V1.0  
*/ 
package action;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.tracing.dtrace.ArgsAttributes;

import model.Tags;
import util.JsonUtil;
import util.PythonUtil;

public class GetArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String json = req.getParameter("json");
	System.out.println(json);
	req.setCharacterEncoding("utf-8");
	//Tags tags = (Tags) JsonUtil.json2obj(json, Tags.class);
	//StringBuilder args= new StringBuilder();
	//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	//System.out.println(tags);
	//List<String> tList = tags.getTag();
	//int len = tList.size();
	//for(int i = 0;i < len;i++) {
	    //String string = tList.get(i);
	    //if(i==0)
		//args.append(string);
	    //else
		//args.append(" "+string);
	//}
	//System.out.println(args);
	String classPath = this.getClass().getResource("/").getPath();

	//System.out.println("类加载根路径:" + classPath);
	String classPathFormat=classPath.substring(1,classPath.length());
	//String result=PythonUtil.execPy("python3",classPathFormat+"choosearticle.py",args.toString());
	String result=PythonUtil.execPy("python3",classPathFormat+"choosearticle.py",json);
	result = decodeUnicode(result);
	System.out.println(result);
	resp.setHeader("Content-type", "text/html;charset=UTF-8");
	resp.setCharacterEncoding("utf-8");
	resp.getWriter().write(result);
	
	//req.setAttribute( "result",result); 
        //req.getRequestDispatcher( "android.jsp").forward(req,resp); 
    }
    
    public static String decodeUnicode(String theString) {
	 
        char aChar;
 
        int len = theString.length();
 
        StringBuffer outBuffer = new StringBuffer(len);
 
        for (int x = 0; x < len;) {
 
            aChar = theString.charAt(x++);
 
            if (aChar == '\\') {
 
                aChar = theString.charAt(x++);
 
                if (aChar == 'u') {
 
                    // Read the xxxx
 
                    int value = 0;
 
                    for (int i = 0; i < 4; i++) {
 
                        aChar = theString.charAt(x++);
 
                        switch (aChar) {
 
                        case '0':
 
                        case '1':
 
                        case '2':
 
                        case '3':
 
                        case '4':
 
                        case '5':
 
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Malformed   \\uxxxx   encoding.");
                        }
 
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
 
                    else if (aChar == 'n')
 
                        aChar = '\n';
 
                    else if (aChar == 'f')
 
                        aChar = '\f';
 
                    outBuffer.append(aChar);
 
                }
 
            } else
 
                outBuffer.append(aChar);
 
        }
 
        return outBuffer.toString();
 
    }
    
}
