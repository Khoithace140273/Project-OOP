/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class PhanPhoi implements Serializable {

    String ten;
    String sdt;
    String ten_sp_mua;
    Double money;
    String diaChi;
    String Paid;
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    public PhanPhoi(Date date, String ten, String diaChi, String sdt, String ten_sp_mua, Double money, String Paid) {
        this.date=date;
        this.ten = ten;
        this.diaChi=diaChi;
        this.sdt = sdt;
        this.ten_sp_mua = ten_sp_mua;
        this.money = money;
        this.Paid=Paid;
    }

    public String toString() {//in ra thong tin nha phan phoi theo dinh dang
        String date1 = sdf.format(date);
        return "Date: "+date1+"\t"+"Name: " + ten +"\t"+", Telephone: " + sdt +"\t"+ ", Name of product: " + ten_sp_mua +"\t"+ ", Money:" + money +"\t"+"Paid: "+Paid;
    }

}
