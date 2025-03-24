package org.example;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Open a session
        Session session = factory.openSession();

//        // Fetch user by ID
//        User user = session.get(User.class, 3); // Throws exception if data is unavailable
//
//        // Display user details
//        if (user != null) {
//            System.out.println("ID       : " + user.getId());
//            System.out.println("Name     : " + user.getUserName());
//            System.out.println("Password : " + user.getPassWord());
//
//            // Update password
//            user.setPassWord("1111");
//
//            // Begin transaction, update user, and commit changes
//            session.beginTransaction();
//            session.save(user);
//            session.getTransaction().commit();
//        } else {
//            System.out.println("User not found!");
//        }
        Scanner sc = new Scanner(System.in);
        String uname;
        String pass;
        // HQL query to fetch user by username and password
        String hql = "from User where userName = :uname and pwd = :pwd";
        Query query = session.createQuery(hql, User.class);
        System.out.println("Enter Username : ");
        uname = sc.next();
        System.out.println("Enter Password : ");
        pass = sc.next();
        query.setParameter("uname", uname);  // Correct parameter case
        query.setParameter("pwd", pass);  // Match with database column name

        List users = query.getResultList();
        Iterator i = users.iterator();
        while(i.hasNext()){
            User u = (User)i.next();
            System.out.println("Validate");
        }


        // Close session and factory
        session.close();
        factory.close();
    }
}
