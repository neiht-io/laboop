/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author khact
 */


public class Main {
    public static void main(String[] args) {
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 9) {
            System.out.println("\n---- Quản lý xếp hàng mua vé tại nhà ga ----");
            System.out.println("1. Thêm một khách hàng mới vào hàng đợi mua vé");
            System.out.println("2. Bán một vé cho khách hàng");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Hủy một khách hàng ra khỏi danh sách");
            System.out.println("5. Thống kê tình hình bán vé");
            System.out.println("6. Lưu danh sách vào file");
            System.out.println("7. Hiển thị danh sách các ga đang chờ mua vé");
            System.out.println("8. Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga");
            System.out.println("9. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Đọc bỏ kí tự '\n' sau khi nhập choice
                    System.out.print("Nhập số CMND khách hàng: ");
                    String soCMND = scanner.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập ga đến: ");
                    String gaDen = scanner.nextLine();
                    System.out.print("Nhập giá tiền: ");
                    double giaTien = scanner.nextDouble();
                    KhachHang khachHang = new KhachHang(soCMND, ten, gaDen, giaTien);
                    quanLyKhachHang.themKhachHang(khachHang);
                    break;
                case 2:
                    quanLyKhachHang.banVe();
                    break;
                case 3:
                    quanLyKhachHang.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    scanner.nextLine(); // Đọc bỏ kí tự '\n' sau khi nhập choice
                    System.out.print("Nhập số CMND khách hàng cần hủy: ");
                    String cmnd = scanner.nextLine();
                    quanLyKhachHang.huyKhachHang(cmnd);
                    break;
                case 5:
                    quanLyKhachHang.thongKeTinhHinh();
                    break;
                case 6:
                    quanLyKhachHang.luuDuLieuVaoFile();
                    break;
                case 7:
                    quanLyKhachHang.hienThiDanhSachGaChuaMuaVe();
                    break;
                case 8:
                    quanLyKhachHang.hienThiDanhSachGaVaSoVeTuongUng();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }

        scanner.close();
    }
}
