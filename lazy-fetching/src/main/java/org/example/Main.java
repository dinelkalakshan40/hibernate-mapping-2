package org.example;

import org.example.config.FactorConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session= FactorConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class,1);
        System.out.println(student.getId());
        System.out.println(student.getName());
        /*List<Laptop> laptopList=student.getLaptops();
        for (Laptop laptop:laptopList){
            System.out.println(laptop.getModel());
        }*/
        Laptop laptop =session.get(Laptop.class,1);
        System.out.println(laptop.getLid());
        System.out.println(laptop.getModel());


        transaction.commit();
        session.close();
    }
}