package basic;

import java.util.List;

public interface BasicServiceInter {

	//����һЩ���õķ���
	//1.ͨ��id��ȡ����
	public Object findById(Class clazz,java.io.Serializable id);
	//2.��ѯ���� hql 
	public List executeQuery(String hql,Object []parameters);
	//3.��ѯ���� ����ҳ
	public List executeQueryByPage(String hql,Object []parameters,int pageNow,int PagesSize);
	//4.���һ������
	public void add(Object obj);
	//5.ͳһ��ִ��hql->ɾ��,�޸� hql="update domain���� where ?"
	public List executeUpdate(String hql,Object []parameters);
	//6.����һ������Ĳ���
	public Object uniqueQuery(String hql,Object []parameters);
	
	//7.�õ�hql,����pageCount
	public int queryPageCount(String hql,Object [] parameters,int pageSize);
	//8.����id��ɾ������
	public void delById(Class clazz,java.io.Serializable id);
	
	//9.ͨ��Object�޸�
	public void update(Object object);
	
}
