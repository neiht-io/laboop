
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khact
 */
public class Main {

    public static void main(String[] args) {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm kiếm phòng học");
            System.out.println("3. In danh sách phòng học");
            System.out.println("4. In danh sách phòng học đạt chuẩn");
            System.out.println("5. Sắp xếp danh sách theo dãy nhà");
            System.out.println("6. Sắp xếp danh sách theo diện tích");
            System.out.println("7. Sắp xếp danh sách theo số bóng đèn");
            System.out.println("8. Cập nhật số máy tính cho phòng máy tính");
            System.out.println("9. Xóa phòng học");
            System.out.println("10. In tổng số phòng học");
            System.out.println("11. In danh sách phòng máy có 60 máy");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã phòng: ");
                    String maPhong = scanner.nextLine();
                    System.out.print("Nhập dãy nhà: ");
                    String dayNha = scanner.nextLine();
                    System.out.print("Nhập diện tích: ");
                    double dienTich = scanner.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = scanner.nextInt();
                    System.out.println("1. Phòng lý thuyết");
                    System.out.println("2. Phòng máy tính");
                    System.out.println("3. Phòng thí nghiệm");
                    System.out.print("Chọn loại phòng: ");
                    int loaiPhong = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line

                    switch (loaiPhong) {
                        case 1:
                            System.out.print("Có máy chiếu (true/false): ");
                            boolean coMayChieu = scanner.nextBoolean();
                            PhongLyThuyet phongLyThuyet = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                            quanLyPhongHoc.themPhong(phongLyThuyet);
                            break;
                        case 2:
                            System.out.print("Nhập số máy tính: ");
                            int soMayTinh = scanner.nextInt();
                            PhongMayTinh phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                            quanLyPhongHoc.themPhong(phongMayTinh);
                            break;
                        case 3:
                            System.out.print("Nhập chuyên ngành: ");
                            String chuyenNganh = scanner.nextLine();
                            System.out.print("Nhập sức chứa: ");
                            int sucChua = scanner.nextInt();
                            System.out.print("Có bồn rửa (true/false): ");
                            boolean coBonRua = scanner.nextBoolean();
                            PhongThiNghiem phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                            quanLyPhongHoc.themPhong(phongThiNghiem);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    maPhong = scanner.nextLine();
                    PhongHoc phong = quanLyPhongHoc.timPhong(maPhong);
                    if (phong != null) {
                        System.out.println("Thông tin phòng học:");
                        System.out.println(phong);
                    } else {
                        System.out.println("Không tìm thấy phòng với mã phòng " + maPhong);
                    }
                    break;
                case 3:
                    quanLyPhongHoc.inDanhSachPhong();
                    break;
                case 4:
                    quanLyPhongHoc.inDanhSachPhongDatChuan();
                    break;
                case 5:
                    quanLyPhongHoc.sapXepTheoDayNha();
                    break;
                case 6:
                    quanLyPhongHoc.sapXepTheoDienTich();
                    break;
                case 7:
                    quanLyPhongHoc.sapXepTheoSoBongDen();
                    break;
                case 8:
                    System.out.print("Nhập mã phòng cần cập nhật số máy tính: ");
                    maPhong = scanner.nextLine();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayTinh = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    quanLyPhongHoc.capNhatSoMayTinh(maPhong, soMayTinh);
                    break;

                case 9:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    maPhong = scanner.nextLine();
                    quanLyPhongHoc.xoaPhong(maPhong);
                    break;
                case 10:
                    quanLyPhongHoc.inTongSoPhong();
                    break;
                case 11:
                    quanLyPhongHoc.inDanhSachPhongMay60May();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
