
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
public class QuanLyDiemHocVien {

    public static void main(String[] args) {
        List<DiemHocVien> danhSachDiemHocVien = new ArrayList<>();

        double[] diemHocVien1 = {3, 4, 6, 8, 3};
        double[] diemHocVien2 = {8, 2, 10, 9, 6};
        double[] diemHocVien3 = {3, 5, 4, 7, 9};
        double[] diemHocVien4 = {5, 7, 4, 8, 5};
        double[] diemHocVien5 = {8, 8, 7, 4, 5};
        danhSachDiemHocVien.add(new DiemHocVien("Nguyen A", 2003, diemHocVien5));
        danhSachDiemHocVien.add(new DiemHocVien("Nguyen B", 2000, diemHocVien4));
        danhSachDiemHocVien.add(new DiemHocVien("Nguyen C", 2001, diemHocVien3));
        danhSachDiemHocVien.add(new DiemHocVien("Nguyen D", 2002, diemHocVien2));
        danhSachDiemHocVien.add(new DiemHocVien("Nguyen E", 2004, diemHocVien1));

        int soLuongLamLuanVan = 0;
        int soLuongThiTotNghiep = 0;
        int soLuongThiLai = 0;
        List<String> monThiLai = new ArrayList<>();
        for (DiemHocVien diemHocVien : danhSachDiemHocVien) {
            if (diemHocVien.coLamLuanVan()) {
                soLuongLamLuanVan++;
            }
            if (diemHocVien.coThiTotNghiep()) {
                soLuongThiTotNghiep++;
            }
            if (diemHocVien.coThiLai()){
                soLuongThiLai++;
                
             monThiLai.addAll(diemHocVien.getMonThiLai());
            }

        }
        System.out.println("Số người trong lớp được làm luận văn tốt nghiệp: " 
                + soLuongLamLuanVan);
        System.out.println("Số người trong lớp được thi tốt nghiệp: "
        + soLuongThiTotNghiep);
        System.out.println("Số lượng người trong lớp phải thi lại: " 
                + soLuongThiLai);
        System.out.println("các môn thi lại: "+ monThiLai);
    }
    
   
    
}
