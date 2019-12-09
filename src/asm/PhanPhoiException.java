/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PhanPhoiException {
    Scanner ip=new Scanner(System.in);
     public double Check() {
        double n = 0;
        int kt;
        do {
            kt = 0;
            try {

                n = ip.nextDouble();//nhap tuoi
                if (n < 0) {//nhap tuoi nho hon 0 thi in thong bao
                    System.out.println("ERROR: Please enter age >0!!!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: please enter the number for age");
                kt++;
            }
            ip.nextLine();
        } while (n < 0 || kt != 0);//yeu cau nhap lai neu khong dung format

        return n;
    }

    public String CheckP() {
        String s = null;
        int kt;
        do {
            kt = 0;
            try {
                
                s = ip.nextLine();
                boolean match = s.matches("0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
                if (!match) {
                    System.out.println("Please enter right number phone!!! (10 digits and start with 0)");
                    kt += 1;
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: please enter the number phone");
                kt++;
            }
        } while (kt ==1);
        return s;
    }
     public String CheckPaid() {
        String str;
        int check;
        do {
            check = 0;
            str = ip.next();
            try {
                if (!(str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("no"))) {
                    System.out.println("Please just enter Yes/No!!!");
                    check += 1;
                }
            } catch (Exception ex) {
                System.out.println("Please just enter Yes/No!!!");
            }
            ip.nextLine();
        } while (check == 1);
        return str;
    }
     public Date CheckD() {
        Date date = null;
        String s;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int check = 0;
        do {
            try {
                check = 0;
                s = ip.nextLine();
                date = sdf.parse(s);
            } catch (Exception ex) {
                System.out.println("Please enter format dd/MM/yyyy");
                check = 1;
            }
        } while (check == 1);
        return date;
    }
    
}
