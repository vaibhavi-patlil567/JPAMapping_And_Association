package com.OnetooneUniary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		 Student s1 = new Student("Vaibhavi"); 
		 Address homeAddress = new Address();
		  homeAddress.setStreet("pimple road"); 
		  homeAddress.setCity("pune");
		  homeAddress.setState("Maha");
		  homeAddress.setZipCode("422014");
		  
		   s1.setAddress(homeAddress);
		  
		 em.persist(s1);
		 
		
		  Student s2=new Student("Hena");
		  Address addr=new Address();
		 addr.setAddressId(104); 
		 addr.setCity("Nagpur");
		 addr.setState("MH");
		  addr.setStreet("Balewadi"); 
		  addr.setZipCode("411025"); 
		  s2.setAddress(addr);
		  em.persist(s2); 
		  em.getTransaction().commit();
		  System.out.println("Added one student with address to database.");
		
		
		
		/*Student s=em.find(Student.class, 7);
		Address a1=s.getAddress();
		a1.setCity("Mumbai");
		s.setAddress(a1);
		em.merge(s);
		em.getTransaction().commit();
		
		System.out.println("Updated one student with address to database.");*/
		
		 
		Query q1=em.createQuery("select stud from Student stud where stud.studentId>7");
		@SuppressWarnings({ "unused", "unchecked" })
		List<Student> l1=q1.getResultList();
		
		for(Student l:l1)
		{
			System.out.println(l.getName()+", "+l.getStudentId()+", "+l.getAddress().getCity());
		}
		em.close();
		factory.close();
	}
}