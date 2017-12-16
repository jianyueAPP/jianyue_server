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

public class PythonUtil {
    
	
	public static String execPy(String pythontype,String filename,String args) {
            Process proc = null;
            //System.out.println(PYURL);
            try {
            	//System.out.println("start");  
            	proc = Runtime.getRuntime().exec(pythontype + " " + filename + " " + args);
            	if(proc==null) System.out.println("python error");
            	//System.out.println("PROC:"+proc);
            	 BufferedReader in = new BufferedReader(new  
                         InputStreamReader(proc.getInputStream()));  
            	 StringBuilder result=new StringBuilder();
                 String line;  
                 while ((line = in.readLine()) != null) {  
                      result.append(line);
                 }  
                 in.close();  
                proc.waitFor();
                return result.toString();
               // System.out.println("end");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
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
