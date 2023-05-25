
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhong;

    public QuanLyPhongHoc() {
        danhSachPhong = new ArrayList<>();
    }

    public void themPhong(PhongHoc phongHoc) {
        for (PhongHoc phong : danhSachPhong) {
            if (phong.getMaPhong().equals(phongHoc.getMaPhong())) {
                System.out.println("Thêm phòng không thành công. Mã phòng đã tồn tại.");
                return;
            }
        }
        danhSachPhong.add(phongHoc);
        System.out.println("Thêm phòng thành công.");
    }

    public PhongHoc timPhong(String maPhong) {
        for (PhongHoc phong : danhSachPhong) {
            if (phong.getMaPhong().equals(maPhong)) {
                return phong;
            }
        }
        return null;
    }

    public void inDanhSachPhong() {
        if (danhSachPhong.isEmpty()) {
            System.out.println("Danh sách phòng học trống.");
        } else {
            System.out.println("Danh sách phòng học:");
            for (PhongHoc phong : danhSachPhong) {
                System.out.println(phong);
            }
        }
    }

    public void inDanhSachPhongDatChuan() {
        if (danhSachPhong.isEmpty()) {
            System.out.println("Danh sách phòng học trống.");
        } else {
            System.out.println("Danh sách phòng học đạt chuẩn:");
            for (PhongHoc phong : danhSachPhong) {
                if (phong.datChuan()) {
                    System.out.println(phong);
                }
            }
        }
    }

    public void sapXepTheoDayNha() {
        Collections.sort(danhSachPhong, (phong1, phong2) -> phong1.getDayNha().compareTo(phong2.getDayNha()));
        System.out.println("Danh sách phòng học đã được sắp xếp tăng dần theo cột dãy nhà.");
    }

    public void sapXepTheoDienTich() {
        Collections.sort(danhSachPhong, (phong1, phong2) -> Double.compare(phong1.getDienTich(), phong2.getDienTich()));
        System.out.println("Danh sách phòng học đã được sắp xếp giảm dần theo cột diện tích.");
    }

    public void sapXepTheoSoBongDen() {
        Collections.sort(danhSachPhong, (phong1, phong2) -> Integer.compare(phong1.getSoBongDen(), phong2.getSoBongDen()));
        System.out.println("Danh sách phòng học đã được sắp xếp tăng dần theo cột số bóng đèn.");
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinh) {
        for (PhongHoc phong : danhSachPhong) {
            if (phong instanceof PhongMayTinh && phong.getMaPhong().equals(maPhong)) {
                ((PhongMayTinh) phong).setSoMayTinh(soMayTinh);
                System.out.println("Cập nhật số máy tính thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng máy tính với mã phòng " + maPhong);
    }

    public void xoaPhong(String maPhong) {
        Iterator<PhongHoc> iterator = danhSachPhong.iterator();
        while (iterator.hasNext()) {
            PhongHoc phong = iterator.next();
            if (phong.getMaPhong().equals(maPhong)) {
                iterator.remove();
                System.out.println("Xóa phòng thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng với mã phòng " + maPhong);
    }

    public void inTongSoPhong() {
        System.out.println("Tổng số phòng học: " + danhSachPhong.size());
    }

    public void inDanhSachPhongMay60May() {
        boolean found = false;
        for (PhongHoc phong : danhSachPhong) {
            if (phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoMayTinh() == 60) {
                System.out.println(phong);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phòng máy tính nào có 60 máy.");
        }
    }
}