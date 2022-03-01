package com.example.hibernatedemo;

import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session =factory.getCurrentSession();

        try {
          //  System.out.println("Creating Student");
          //  Student  tempStudent= new Student("Sarah4" , "Younis4"
          //          , "Sarah4@gmail.com");

        //    session.beginTransaction();
         //   System.out.println("Saving Student");
         //   session.save(tempStudent);

        //    session.getTransaction().commit();


            session=factory.getCurrentSession();

            session.beginTransaction();

            // all students
          /*  List <Student> theStudents  = session.createQuery("from Student").getResultList();


              for(Student theStudent : theStudents)
                  System.out.println(theStudent);*/



            // all students with last name younis2
         /*   List <Student> theStudentsL  = session.createQuery("from Student s where s.lastName= 'Younis2' OR s.firstName ='Sarah'").getResultList();


            for(Student theStudent : theStudentsL)
                System.out.println(theStudent);*/

              // all with email like '@gmail.com
            List <Student> theStudentsE  = session.createQuery("from Student s where"+ " s.email LIKE '%@gmail.com'").getResultList();


            for(Student theStudent : theStudentsE)
                System.out.println(theStudent);

            session.getTransaction().commit();



            System.out.println("DONE");
        } finally {
            factory.close();

        }
    }
}
