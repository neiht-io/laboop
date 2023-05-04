/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
    import java.util.Arrays;

public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    // Constructor
    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    // Getters and Setters
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD > 0) {
            this.maCD = maCD;
        }
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (!tuaCD.isEmpty()) {
            this.tuaCD = tuaCD;
        }
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        }
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        }
    }

    // Override toString method
    @Override
    public String toString() {
        return "CD{" +
                "maCD=" + maCD +
                ", tuaCD='" + tuaCD + '\'' +
                ", soBaiHat=" + soBaiHat +
                ", giaThanh=" + giaThanh +
                '}';
    }
}


