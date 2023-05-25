
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang;
    private Queue<KhachHang> hangChoMuaVe;

    public QuanLyKhachHang() {
        danhSachKhachHang = new ArrayList<>();
        hangChoMuaVe = new LinkedList<>();
        napDuLieuTuFile();
    }

    public void themKhachHang(KhachHang khachHang) {
        if (hangChoMuaVe.contains(khachHang)) {
            for (KhachHang kh : hangChoMuaVe) {
                if (kh.getSoCMND().equals(khachHang.getSoCMND())) {
                    kh.setGaDen(khachHang.getGaDen());
                    kh.setGiaTien(khachHang.getGiaTien());
                    break;
                }
            }
        } else {
            danhSachKhachHang.add(khachHang);
            hangChoMuaVe.add(khachHang);
        }
        System.out.println("Thêm khách hàng thành công.");
    }
private double tongTienDaThuVe;

    public void banVe() {
        if (hangChoMuaVe.isEmpty()) {
            System.out.println("Không có khách hàng trong hàng chờ mua vé.");
            return;
        }
        KhachHang khachHang = hangChoMuaVe.poll();
        danhSachKhachHang.remove(khachHang);
        tongTienDaThuVe+= khachHang.getGiaTien();
        System.out.println("Bán vé thành công cho khách hàng: " + khachHang.getTen());
    }

    public void hienThiDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        System.out.println("Danh sách khách hàng:");
        for (KhachHang khachHang : danhSachKhachHang) {
            System.out.println(khachHang);
        }
    }

    public void huyKhachHang(String soCMND) {
        KhachHang khachHangToRemove = null;
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getSoCMND().equals(soCMND)) {
                khachHangToRemove = khachHang;
                break;
            }
        }
        if (khachHangToRemove != null) {
            danhSachKhachHang.remove(khachHangToRemove);
            hangChoMuaVe.remove(khachHangToRemove);
            System.out.println("Hủy khách hàng thành công.");
        } else {
            System.out.println("Không tìm thấy khách hàng cần hủy.");
        }
    }

    public void thongKeTinhHinh() {
        System.out.println("Tình hình bán vé:");
        System.out.println("Số khách hàng chờ nhận vé: " + hangChoMuaVe.size());
        System.out.println("Số khách hàng đã nhận vé: " + (danhSachKhachHang.size() - hangChoMuaVe.size()));
//        double tongTien = 0;
//        for (KhachHang khachHang : danhSachKhachHang) {
//            tongTien += khachHang.getGiaTien();
//        }
        System.out.println("Tổng số tiền đã thu về: " + tongTienDaThuVe);
    }

    public void luuDuLieuVaoFile() {
        try {
            FileOutputStream fos = new FileOutputStream("danhsachkhachhang.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(danhSachKhachHang);
            oos.close();
            fos.close();
            System.out.println("Lưu dữ liệu thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void napDuLieuTuFile() {
        try {
            FileInputStream fis = new FileInputStream("danhsachkhachhang.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            danhSachKhachHang = (List<KhachHang>) ois.readObject();
            ois.close();
            fis.close();
            for (KhachHang khachHang : danhSachKhachHang) {
                hangChoMuaVe.add(khachHang);
            }
            System.out.println("Nạp dữ liệu từ file thành công.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void hienThiDanhSachGaChuaMuaVe() {
        Set<String> dsGaChuaMuaVe = new HashSet<>();
        for (KhachHang khachHang : hangChoMuaVe) {
            dsGaChuaMuaVe.add(khachHang.getGaDen());
        }
        System.out.println("Danh sách các ga đang chờ mua vé:");
        for (String ga : dsGaChuaMuaVe) {
            System.out.println(ga);
        }
    }

    public void hienThiDanhSachGaVaSoVeTuongUng() {
        Map<String, Integer> dsGaVaSoVe = new HashMap<>();
        for (KhachHang khachHang : hangChoMuaVe) {
            String gaDen = khachHang.getGaDen();
            dsGaVaSoVe.put(gaDen, dsGaVaSoVe.getOrDefault(gaDen, 0) + 1);
        }
        System.out.println("Danh sách các ga đang chờ mua vé và số vé tương ứng:");
        for (Map.Entry<String, Integer> entry : dsGaVaSoVe.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vé");
        }
    }
}