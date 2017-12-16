/**  
* @title: ValidateUtil.java
* @package hughe.shop.util
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年7月18日 下午4:04:29
* @version V1.0  
*/ 
package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ValidateUtil
{
	public static boolean validateNull(HttpServletRequest request,String[] fields)
	{
		boolean validate=true;
		Map<String,String> errorMsg= new HashMap<String,String>();
		for(String field : fields)
		{
			String value=request.getParameter(field);
			if (value==null||"".equals(value.trim()))
			{
				validate=false;
				errorMsg.put(field, field+"不能为空");
			}
			
		}
		if(!validate) request.setAttribute("errorMsg", errorMsg);
		return validate;
	}
	
	public static String showError(HttpServletRequest request,String field)
	{
		Map<String,String> errorMsg= (Map<String,String>)request.getAttribute("errorMsg");
		if (errorMsg==null) return "";
		String msg=errorMsg.get(field);
		if(msg==null) return "";
		return msg;
	}
}
