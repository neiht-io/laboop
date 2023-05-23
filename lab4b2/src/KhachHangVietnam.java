/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
class KhachHangVietNam extends KhachHang {
String doiTuongKhachHang;
int soLuong;
double donGia;
int dinhMuc;
KhachHangVietNam(String maKhachHang, String hoTen, Ngay ngayHoaDon, String doiTuongKhachHang, int soLuong, double donGia, int dinhMuc) {
    super(maKhachHang, hoTen, ngayHoaDon);
    this.doiTuongKhachHang = doiTuongKhachHang;
    this.soLuong = soLuong;
    this.donGia = donGia;
    this.dinhMuc = dinhMuc;
}

@Override
double tinhThanhTien() {
    double thanhTien;
    if (soLuong <= dinhMuc) {
        thanhTien = soLuong * donGia;
    } else {
        thanhTien = soLuong * donGia * dinhMuc + (soLuong - dinhMuc) * donGia * 2.5;
    }
    return thanhTien;
}
}
