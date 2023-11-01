package com.multi;


import java.util.*;


public class StudentDatabase {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of Students to enroll :- ");

        int numOfStudent=sc.nextInt();

        Student[]students=new Student[numOfStudent];

        for(int i=0;i<numOfStudent;i++) {
            Student ref=new Student();
            students[i]=ref;
            students[i].enroll();
            Thread t1=new Thread(ref);
            Thread t2=new Thread(ref);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            students[i].showInfo();;
        }


    }

}
