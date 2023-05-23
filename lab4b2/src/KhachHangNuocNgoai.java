/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */

    
class KhachHangNuocNgoai extends KhachHang {
String quocTich;
int soLuong;
double donGia;
KhachHangNuocNgoai(String maKhachHang, String hoTen, Ngay ngayHoaDon, String quocTich, int soLuong, double donGia) {
    super(maKhachHang, hoTen, ngayHoaDon);
    this.quocTich = quocTich;
    this.soLuong = soLuong;
    this.donGia = donGia;
}

@Override
double tinhThanhTien() {
    return soLuong * donGia;
}
}