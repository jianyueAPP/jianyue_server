/**  
* @title: Tags.java
* @package model
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月17日 下午8:05:53
* @version V1.0  
*/ 
package model;

import java.util.List;

public class Tags {
    private List<String> tag;

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public Tags(List<String> tag) {
	super();
	this.tag = tag;
    }

    public Tags() {
	super();
    }
    
}
