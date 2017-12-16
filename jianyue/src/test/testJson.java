/**  
* @title: testJson.java
* @package test
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月17日 下午7:43:52
* @version V1.0  
*/ 
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import model.Tags;
import util.JsonUtil;
import util.PythonUtil;

public class testJson {

    @Test
    public void test01() {
	String json = "{\"tag\":[\"aaa\",\"bbb\" ]}";
	Tags tags = (Tags) JsonUtil.json2obj(json, Tags.class);
	System.out.println(json);
	String args="";
	System.out.println(tags.getTag().get(0));
	
	
    }

}
