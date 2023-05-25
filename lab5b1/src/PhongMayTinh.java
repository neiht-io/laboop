/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
        
    }


public void setSoMayTinh(int soMayTinh) {
    this.soMayTinh = soMayTinh;
}


    public boolean datChuan() {
        return super.datChuan() && (getDienTich() / soMayTinh) >= 1.5;
    }

    public String toString() {
        return super.toString() +
               ", Số máy tính: " + soMayTinh;
    }
}