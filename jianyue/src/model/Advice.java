/**  
* @title: Advice.java
* @package model
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年12月26日 下午8:01:57
* @version V1.0  
*/ 
package model;

public class Advice {
    private int id;
    private String time;
    private String content;
    private int status;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Advice(int id, String time, String content, int status) {
	super();
	this.id = id;
	this.time = time;
	this.content = content;
	this.status = status;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Advice() {
	super();
    }
   
    
    
}
