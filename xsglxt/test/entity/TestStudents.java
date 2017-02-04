package entity;


import org.hibernate.service.ServiceRegistry;

import java.util.Date;

import org.apache.commons.lang3.text.StrBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

public class TestStudents {

	/*@Test
	public void testSchemaExport()
	{
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建SESSION对象
		Session  session = sessionFactory.getCurrentSession();
		//创建SchemaExporT对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}
	*/
	
	//@Test
	/*
	public void testStudentsSave()
	{
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建SESSION对象
		Session  session = sessionFactory.getCurrentSession();
		
		Transaction tx ;
		tx = session.beginTransaction();
		Students s1 = new Students("0001", "张三丰", "男", new Date(), "临平");
		Students s2 = new Students("0002", "郭靖", "男", new Date(), "临平");
		Students s3 = new Students("0003", "黄蓉", "男", new Date(), "临平");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
	}
	*/
	
}
