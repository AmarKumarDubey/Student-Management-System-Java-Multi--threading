package com.multi;

import java.util.*;


public class Student implements Runnable {

    private String first_name;
    private String last_name;
    private String Student_ID;
    private int degree_opted;
    private String Branch_opted;
    private int tuition_fees=0;
    private static int id_btech=0;
    private static int id_mtech=0;
    private static ArrayList<Pair>arr=new ArrayList<>();

    public Student() {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter student First Name : ");
        this.first_name=sc.nextLine();

        System.out.println("Enter student Last Name :");
        this.last_name=sc.nextLine();

        System.out.println("1 - B.TECH\n2 - M.TECH\nEnter course to enroll for :");
        this.degree_opted=sc.nextInt();

        setStudentID();

        branch_details();

        // System.out.println(first_name+" "+last_name+" "+degree_opted+" "+Student_ID+" "+Branch_opted+" "+tuition_fees);
    }

    private void setStudentID() {
        if(degree_opted==1) {
            id_btech++;
            Student_ID="B"+id_btech;
        }
        else if(degree_opted==2) {
            id_mtech++;
            Student_ID="M"+id_mtech;
        }
    }

    private void branch_details() {
        arr.add(new Pair("Computer Science",1000));
        arr.add(new Pair("Information Technology",800));
        arr.add(new Pair("Electronics and Telecommunication",600));
        arr.add(new Pair("Mechanical",400));
    }

    public void enroll() {
        branch_details();
        for(int i=0;i<=3;i++) {
            System.out.println((i+1)+" - "+arr.get(i).course+" "+"Rs"+arr.get(i).fees);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Branch to enroll for :");
        int temp=sc.nextInt();
        this.Branch_opted=arr.get(temp-1).course;
        this.tuition_fees=arr.get(temp-1).fees;
        //System.out.println("You should pay minimum of "+this.tuition_fees/2+" as first payment for enrolling");
    }

    public  void view_balance() {
        System.out.println("Outstanding Amount ="+tuition_fees);
    }

    public void run() {
        //	synchronized (this){
        view_balance();
        Scanner sc=new Scanner(System.in);
        while(1!=0) {
            System.out.println("Enter amount to pay :");
            int amount=sc.nextInt();
            if(amount>tuition_fees) {
                System.out.println("Enter valid amount");
            }
            else {
                tuition_fees-=amount;
                System.out.println("Paymnet of "+amount+" successfull");
                // view_balance();
                break;
            }
        }
        //	}

    }

	/* public void pay_tuition_fees() {
		 view_balance();
		 Scanner sc=new Scanner(System.in);
		 while(1!=0) {
			 System.out.println("Enter amount to pay :");
			 int amount=sc.nextInt();
			 if(amount>tuition_fees) {
				 System.out.println("Enter valid amount");
			 }
			 else {
				 tuition_fees-=amount;
				 System.out.println("Paymnet of "+amount+" successfull");
				 view_balance();
				 break;
			 }
		 }

	 }*/

    public void showInfo() {
        System.out.println("Name :- "+first_name+" "+last_name+"\nStudent_Id :- "+ Student_ID+"\nBranch_opted :- "+Branch_opted+"\nOutstanding Fees :- "+tuition_fees);
    }
}
