
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyGiaoDich {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GiaoDich> danhSachGiaoDich = new ArrayList<>();

        System.out.print("Nhập số lượng giao dịch: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin cho giao dịch thứ " + (i + 1) + ":");
            System.out.print("Loại giao dịch (1 - Đất, 2 - Nhà): ");
            int loaiGiaoDich = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Mã giao dịch: ");
            String maGiaoDich = scanner.nextLine();
            System.out.print("Ngày giao dịch (ngày/tháng/năm): ");
            String ngayGiaoDich = scanner.nextLine();
            System.out.print("Đơn giá: ");
            double donGia = scanner.nextDouble();
            System.out.print("Diện tích: ");
            double dienTich = scanner.nextDouble();
            scanner.nextLine();

            if (loaiGiaoDich == 1) {
                System.out.print("Loại đất (A, B, C): ");
                String loaiDat = scanner.nextLine();
                GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, loaiDat);
                danhSachGiaoDich.add(giaoDichDat);
            } else if (loaiGiaoDich == 2) {
                System.out.print("Loại nhà (cao cấp, thường): ");
                String loaiNha = scanner.nextLine();
                System.out.print("Địa chỉ: ");
                String diaChi = scanner.nextLine();
                GiaoDichNha giaoDichNha = new GiaoDichNha(loaiNha, diaChi, maGiaoDich, ngayGiaoDich, donGia, dienTich);
                danhSachGiaoDich.add(giaoDichNha);
            }
                    
        }

        System.out.println("Danh sách giao dịch:");
        for (GiaoDich giaoDich : danhSachGiaoDich) {
            if (giaoDich instanceof GiaoDichDat) {
                GiaoDichDat giaoDichDat = (GiaoDichDat) giaoDich;
                System.out.println("Giao dịch đất - Mã: " + giaoDichDat.maGiaoDich + ", Ngày: " + giaoDichDat.ngayGiaoDich +
                        ", Đơn giá: " + giaoDichDat.donGia + ", Diện tích: " + giaoDichDat.dienTich +
                        ", Loại đất: " + giaoDichDat.loaiDat);
            } else if (giaoDich instanceof GiaoDichNha) {
                GiaoDichNha giaoDichNha = (GiaoDichNha) giaoDich;
                System.out.println("Giao dịch nhà - Mã: " + giaoDichNha.maGiaoDich + ", Ngày: " + giaoDichNha.ngayGiaoDich +
                        ", Đơn giá: " + giaoDichNha.donGia + ", Diện tích: " + giaoDichNha.dienTich +
                        ", Loại nhà: " + giaoDichNha.loaiNha + ", Địa chỉ: " + giaoDichNha.diaChi);
            }
        }

        int countDat = 0;
        int countNha = 0;

        for (GiaoDich giaoDich : danhSachGiaoDich) {
            if (giaoDich instanceof GiaoDichDat) {
                countDat++;
            } else if (giaoDich instanceof GiaoDichNha) {
                countNha++;
            }
        }

        System.out.println("Tổng số lượng giao dịch đất: " + countDat);
        System.out.println("Tổng số lượng giao dịch nhà: " + countNha);

        double tongThanhTienDat = 0;
        

        for (GiaoDich giaoDich : danhSachGiaoDich) {
            if (giaoDich instanceof GiaoDichDat) {
                GiaoDichDat giaoDichDat = (GiaoDichDat) giaoDich;
                double thanhTien = 0;
                if (giaoDichDat.loaiDat.equals("A")) {
                    thanhTien = giaoDichDat.dienTich * giaoDichDat.donGia * 1.5;
                } else if (giaoDichDat.loaiDat.equals("B") || giaoDichDat.loaiDat.equals("C")) {
                    thanhTien = giaoDichDat.dienTich * giaoDichDat.donGia;
                }
                tongThanhTienDat += thanhTien;
                countDat++;
            }
        }

        double trungBinhThanhTienDat = tongThanhTienDat / countDat;
        System.out.println("Trung bình thành tiền của giao dịch đất: " + trungBinhThanhTienDat);

        String thangNamTimKiem = "23/05/2023";

        System.out.println("Các giao dịch của ngày 23/05/2023:");
        for (GiaoDich giaoDich : danhSachGiaoDich) {
            if (giaoDich.ngayGiaoDich.contains(thangNamTimKiem)) {
                if (giaoDich instanceof GiaoDichDat) {
                    GiaoDichDat giaoDichDat = (GiaoDichDat) giaoDich;
                    System.out.println("Giao dịch đất - Mã: " + giaoDichDat.maGiaoDich + ", Ngày: " + giaoDichDat.ngayGiaoDich +
                            ", Đơn giá: " + giaoDichDat.donGia + ", Diện tích: " + giaoDichDat.dienTich +
                            ", Loại đất: " + giaoDichDat.loaiDat);
                } else if (giaoDich instanceof GiaoDichNha) {
                    GiaoDichNha giaoDichNha = (GiaoDichNha) giaoDich;
                    System.out.println("Giao dịch nhà - Mã: " + giaoDichNha.maGiaoDich + ", Ngày: " + giaoDichNha.ngayGiaoDich +
                            ", Đơn giá: " + giaoDichNha.donGia + ", Diện tích: " + giaoDichNha.dienTich +
                            ", Loại nhà: " + giaoDichNha.loaiNha + ", Địa chỉ: " + giaoDichNha.diaChi);
                }
            }
        }

        scanner.close();
    }
}