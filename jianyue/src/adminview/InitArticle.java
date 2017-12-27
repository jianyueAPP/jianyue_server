/**  
* @title: InitArticle.java
* @package adminview
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月25日 下午4:38:42
* @version V1.0  
*/ 
package adminview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.jdbc.Buffer;

import dao.ArticleDao;
import dao.DaoFactory;
import dao.IArticleDao;
import model.Article;
import util.PythonUtil;

public class InitArticle {

    public static void main(String[] args) {
	initarticle("历史");
	initarticle("励志");
	//initarticle("幽默");
	//initarticle("侦探");
	
    }
    
    public static void initarticle(String filename) {
	BufferedReader bufferedReader = null;
	PrintWriter out = null;
	try {
	    bufferedReader = new BufferedReader(new FileReader("./site/"+filename+".txt"));
	    	String string = null;
		DaoFactory daoFactory = new DaoFactory();
		IArticleDao articleDao = daoFactory.getArticleDao();

		
		
		try {
		    while((string = bufferedReader.readLine())!=null) {
		        String [] arr = string.split("\\s+");
		        System.out.println(arr[0]);
		        System.out.println(arr[1]);
		        System.out.println(arr[2]);
		        String content = PythonUtil.execPy("python2","./pythonlib/getarticlecontent.py",arr[2]);
		        System.out.println(content);
		        Article article = new Article(arr[0], arr[1], content, filename, 1);
		        articleDao.addArticle(article);
		    }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
}
