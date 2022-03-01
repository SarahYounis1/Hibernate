package com.example.hibernatedemo;

import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session =factory.getCurrentSession();

        try {
            System.out.println("Creating Student");
            Student  tempStudent= new Student("Sarah" , "Younis"
                    , "Sarah@gmail.com");

            Student  tempStudent1= new Student("Sarah1" , "Younis1"
                    , "Sarah1@gmail.com");

            Student  tempStudent2= new Student("Sarah2" , "Younis2"
                    , "Sarah2@gmail.com");

            session.beginTransaction();
            System.out.println("Saving Student");
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);

            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {
            factory.close();

        }
    }
}
