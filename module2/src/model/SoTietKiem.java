package model;

public abstract class SoTietKiem {
    private String maSoSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoiGianBatDauGoi;
    private int kyHan;
    private double soTienGui;
    private double laiSuat;

    public SoTietKiem(){

    }

    public SoTietKiem(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGoi, int kyHan, double soTienGui, double laiSuat){
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDauGoi = thoiGianBatDauGoi;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public SoTietKiem(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatDauGoi, double soTienGui, double laiSuat){
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDauGoi = thoiGianBatDauGoi;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public String getMaSoSo() {
        return maSoSo;
    }

    public void setMaSoSo(String maSoSo) {
        this.maSoSo = maSoSo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianBatDauGoi() {
        return thoiGianBatDauGoi;
    }

    public void setThoiGianBatDauGoi(String thoiGianBatDauGoi) {
        this.thoiGianBatDauGoi = thoiGianBatDauGoi;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String toString(){
        return "Ma so so: "+getMaSoSo()+" Ma khach hang: "+getMaKhachHang()+" Ngay mo so: "+getNgayMoSo()+" Thoi gian bat dau: "+getThoiGianBatDauGoi()+
                " Ky han: "+getKyHan()+" So tien gui: "+getSoTienGui()+ " Lai suat: "+getLaiSuat();
    }

    public String toString1(){
        return "Ma so so: "+getMaSoSo()+" Ma khach hang: "+getMaKhachHang()+" Ngay mo so: "+getNgayMoSo()+" Thoi gian bat dau: "+getThoiGianBatDauGoi()+
                " So tien gui: "+getSoTienGui()+ " Lai suat: "+getLaiSuat();
    }


    public String toString2() {
        return "SoTietKiem{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianBatDauGoi='" + thoiGianBatDauGoi + '\'' +
                ", kyHan=" + kyHan +
                ", soTienGui=" + soTienGui +
                ", laiSuat=" + laiSuat +
                '}';
    }
}
