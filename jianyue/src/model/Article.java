/**  
* @title: Article.java
* @package model
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月11日 下午10:59:05
* @version V1.0  
*/ 
package model;

import java.util.ArrayList;
import java.util.List;

public class Article {
    private int id;
    private String title;
    private String author;
    private String link;
    private String tags;
    private int status;
    
//    public void addTag(String tag) {
//	this.tags.add(tag);
//    }
//    
//    public void addTags(List<String> tags) {
//	for(String tag : tags) {
//	    this.addTag(tag);
//	}
//    }
    
    
    
    

    public Article(String title, String author, String link, String tags, int status) {
	this.title = title;
	this.author = author;
	this.link = link;
	this.tags = tags;
	this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Article() {
	super();
    }
    
    
}
