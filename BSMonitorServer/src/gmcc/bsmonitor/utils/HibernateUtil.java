package gmcc.bsmonitor.utils;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component(value="hibernateUtil")
public class HibernateUtil
{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获得Session
	 */
	public Session getSession()
	{
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return session;
	}

	public void close()
	{
		try
		{
			sessionFactory.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 关闭Session对象
	 * 
	 * @param session
	 */
	public void closeSession(Session session)
	{
		try
		{
			if (null != session)
			{
				session.close();
				close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 事务回滚
	 * 
	 * @param transaction
	 */
	public  void rollbackTransaction(Transaction transaction)
	{
		try
		{
			if (null != transaction)
			{
				transaction.rollback();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 统一查询方法 该方法返回一个List集合
	 */
	public List exeQuery(String hql)
	{
		List list = null;
		Transaction transaction = null;
		Session session = null;
		try
		{
			session = getSession();
			transaction = session.beginTransaction();

			list = session.createQuery(hql).list();
			transaction.commit();

		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			rollbackTransaction(transaction);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSession(session);
		}
		return list;
	}

	/**
	 * 分页查询方法 该方法返回一个List集合
	 */
	public List exeQueryPage(String hql, int start, int end)
	{
		List list = null;
		Transaction transaction = null;
		Session session = null;
		try
		{
			session = getSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			list = query.list();

			transaction.commit();

		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			rollbackTransaction(transaction);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeSession(session);
		}
		return list;
	}

	/**
	 * 删除操作
	 */
	public boolean exeDelete(String hql)
	{
		boolean flag = false;
		Transaction transaction = null;
		Session session = null;
		try
		{
			session = getSession();
			transaction = session.beginTransaction();
			session.createQuery(hql).executeUpdate();

			transaction.commit();
			flag = true;

		}
		catch (HibernateException he)
		{
			he.printStackTrace();
			flag = false;
			rollbackTransaction(transaction);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		finally
		{
			closeSession(session);
		}
		return flag;
	}
}
