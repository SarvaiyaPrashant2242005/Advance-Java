package com.aryanlanghanoja;

import com.aryanlanghanoja.models.Student;
import com.aryanlanghanoja.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Subject.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Subject subject_1 = new Subject();
            subject_1.setSubject_name("Advanced Java");
            subject_1.setInstructure("Prof. Shamsaagazarzoo Alam");

            Subject subject_2 = new Subject();
            subject_2.setSubject_name("Advanced Web Technology");
            subject_2.setInstructure("Prof. Shamsaagazarzoo Alam");

            Student student_1 = new Student();
            student_1.setStudent_name("Aryan Langhanoja");
            student_1.setEmail("aryan@gmail.com");

            Student student_2 = new Student();
            student_2.setStudent_name("Ritesh Sanchala");
            student_2.setEmail("ritesh@gmail.com");

            // Many-to-many relation
            student_1.getSubjects().add(subject_1);
            student_1.getSubjects().add(subject_2);

            student_2.getSubjects().add(subject_1);
            student_2.getSubjects().add(subject_2);

            subject_1.getStudents().add(student_1);
            subject_2.getStudents().add(student_1);

            subject_1.getStudents().add(student_2);
            subject_2.getStudents().add(student_2);

            session.save(subject_1);
            session.save(subject_2);
            session.save(student_1);
            session.save(student_2);

            session.getTransaction().commit();
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
