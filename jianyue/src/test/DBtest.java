/**  
* @title: DBtest.java
* @package test
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月16日 下午9:47:42
* @version V1.0  
*/ 
package test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.Test;

import dao.DaoFactory;
import model.Article;

public class DBtest {

    @Test
    public void test01() {
	DaoFactory dFactory = new DaoFactory();
	List<Article> list=dFactory.getArticleDao().searchArticle("tag=\"aaa\"");
	for(Article i : list) {
	    System.out.println(i.getId());
	}
    }

}
