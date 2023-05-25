
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
class KhachHang implements Serializable {
    private String soCMND;
    private String ten;
    private String gaDen;
    private double giaTien;

    public KhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.ten = ten;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public String getTen() {
        return ten;
    }

    public String getGaDen() {
        return gaDen;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    

    @Override
    public String toString() {
        return "KhachHang{" +
                "soCMND='" + soCMND + '\'' +
                ", ten='" + ten + '\'' +
                ", gaDen='" + gaDen + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }
}