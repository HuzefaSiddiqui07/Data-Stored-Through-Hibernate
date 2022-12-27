package com.mypackage;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

  public static void main(String[] args) {
		
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
             Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
       
     SessionFactory factory = meta.getSessionFactoryBuilder().build();  
     Session session = factory.openSession();  
     Transaction t = session.beginTransaction();  
       
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter First Name");
     String firstName = sc.next();
     
     System.out.println("Enter Last Name");
     String lastName = sc.next();
     
        Employee e1= new Employee();  
         e1.setFirstName(firstName);    
         e1.setLastName(lastName); 
         
         session.save(e1);  
         t.commit();  
         System.out.println("Successfully Details Saved...");    
          factory.close();  
          session.close();  
     }
}
