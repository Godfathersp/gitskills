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
		//�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//����SESSION����
		Session  session = sessionFactory.getCurrentSession();
		//����SchemaExporT����
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}
	*/
	
	//@Test
	/*
	public void testStudentsSave()
	{
		//�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//����SESSION����
		Session  session = sessionFactory.getCurrentSession();
		
		Transaction tx ;
		tx = session.beginTransaction();
		Students s1 = new Students("0001", "������", "��", new Date(), "��ƽ");
		Students s2 = new Students("0002", "����", "��", new Date(), "��ƽ");
		Students s3 = new Students("0003", "����", "��", new Date(), "��ƽ");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
	}
	*/
	
}
