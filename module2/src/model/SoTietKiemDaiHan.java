package model;

public class SoTietKiemDaiHan extends SoTietKiem {
    private String uuDai;

    public SoTietKiemDaiHan(){

    }

    public SoTietKiemDaiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGoi, int kyHan, double soTienGui, double laiSuat, String uuDai){
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDauGoi, kyHan, soTienGui, laiSuat);
        this.uuDai = uuDai;
    }



    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    public String toString(){
        return super.toString() + " Uu dai: "+getUuDai();
    }

}
