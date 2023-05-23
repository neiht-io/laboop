
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
public class DiemHocVien {

    String hoTen;
    int namSinh;
    double[] diemMonHoc;

    public DiemHocVien(String hoTen, int namSinh, double[] diemMonHoc) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemMonHoc = diemMonHoc;
    }

    public boolean coLamLuanVan() {
        double diemTrungBinh = tinhDiemTrungBinh();
        for (double diem : diemMonHoc) {
            if (diem < 5) {
                return false;
            }
        }
        return diemTrungBinh > 7;
    }

    public boolean coThiTotNghiep() {
        double diemTrungBinh = tinhDiemTrungBinh();
        for (double diem : diemMonHoc) {
            if (diem < 5) {
                return false;
            }
        }
        return diemTrungBinh <=7 ;
    }
    
        public boolean coThiLai() {
       
        for (double diem : diemMonHoc) {
            if (diem < 5) {
                return true;
            }
        }
        return false ;
    }
    
        public  List <String> getMonThiLai (){
        List <String >monThiLai = new ArrayList<>();
        if (coThiLai()){
         String [] monHoc = {"Toán 1","Toán 2","Toán 3","Toán 4","Toán 5"};
         for (int i =0 ; i < diemMonHoc.length; i++){
         if (diemMonHoc [i] < 5){
         monThiLai.add(monHoc[i]);}}
        }
        return monThiLai;
                }
    double tinhDiemTrungBinh (){
    double tongDiem = 0;
   for (double diem : diemMonHoc){
   tongDiem += diem;}
        return tongDiem/diemMonHoc.length;
    }

}
