/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author asus
 */
public class DaiLi implements Serializable {

    String ten;
    String diaChi;
    Date date=new Date();
    String sdt;
    String ten_sp_mua;
    Double money;
    String Paid;
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
    public DaiLi(Date date, String ten, String diaChi, String sdt, String ten_sp_mua, Double money) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ten_sp_mua = ten_sp_mua;
        this.money = money;
        this.date=date;
    }

    public String toString() {//in ra thong tin dai li theo dinh dang
        String date1 = sdf.format(date);
        return "Date: "+date1+"\t"+"Name: " + ten +"\t"+ ", Address: " + diaChi +"\t"+ ", Telephone: " + sdt +"\t"+ ", Name of product: " + ten_sp_mua +"\t"+ ", Money:" + money +"\n";
    }

}
