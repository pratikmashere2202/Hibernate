package com.hql;

import java.util.List; 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/hql/HQL.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

//	      Employee emp2=new Employee();
//	      emp2.setE_id(50);
//	      emp2.setE_name("Pratikesh");
//	      emp2.setELast_name("Deshmukh");
//	      emp2.setE_city("satara");      
//	      System.out.println(emp2); 
//	      
//	      session.saveOrUpdate(emp2);                            //Add record in Employee.
	System.out.println("--------------------------------------------------------------------------------");

		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();                   // Display all values from Employee table.
		for (Employee emp : empList) {
			System.out.println("emp:= " + emp.toString());
		}
//
//	System.out.println("-----------------------------------------------------------------------------");
//
//		Query query1=session.createQuery("from Employee where E_id=:E_id");  
//		query1.setLong("E_id",30);                                       //Return value of E_id=20.
//        Employee em=(Employee) query1.uniqueResult();
//		System.out.println("emp:= "+em.toString());
//
	System.out.println("----------------------------------------------------------------------------");
//
//		Query query2=session.createQuery("update Employee set E_name=:E_name where ELast_name=:ELast_name");
//		query2.setParameter("E_name","Mayur");           
//		query2.setParameter("ELast_name","Shinde");                      //Update value in database.
//		int result=query2.executeUpdate();
//	    System.out.println("Employee Update Status : "+result);
//
//    System.out.println("-----------------------------------------------------------------------------");
//
		Query query3 = session.createQuery("delete from Employee where E_id=:E_id");
		query3.setParameter("E_id", 70);
		int deleted = query3.executeUpdate();                             // Delete record by using E_id..
		System.out.println("Deleted: " + deleted + " employees");
		
		
		if(deleted==1) {                             //Add deleted records again..
		      Employee emp2=new Employee();
		      emp2.setE_id(50);
		      emp2.setE_name("Deleted");
		      emp2.setELast_name("Deleted");
		      emp2.setE_city("satara");      
		      System.out.println(emp2); 
		      
		      session.saveOrUpdate(emp2);                            //Add record in Employee.
		}		
		tx.commit();
	}
}