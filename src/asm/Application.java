/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Application {

    Scanner ip = new Scanner(System.in);

    // kiem tra file co object(co ghi noi dung) hay khong
    public static boolean hasObject(File f) {
        // thu doc xem co object nao chua
        FileInputStream fi;
        boolean check = true;//tao bien kiem tra fie co chua(true la ghi r)
        try {
            fi = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {//neu file chua ghi gi thi cho bien kt = false
                check = false;//chua ghi gi trong file
            }
            inStream.close();//dong file

        } catch (FileNotFoundException e) {
            check = false;//bat loi neu file khong ton tai thi cho bien kt = false
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }

    /**
     *
     * @doc ghi file khach hang
     */
    public static void write(KhachHang kh) {
        try {
            File f = new File("..\\DKMNH_ASM\\src\\data\\customer.txt");//di den file da tao
            FileOutputStream fo;
            ObjectOutputStream oStream = null;
            if (!f.exists()) {// neu file chua ton tai thi tao file va ghi binh thuong
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai                
                if (!hasObject(f)) {// neu chua co thi ghi binh thuong
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao
                    fo = new FileOutputStream(f, true);//khong ghi de
                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();//reset lai gia tri ban dau de tiep tuc kiem tra cho lan tiep theo(neu chon lai)
                        }
                    };
                }
            }
            oStream.writeObject(kh);
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //doc file ra chuong trinh

    public static void readC(Date date, String ten, int tuoi, String diaChi, String sdt, String ten_sp_mua, Double money, String Paid) {
        try {
            File f = new File("..\\DKMNH_ASM\\src\\data\\customer.txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fis);
            KhachHang kh;
            int i = 0;//id khach hang tu dong tang
            while (true) {
                kh = (KhachHang) inStream.readObject();//doc file ra chuong trinh
                System.out.println(++i + ". " + kh.toString());//in ra thong tin khach hang
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     *
     * @param f
     * @return
     * @doc ghi file dai li
     */
    // kiem tra file co object hay khong
    public static void write(DaiLi dl) {
        try {

            File f = new File("..\\DKMNH_ASM\\src\\data\\Dealers.txt");
            FileOutputStream fo;
            ObjectOutputStream oStream = null;

            // neu file chu ton tai thi tao file va ghi binh thuong
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai

                // neu chua co thi ghi binh thuong
                if (!hasObject(f)) {
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao

                    fo = new FileOutputStream(f, true);

                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }

            oStream.writeObject(dl);
            oStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDe(Date date, String ten, String diaChi, String sdt, String ten_sp_mua, Double money, String Paid) {
        try {
            File f = new File("..\\DKMNH_ASM\\src\\data\\Dealers.txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fis);
            DaiLi dl;
            int i = 0;//id dai li tu tang
            while (true) {
                dl = (DaiLi) inStream.readObject();
                System.out.println(++i + ". " + dl.toString());
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     *
     * @ghi va doc file nha phan pho
     */
    // kiem tra file co object hay khong
    public static void write(PhanPhoi dl) {
        try {

            File f = new File("..\\DKMNH_ASM\\src\\data\\Distributors.txt");
            FileOutputStream fo;
            ObjectOutputStream oStream = null;

            // neu file chu ton tai thi tao file va ghi binh thuong
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai

                // neu chua co thi ghi binh thuong
                if (!hasObject(f)) {
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao

                    fo = new FileOutputStream(f, true);

                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }

            oStream.writeObject(dl);
            oStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //doc file ra chuong trinh

    public static void readD(Date date, String ten, String diaChi, String sdt, String ten_sp_mua, Double money, String Paid) {
        try {
            File f = new File("..\\DKMNH_ASM\\src\\data\\Distributors.txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fis);
            PhanPhoi pp;
            int i = 0;//id nha phan phoi tu tang
            while (true) {
                pp = (PhanPhoi) inStream.readObject();//doc file 
                System.out.println(++i + ". " + pp.toString());//in ra
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File f = new File("..\\DKMNH_ASM\\src\\data\\Drugs.txt");
        Scanner ip = new Scanner(System.in);
        DrugsException check = new DrugsException();
        //khai bao bien nhap thong tin cho khach hang, da i, nha phan phoi
        String ten = null;
        int tuoi = 0;
        String diaChi = "";
        String sdt = "";
        String ten_sp_mua = "";
        String Paid = null;
        Date date=new Date();
        double money = 0;
        int choice = 0;
        int choice1 = 0;
        int choice2 = 0;
        int choice3 = 0;
        int choice4 = 0;
        int kt = 0;//bien kiem tra bat loi khong nhap so ma nhap chu
        //menu
        do {
            System.out.println("##-------------Menu----------------##");
            System.out.println("##     1. Work with drugs.         ##");
            System.out.println("##     2. Work with Customer.      ##");
            System.out.println("##     3. Exits.                   ##");
            System.out.println("##---------------------------------##");
            do {
                kt = 0;
                try {

                    System.out.print("Enter your choice: ");
                    choice1 = ip.nextInt();//nhap lua chon
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR: please enter the number for choice");
                    kt++;
                    ip.nextLine();
                }
            } while (kt != 0);//thoat khi nhap so, khong nhap chu cho lua chon
            switch (choice1) {

                case 1:
                    do {

                        System.out.println("##-------------WORK WITH DRUGS----------------##");
                        System.out.println("##             1. Add drugs.                  ##");
                        System.out.println("##             2. Show drugs.                 ##");
                        System.out.println("##             3. Back.                       ##");
                        System.out.println("##--------------------------------------------##");
                        System.out.print("Enter your choice: ");
                        choice2 = ip.nextInt();
                        switch (choice2) {
                            case 1:
                                Drugs dr = new Drugs();
                                DrugsException checkd = new DrugsException();
                                int Check = 0;
                                Check = 0;
                                //người dùng nhập enter thì out trước khi out sẽ hỏi lại chắc chắn out ko
                                ip.nextLine();
                                System.out.print("Name:");
                                dr.Name = ip.nextLine();
                                System.out.print("Company:");
                                dr.Company = ip.nextLine();
                                do {
                                    Check = 0;
                                    System.out.print("MFG:");
                                    dr.MFG = checkd.CheckD();
                                    System.out.print("EXP:");
                                    dr.EXP = checkd.CheckD();
                                    if ((dr.MFG.compareTo(dr.EXP)) > 0) {
                                        System.out.print("Please enter MFG before EXP!!!");
                                        Check += 1;
                                    }
                                } while (Check == 1);
                                System.out.print("Enter price of drugs: ");
                                dr.money = checkd.CheckN();
                                System.out.print("Enter quantity: ");
                                dr.quantity=check.Check();
                                String thoat;
                                int c=0;
                                do
                                {
                                c=0;
                                System.out.println("Do you want to save it (Y/N) ? ");
                                thoat = ip.next();
                                if ((thoat.equalsIgnoreCase("n"))) {
                                    System.out.println("Exit without save!!");
                                    break;
                                } else if((thoat.equalsIgnoreCase("y"))) {
                                    try {

                                        try (FileWriter fw = new FileWriter(f, true)) {
                                            fw.write(dr.addFile());
                                        }
                                    } catch (IOException Ex) {
                                        System.out.println("Cannot open file!!!");
                                    }
                                }
                                else
                                {
                                    c+=1;
                                }
                                }while(c==1);
                                break;
                            case 2:
                                Scanner rf = new Scanner(f);
                                while (rf.hasNext()) {
                                    System.out.println(rf.nextLine());
                                }
                                break;
                                
                            case 3:
                                System.out.println("THANKS FOR USEING OUR PROGRAMMING");
                                break;
                        }
                    } while (choice2 != 3);
                    break;

                case 2:
                    do {
                        System.out.println("##-------------WORK WITH CUSTOMER----------------##");
                        System.out.println("##              1.Add Customer.                  ##");
                        System.out.println("##              2.Show Customer.                 ##");
                        System.out.println("##              3.Back         .                 ##");
                        System.out.println("##-----------------------------------------------##");
                        System.out.print("Enter your choice: ");
                        choice3 = check.Check();
                        switch (choice3) {
                            case 1:
                                System.out.println("##-------------ADD INFORMATION----------------##");
                                System.out.println("##      1. Add information of customer.       ##");
                                System.out.println("##      2. Add information of Dealers.        ##");
                                System.out.println("##      3. Add information of Distributors.   ##");
                                System.out.println("##      4. Back.                              ##");
                                System.out.println("##--------------------------------------------##\n");
                                do {
                                    kt = 0;
                                    try {

                                        System.out.print("Enter your choice: ");
                                        choice = ip.nextInt();//nhap lua chon
                                    } catch (InputMismatchException ex) {
                                        System.out.println("ERROR: please enter the number for choice");
                                        kt++;
                                        ip.nextLine();
                                    }
                                } while (kt != 0);//thoat khi nhap so, khong nhap chu cho lua chon

                                switch (choice) {
                                    case 1:
                                        KhachHangException checkK = new KhachHangException();
                                        //khach hang
                                        do {
                                            //dien thong tin khach hang    
                                            System.out.println("---Add information of customer---");
                                            System.out.println("Enter date customer buy: ");
                                            date=checkK.CheckD();
                                            System.out.println("Enter name of customers: ");
                                            ip.nextLine();
                                            ten = ip.nextLine();//nhap ten
                                            System.out.println("Enter age of customer: ");
                                            tuoi = checkK.CheckA();
                                            System.out.println("Enter adress of customers: ");
                                            diaChi = ip.nextLine();//nhap dia chi khach hang
                                            System.out.println("Enter phone of customers: ");
                                            sdt = checkK.CheckP();//nhap sdt
                                            System.out.println("Enter the name of the drug the customer purchased: ");
                                            ten_sp_mua = ip.nextLine();//nhap ten thuoc khach mua 
                                            if (ten.equals("") || diaChi.equals("") || sdt.equals("") || ten_sp_mua.equals("")) {//neu khong nhap 1 trong nhung thong tin cua khach hang thi in ra thong bao
                                                System.out.println("Error: name or address or phone can't be empty!");
                                            }
                                        } while (ten.equals("") || diaChi.equals("") || sdt.equals("") || ten_sp_mua.equals(""));//lap den khi nhap day du thong tin khach hang

                                        System.out.println("Enter the amount that customers have to pay: ");
                                        money = checkK.Check();
                                        System.out.println("Paid? (Yes/No): ");
                                        Paid=checkK.CheckPaid();
                                        KhachHang kh = new KhachHang(date, ten, tuoi, diaChi, sdt, ten_sp_mua, money, Paid);//tao doi tuong khach hang
                                        // ghi vao file                     
                                        write(kh);
                                        // doc file
                                        System.out.println("\t\t\t------------LIST OF CUSTOMER---------------");
                                        readC(kh.date, kh.ten, kh.tuoi, kh.diaChi, kh.sdt, kh.ten_sp_mua, kh.money, kh.Paid);
                                        break;

                                    case 2:
                                        //dai li
                                        DaiLyEception checkD = new DaiLyEception();
                                        do {
                                            System.out.println("--Add information of Dealers---");
                                            //dien thong tin khach hang    
                                            ip.nextLine();
                                            System.out.println("Enter date customer buy: ");
                                            date=checkD.CheckD();
                                            System.out.println("Enter name of dealers: ");
                                            ten = ip.nextLine();//nhap ten
                                            // ip.nextLine();
                                            System.out.println("Enter adress of dealers: ");
                                            diaChi = ip.nextLine();//dia chi
                                            System.out.println("Enter phone of dealers: ");
                                            sdt = checkD.CheckP();//sdt
                                            System.out.println("Enter the name of the drug the dealers purchased: ");
                                            ten_sp_mua = ip.nextLine();//ten nhung loai thuoc da mua
                                            if (ten.equals("") || diaChi.equals("") || sdt.equals("") || ten_sp_mua.equals("")) {//neu nhap thieu thong tin thi in thong bao
                                                System.out.println("Error: name or address or phone or name of product can't be empty!");
                                            }
                                        } while (ten.equals("") || diaChi.equals("") || sdt.equals("") || ten_sp_mua.equals(""));//nhap du thong tin thi thoat
                                        System.out.println("Enter the amount that dealers have to pay: ");
                                        money = checkD.Check();
                                        System.out.println("Paid? (Yes/No): ");
                                        Paid=checkD.CheckPaid();
                                        DaiLi dl = new DaiLi(date, ten, diaChi, sdt, ten_sp_mua, money);
                                        // ghi vao file                     
                                        write(dl);
                                        // doc file
                                        System.out.println("\t\t\t------------LIST OF DEALERS---------------");
                                        readDe(dl.date, dl.ten, dl.diaChi, dl.sdt, dl.ten_sp_mua, dl.money, dl.Paid);
                                        break;

                                    case 3:
                                        PhanPhoiException checkP = new PhanPhoiException();
                                        do {
                                            System.out.println("---Add information of Distributors---");
                                            //dien thong tin phan phoi
                                            ip.nextLine();
                                             System.out.println("Enter date customer buy: ");
                                            date=checkP.CheckD();
                                            System.out.println("Enter name of Distributors: ");
                                            ten = ip.nextLine();
                                            System.out.println("Enter phone of Distributors: ");
                                            sdt = checkP.CheckP();
                                            System.out.println("Enter address of Distributors");
                                            diaChi=ip.nextLine();
                                            System.out.println("Enter the name of the drug the Distributors purchased: ");
                                            ten_sp_mua = ip.nextLine();
                                            if (ten.equals("") || sdt.equals("") || ten_sp_mua.equals("")) {
                                                System.out.println("Error: name phone can't be empty!");
                                            }
                                        } while (ten.equals("") || sdt.equals("") || ten_sp_mua.equals(""));
                                        System.out.println("Enter the amount that Distributors have to pay: ");
                                        money = checkP.Check();
                                        System.out.println("Paid? (Yes/No):");
                                        Paid=checkP.CheckPaid();
                                        PhanPhoi pp = new PhanPhoi(date, ten, diaChi, sdt, ten_sp_mua, money, Paid);
                                        // ghi vao file                     
                                        write(pp);
                                        // doc file
                                        System.out.println("\t\t\t------------LIST OF DISTRIBUTORS---------------");
                                        readD(pp.date, pp.ten, pp.diaChi, pp.sdt, pp.ten_sp_mua, pp.money, pp.Paid);
                                        break;

                                    case 4:
                                        System.out.println("Back!!!!");
                                        break;
                                    default:
                                        System.out.println("ERROR: Please enter the correct selection!!");

                                }
                                break;
                            case 2:
                                System.out.println("##-------------SHOW INFORMATION----------------##");
                                System.out.println("##      1. Show information of customer.       ##");
                                System.out.println("##      2. Show information of Dealers.        ##");
                                System.out.println("##      3. Show information of Distributors.   ##");
                                System.out.println("##      4. Back.                               ##");
                                System.out.println("##---------------------------------------------##\n");
                                choice4 = check.Check();
                                switch (choice4) {
                                    case 1:
                                        KhachHang kh = new KhachHang(date, ten, tuoi, diaChi, sdt, ten_sp_mua, money, Paid);//tao doi tuong khach hang
                                        System.out.println("\t\t\t------------LIST OF CUSTOMER---------------");
                                        readC(kh.date, kh.ten, kh.tuoi, kh.diaChi, kh.sdt, kh.ten_sp_mua, kh.money, kh.Paid);
                                        break;
                                    case 2:
                                        DaiLi dl = new DaiLi(date, ten, diaChi, sdt, ten_sp_mua, money);
                                        System.out.println("\t\t\t------------LIST OF DEALERS---------------");
                                        readDe(dl.date, dl.ten, dl.diaChi, dl.sdt, dl.ten_sp_mua, dl.money, dl.Paid);
                                        break;
                                    case 3:
                                        PhanPhoi pp = new PhanPhoi(date, ten, diaChi ,sdt, ten_sp_mua, money, Paid);
                                        System.out.println("\t\t\t------------LIST OF DISTRIBUTORS---------------");
                                        readD(pp.date, pp.ten, pp.diaChi, pp.sdt, pp.ten_sp_mua, pp.money, pp.Paid);
                                        break;
                                    case 4:
                                        System.out.println("Back!!!!");
                                        break;
                                    default:
                                        System.out.println("ERROR: Please enter the correct selection!!");
                                        break;

                                }

                                break;
                            case 3:
                                System.out.println("THANKS FOR USEING OUR PROGRAMMING");
                                break;

                        }
                    } while (choice3 != 3);
                    break;
                case 3:
                    System.out.println("THANKS FOR USEING OUR PROGRAMMING");
                    break;
                default:
                    System.out.println("ERROR: Please enter the correct selection!!");
                    break;

            }
        } while (choice1 != 3);
    }

}
