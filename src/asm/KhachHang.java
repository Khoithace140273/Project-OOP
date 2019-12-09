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
public class KhachHang implements Serializable {

    String ten;
    String diaChi;
    int tuoi;
    String sdt;
    String ten_sp_mua;
    Double money;
    String Paid;
    Date date=new Date();
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
    public KhachHang(Date date, String ten, int tuoi, String diaChi, String sdt, String ten_sp_mua, Double money, String Paid) {
        this.ten = ten;
        this.date=date;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.ten_sp_mua = ten_sp_mua;
        this.money = money;
        this.Paid=Paid;
    }


    @Override
    public String toString() {//in ra thong tin khach hang theo dinh dang
        String date1 = sdf.format(date);
        return "Date: "+date1+"\t"+"Name: " + ten +"\t"+ ", Address: " + diaChi +"\t"+ ", Telephone: " + sdt +"\t"+ ", Name of product: " + ten_sp_mua +"\t"+ ", Money:" + money +"\t"+", Paid: "+Paid;
    }

}
