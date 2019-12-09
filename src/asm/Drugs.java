/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author DELL
 */
class Drugs {
        Scanner input = new Scanner(System.in);
        boolean check;
        String Name ;
        String Company;
        Date MFG = new Date();
        Date EXP = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        int quantity;
        double money;
        String thoat;
        int i=0;

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public Date getMFG() {
        return MFG;
    }

    public void setMFG(Date MFG) {
        this.MFG = MFG;
    }

    public Date getEXP() {
        return EXP;
    }

    public void setEXP(Date EXP) {
        this.EXP = EXP;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getThoat() {
        return thoat;
    }

    public void setThoat(String thoat) {
        this.thoat = thoat;
    }
    public String addFile(){
        String date2=sdf.format(EXP);
            String date1 = sdf.format(MFG);
        return i++ +"\n" + "Name Company: "+ Company +"\n" +"Name Drug: "+Name+"\n"+"MFG: "+date1+"\n"+"EXP: "+date2+"\n"+"Quantity: "+"\n"+quantity+"\n"+"Money: "+money+"\n" ;
    }
    
}
