package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student s =session.get(Student.class,1);
        System.out.println(s.getId());
        System.out.println(s.getName());
        Laptop laptop=session.get(Laptop.class,1);
        System.out.println(laptop.getLid());
        System.out.println(laptop.getModel());
        transaction.commit();
        session.close();

    }
}