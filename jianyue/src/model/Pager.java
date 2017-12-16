/**  
* @title: Pager.java
* @package hughe.msg.model
* @description: TODO
* @author Hughe  1044829783@qq.com  
* @date 2017年7月21日 下午9:25:19
* @version V1.0  
*/ 
package model;

import java.util.List;

public class Pager<E>
{
	//页号
	private int pageIndex;
	//页内记录
	private int pageSize;
	//总共多少条
	private int totalRecord;
	//总共多少页
	private int totalPage;
	//放具体数据
	private List<E> data;
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getTotalRecord()
	{
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	public List<E> getData()
	{
		return data;
	}
	public void setData(List<E> datas)
	{
		this.data = datas;
	}
	
	
}
