package model;

public class SoTietKiemNganHan extends SoTietKiem {
    public SoTietKiemNganHan(){

    }
    public SoTietKiemNganHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGoi, int kyHan, double soTienGui, double laiSuat){
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGui, laiSuat);
    }


    public String toString(){
        return super.toString();
    }

}
