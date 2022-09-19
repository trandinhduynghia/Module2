package model;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    public String diaChi;

    public KhachHang(){

    }

    public KhachHang(String maKH, String tenKH, String ngaySinh, String gioiTinh, String soDienThoai, String diaChi){
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String toString(){
        return "Ma KH: "+getMaKH()+" Ten KH: "+getTenKH()+" Ngay sinh: "+getNgaySinh()+" Gioi tinh: "+getGioiTinh()+" SDT: "+getSoDienThoai()+
                " Dia chi: "+getDiaChi();
    }
}
