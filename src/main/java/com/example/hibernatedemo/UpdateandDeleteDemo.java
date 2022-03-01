package com.example.hibernatedemo;

//import org.springframework.boot.SpringApplication;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//@SpringBootApplication
public class UpdateandDeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session =factory.getCurrentSession();

        try {
         int studentId=3;


            session.beginTransaction();

   session.createQuery("delete from Student where id=4").executeUpdate();
            session.createQuery("delete from Student where id=5").executeUpdate();
          // Student  myStudent  = session.get(Student.class,studentId);
         //  session.delete(myStudent);
            //myStudent.setFirstName("SarahJ");
         //   session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();


            session.getTransaction().commit();



        } finally {
            factory.close();

        }
    }
}
