
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
public class QuanLyHoaDon {
public static void main(String[] args) {
// Tạo danh sách khách hàng
List<KhachHang> danhSachKhachHang = new ArrayList<>();
    // Thêm khách hàng Việt Nam vào danh sách
    danhSachKhachHang.add(new KhachHangVietNam("KH001", "Nguyen Van A", new Ngay(10, 9, 2023), "sinh hoat", 100, 5000, 50));
    danhSachKhachHang.add(new KhachHangVietNam("KH002", "Tran Thi B", new Ngay(15, 9, 2023), "kinh doanh", 200, 6000, 100));
    danhSachKhachHang.add(new KhachHangVietNam("KH003", "Le Van C", new Ngay(25, 05, 2023), "san xuat", 300, 7000, 150));

    // Thêm khách hàng nước ngoài vào danh sách
    danhSachKhachHang.add(new KhachHangNuocNgoai("KH004", "John Smith", new Ngay(10, 9, 2023), "USA", 150, 8000));
    danhSachKhachHang.add(new KhachHangNuocNgoai("KH005", "Maria Garcia", new Ngay(25, 05, 2023), "Spain", 250, 9000));

    // In danh sách các hoá đơn
    System.out.println("Danh sách hoá đơn:");
    for (KhachHang khachHang : danhSachKhachHang) {
        System.out.println("Mã khách hàng: " + khachHang.maKhachHang);
        System.out.println("Họ tên: " + khachHang.hoTen);
        System.out.println("Ngày hoá đơn: " + khachHang.ngayHoaDon.ngay + "/" + khachHang.ngayHoaDon.thang + "/" + khachHang.ngayHoaDon.nam);
        System.out.println("Thành tiền: " + khachHang.tinhThanhTien());
        System.out.println("------------------------");
    }

    // Tính tổng số lượng cho từng loại khách hàng
    int tongSoLuongKhachHangVietNam = 0;
    int tongSoLuongKhachHangNuocNgoai = 0;

    for (KhachHang khachHang : danhSachKhachHang) {
        if (khachHang instanceof KhachHangVietNam) {
            tongSoLuongKhachHangVietNam++;
        } else if (khachHang instanceof KhachHangNuocNgoai) {
            tongSoLuongKhachHangNuocNgoai++;
        }
    }

    System.out.println("Tổng số lượng khách hàng Việt Nam: " + tongSoLuongKhachHangVietNam);
    System.out.println("Tổng số lượng khách hàng nước ngoài: " + tongSoLuongKhachHangNuocNgoai);

    // Tính tổng thành tiền của khách hàng người nước ngoài
    double tongThanhTienKhachHangNuocNgoai = 0;

    for (KhachHang khachHang : danhSachKhachHang) {
        if (khachHang instanceof KhachHangNuocNgoai) {
            tongThanhTienKhachHangNuocNgoai += khachHang.tinhThanhTien();
        }
    }

    double trungBinhThanhTienKhachHangNuocNgoai = tongThanhTienKhachHangNuocNgoai / tongSoLuongKhachHangNuocNgoai;
    System.out.println("Trung bình thành tiền của khách hàng người nước ngoài: " + trungBinhThanhTienKhachHangNuocNgoai);

    System.out.println("Hoá đơn trong ngày 25 tháng 05 năm 2023:");
    for (KhachHang khachHang : danhSachKhachHang) {
        if (khachHang.ngayHoaDon.ngay == 25 && khachHang.ngayHoaDon.thang == 5 && khachHang.ngayHoaDon.nam == 2023) {
            System.out.println("Mã khách hàng: " + khachHang.maKhachHang);
            System.out.println("Họ tên: " + khachHang.hoTen);
            System.out.println("Ngày hoá đơn: " + khachHang.ngayHoaDon.ngay + "/" + khachHang.ngayHoaDon.thang + "/" + khachHang.ngayHoaDon.nam);
            System.out.println("Thành tiền: " + khachHang.tinhThanhTien());
            System.out.println("------------------------");
        }
    }
}

}