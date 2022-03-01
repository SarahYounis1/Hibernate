package com.example.hibernatedemo;

//import org.springframework.boot.SpringApplication;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;


//@SpringBootApplication
public class HibernatedemoApplication {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session =factory.getCurrentSession();

        try {
            System.out.println("Creating Student");
            Student  tempStudent= new Student("Sarah3" , "Younis3"
                    , "Sarah3@gmail.com");

            session.beginTransaction();
            System.out.println("Saving Student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Saved Student with ID" + tempStudent.getId());
            System.out.println("DONE");

            // new session
            session=factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class,tempStudent.getId());
            System.out.println("The Retrieved student"+ myStudent);
            session.getTransaction().commit();






        } finally {
            factory.close();

        }
    }
}
