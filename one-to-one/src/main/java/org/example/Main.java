package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setLid(3);
        laptop.setModel("Hp");

        Student student = new Student();
        student.setId(3);
        student.setName("Dinelka");
        student.setAddress("Galle");
        student.setLaptop(laptop);

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(laptop);
        session.save(student);

        transaction.commit();
        session.close();
    }
}