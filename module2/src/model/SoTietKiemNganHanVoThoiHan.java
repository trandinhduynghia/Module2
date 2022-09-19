package model;

public class SoTietKiemNganHanVoThoiHan extends SoTietKiem{
    public SoTietKiemNganHanVoThoiHan(){

    }

    public SoTietKiemNganHanVoThoiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGoi, double soTienGui, double laiSuat){
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGoi, soTienGui, laiSuat);
    }

    public String toString(){
        return super.toString1();
    }
}
