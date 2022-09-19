package Controller;

import Validate.Validate;
import exception.UserException;
import model.SoTietKiem;
import model.SoTietKiemDaiHan;
import model.SoTietKiemNganHan;
import model.SoTietKiemNganHanVoThoiHan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuanLySoTietKiem {
    Scanner scanner = new Scanner(System.in);
    public List<SoTietKiemDaiHan> soTietKiemDaiHans = new ArrayList<>();
    public List<SoTietKiem> soTietKiemNganHans = new ArrayList<>();

    private SoTietKiemDaiHan themSoTietKiemDaiHan() {
        System.out.println("Mã STK: ");
        String maSTK = null;
        while (true){
            try {
                maSTK = Validate.validateMaSTK();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Mã KH: ");
        String maKH = scanner.nextLine();
        System.out.println("Ngày mở sổ: ");
        String ngayMoSo = null;
        while (true){
            try {
                ngayMoSo = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thời gian bắt đầu gởi: ");
        String thoiGianBatDauGoi = null;
        while (true){
            try {
                thoiGianBatDauGoi = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Kỳ hạn: ");
        int kyHan = Validate.validateKyHan();
        System.out.println("Số tiền gởi: ");
        Double soTienGoi = Validate.validateSoTien();
        System.out.println("Lãi suất: ");
        Double laiSuat = Double.parseDouble(scanner.nextLine());
        System.out.println("Ưu đãi: ");
        String uuDai = scanner.nextLine();
        return new SoTietKiemDaiHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGoi, laiSuat, uuDai);
    }
    public void themSTKDaiHan() {
        soTietKiemDaiHans = readFiles();
        SoTietKiemDaiHan soTietKiemDaiHan = themSoTietKiemDaiHan();
        soTietKiemDaiHans.add(soTietKiemDaiHan);
        System.out.println("Thêm thành công!");
        writeToFiles();
    }
    public int timSTKDaiHan(String name) {
        int index = -1;
        for(int i = 0; i < soTietKiemDaiHans.size(); i++){
            if(soTietKiemDaiHans.get(i).getMaSoSo().equals(name))
                index = i;
        }
        return index;
    }
    public void xoaSTKDaiHan() {
        soTietKiemDaiHans = readFiles();
        System.out.println("Mã STK: ");
        String maSTK = null;
        while (true){
            try {
                maSTK = Validate.validateMaSTK();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            writeToFiles();
        }
        int index = timSTKDaiHan(maSTK);
        if (index == -1) {
            System.err.println("STK nhập vào không tồn tại!");
        } else {
            soTietKiemDaiHans.remove(index);
            System.out.println("Xóa thành công!");
        }
        writeToFiles();
    }


    public void hienThiSTKDaiHan() {
        soTietKiemDaiHans = readFiles();
        for (SoTietKiemDaiHan soTietKiemDaiHan : soTietKiemDaiHans){
            System.out.println(soTietKiemDaiHan.toString());
        }
    }

    public List<SoTietKiemDaiHan> readFiles()  {
        String DELIMITER = ",";
        String EMPTY = "";
        List<SoTietKiemDaiHan> soTietKiemDaiHans = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module2\\module2\\src\\data\\sotietkiemdaihan.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 8){
                    continue;
                }
                String maSTK = result[0];
                String maKH = result[1];
                String ngayMoSo = result[2];
                String thoiGianBatDauGoi = result[3];
                int kyHan = Integer.parseInt(result[4]);
                double soTienGoi = Double.parseDouble(result[5]);
                double laiSuat = Double.parseDouble(result[6]);
                String uuDai = result[7];
                soTietKiemDaiHans.add(new SoTietKiemDaiHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGoi, laiSuat, uuDai));
            }
            //for(SoTietKiemDaiHan SoTietKiemDaiHan : soTietKiemDaiHans){
            //System.out.println(SoTietKiemDaiHan.toString());
            //}
        }catch (IOException e){
            e.printStackTrace();
        }
        return soTietKiemDaiHans;
    }

    public void writeToFiles() {
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\module2\\src\\data\\sotietkiemdaihan.csv", false))){
            for(SoTietKiemDaiHan soTietKiemDaiHan: soTietKiemDaiHans){
                writer.write(soTietKiemDaiHan.getMaSoSo()+DELIMITER+soTietKiemDaiHan.getMaKhachHang()+DELIMITER+soTietKiemDaiHan.getNgayMoSo()+DELIMITER+soTietKiemDaiHan.getNgayMoSo()+DELIMITER
                        +soTietKiemDaiHan.getKyHan()+DELIMITER+soTietKiemDaiHan.getSoTienGui()+DELIMITER+soTietKiemDaiHan.getLaiSuat()+DELIMITER
                        +soTietKiemDaiHan.getUuDai());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private SoTietKiemNganHan themSoTietKiemNganHan() {
        System.out.println("Mã STK: ");
        String maSTK = null;
        while (true){
            try {
                maSTK = Validate.validateMaSTK();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Mã KH: ");
        String maKH = scanner.nextLine();
        System.out.println("Ngày mở sổ: ");
        String ngayMoSo = null;
        while (true){
            try {
                ngayMoSo = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thời gian bắt đầu gởi: ");
        String thoiGianBatDauGoi = null;
        while (true){
            try {
                thoiGianBatDauGoi = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Kỳ hạn: ");
        int kyHan = Validate.validateKyHan();
        System.out.println("Số tiền gởi: ");
        Double soTienGoi = Validate.validateSoTien();
        System.out.println("Lãi suất: ");
        Double laiSuat = Double.parseDouble(scanner.nextLine());
        return new SoTietKiemNganHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGoi, laiSuat);
    }

    private SoTietKiemNganHanVoThoiHan themSoTietKiemNganHanVoThoiHan() {
        System.out.println("Mã STK: ");
        String maSTK = null;
        while (true){
            try {
                maSTK = Validate.validateMaSTK();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Mã KH: ");
        String maKH = scanner.nextLine();
        System.out.println("Ngày mở sổ: ");
        String ngayMoSo = null;
        while (true){
            try {
                ngayMoSo = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thời gian bắt đầu gởi: ");
        String thoiGianBatDauGoi = null;
        while (true){
            try {
                thoiGianBatDauGoi = Validate.validateBirthday();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Số tiền gởi: ");
        Double soTienGoi = Validate.validateSoTien();
        System.out.println("Lãi suất: ");
        Double laiSuat = Double.parseDouble(scanner.nextLine());
        return new SoTietKiemNganHanVoThoiHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi,soTienGoi, laiSuat);
    }

    public void themSTKNganHan() {
        soTietKiemNganHans = readFiles1();
        SoTietKiemNganHan soTietKiemNganHan = themSoTietKiemNganHan();
        soTietKiemNganHans.add(soTietKiemNganHan);
        System.out.println("Thêm thành công!");
        writeToFiles1();
    }

    public void themSTKNganHanVoThoiHan() {
        soTietKiemNganHans = readFiles1();
        SoTietKiemNganHanVoThoiHan soTietKiemNganHanVoThoiHan = themSoTietKiemNganHanVoThoiHan();
        soTietKiemNganHans.add(soTietKiemNganHanVoThoiHan);
        System.out.println("Thêm thành công!");
        writeToFiles1();
    }

    public int timSTKNganHan(String name) {
        int index = -1;
        for(int i = 0; i < soTietKiemNganHans.size(); i++){
            if(soTietKiemNganHans.get(i).getMaSoSo().equals(name))
                index = i;
        }
        return index;
    }

    public void xoaSTKNganHan() {
        soTietKiemNganHans = readFiles1();
        System.out.println("Mã STK: ");
        String maSTK = null;
        while (true){
            try {
                maSTK = Validate.validateMaSTK();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        int index = timSTKNganHan(maSTK);
        if (index == -1) {
            System.out.println("STK nhập vào không tồn tại!");
        } else {
            soTietKiemNganHans.remove(index);
            System.out.println("Xóa thành công!");
        }
        writeToFiles1();
    }

    public void hienThiSTKNganHan() {
        soTietKiemNganHans = readFiles1();
        for (SoTietKiem soTietKiem : soTietKiemNganHans){
            System.out.println(soTietKiem.toString());
        }
    }

    public List<SoTietKiem> readFiles1()  {
        String DELIMITER = ",";
        String EMPTY = "";
        List<SoTietKiem> soTietKiemNganHans = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module2\\module2\\src\\data\\sotietkiemnganhan.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                //if(result.length != 7 || result.length != 6){
                    //continue;
                //}
                if(result.length == 7){
                    String maSTK = result[0];
                    String maKH = result[1];
                    String ngayMoSo = result[2];
                    String thoiGianBatDauGoi = result[3];
                    int kyHan = Integer.parseInt(result[4]);
                    double soTienGoi = Double.parseDouble(result[5]);
                    double laiSuat = Double.parseDouble(result[6]);
                    soTietKiemNganHans.add(new SoTietKiemNganHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGoi, laiSuat));
                }
                if(result.length == 6){
                    String maSTK = result[0];
                    String maKH = result[1];
                    String ngayMoSo = result[2];
                    String thoiGianBatDauGoi = result[3];
                    double soTienGoi = Double.parseDouble(result[4]);
                    double laiSuat = Double.parseDouble(result[5]);
                    soTietKiemNganHans.add(new SoTietKiemNganHanVoThoiHan(maSTK, maKH, ngayMoSo, thoiGianBatDauGoi, soTienGoi, laiSuat));
                }
            }
            for (int i = 0; i < soTietKiemNganHans.size(); i++){
                System.out.println(soTietKiemNganHans.get(i).toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return soTietKiemNganHans;
    }

    public void writeToFiles1() {
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\module2\\src\\data\\sotietkiemnganhan.csv", false))){
            for(SoTietKiem soTietKiem: soTietKiemNganHans){
                if(soTietKiem instanceof SoTietKiemNganHan){
                    writer.write(soTietKiem.getMaSoSo()+DELIMITER+soTietKiem.getMaKhachHang()+DELIMITER+soTietKiem.getNgayMoSo()+DELIMITER+soTietKiem.getNgayMoSo()+DELIMITER
                            +soTietKiem.getKyHan()+DELIMITER+soTietKiem.getSoTienGui()+DELIMITER+soTietKiem.getLaiSuat());
                    writer.newLine();
                }
                if (soTietKiem instanceof SoTietKiemNganHanVoThoiHan){
                    writer.write(soTietKiem.getMaSoSo()+DELIMITER+soTietKiem.getMaKhachHang()+DELIMITER+soTietKiem.getNgayMoSo()+DELIMITER+soTietKiem.getNgayMoSo()+DELIMITER
                            +soTietKiem.getSoTienGui()+DELIMITER+soTietKiem.getLaiSuat());
                    writer.newLine();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
