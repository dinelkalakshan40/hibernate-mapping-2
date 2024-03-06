package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        //fetch all customer type data
       /* Query query=session.createQuery(" select s from Student s");
        List<Student> studentList= query.list();
        for (Student student:studentList){
            System.out.println(student);
        }*/

        //custom fields all data fetch
        /*Query query=session.createQuery("select name from Student");
        List<Object> studentList= query.list();
        for (Object student : studentList) {
            System.out.println(student);
        }*/

        //custom fields all data fetch
        /*Query query=session.createQuery("select id,name from Student ");
        List<Object[]> studentlist= query.list();  object type array
        for (Object[] student : studentlist) {
            System.out.println(student[0]+" - "+student[1]);
        }*/

        //fetch one unique data
       /* Query query =session.createQuery("from Student where id=?1");
        query.setParameter(1,"1");
        Student student =(Student)query.uniqueResult();
        System.out.println(student);*/


        //custom fields one data fetch
      /*  Query query=session.createQuery("select id,name from Student where id=?1");
        query.setParameter(1,"1");
        Object[] student= (Object[]) query.uniqueResult();
        System.out.println(student[0]+" - "+student[1]);*/

        /*Query query=session.createQuery("select id,name from Student where id=?1");
        query.setParameter(1,1);
        Object[] objects= (Object[]) query.uniqueResult();
        System.out.println(objects[0] +"-"+objects[1]);
*/
        /*Query query= session.createQuery("select id,name from Student");
        List<Object> List= query.list();*/

        //join query data fetch
        Query query=session.createQuery("select l.lid,l.model from Laptop l inner join Student s on s.id = s.id");
        List<Object[]> list= query.list();
        for (Object[] objects : list) {
           System.out.println(objects[0]+" - "+objects[1]);
       }

        transaction.commit();
        session.close();

    }
}