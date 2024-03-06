package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery =session.createNativeQuery("select * from Student");
        nativeQuery.addEntity(Student.class);

        List<Student> studentList= nativeQuery.list();
        for (Student s: studentList){
            System.out.println(s);
        }
        transaction.commit();
        session.close();
    }
}