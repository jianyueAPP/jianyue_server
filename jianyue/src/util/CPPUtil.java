/**  
* @title: Pyutil.java
* @package util
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月16日 下午4:28:25
* @version V1.0  
*/ 
package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPPUtil {
    
	
	public static void execcpp(String filename,String args) {
            Process proc = null;
            //System.out.println(PYURL);
            try {
            	//System.out.println("start");  
            	proc = Runtime.getRuntime().exec(filename + " " + args);
            	System.out.println(proc==null);
                proc.waitFor();
       
               // System.out.println("end");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
    }
    	
    //	public static String readAnswer() {
    //    BufferedReader br;
    //    String answer = null;
    //    try {
    //        br = new BufferedReader(new FileReader(new File()));
    //        answer = br.readLine();
    //    } catch (FileNotFoundException e) {
    //        e.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //
    //    return answer;
    //}
}
