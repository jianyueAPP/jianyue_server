/**  
* @title: User.java
* @package model
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年11月11日 下午11:17:48
* @version V1.0  
*/ 
package model;

import java.util.List;

public class User {
    private List<Integer> tags;

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public User(List<Integer> tags) {
	super();
	this.tags = tags;
    }
    
    
}
