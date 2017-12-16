/**  
* @title: testPython.java
* @package test
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月16日 下午4:42:39
* @version V1.0  
*/ 
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.PythonUtil;

public class testPython {

    @Test
    public void test01() {
	System.out.println(PythonUtil.execPy("python3","./pythonlib/choosearticle.py","aaa bbb ccc"));
    }

}
