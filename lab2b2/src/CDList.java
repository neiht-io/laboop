/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
import java.util.Arrays;

public class CDList {
    private CD[] cds;
    private int size;
    private int capacity;

    public CDList(int capacity) {
        this.cds = new CD[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean addCD(CD cd) {
        if (cd == null || size >= capacity || containsCD(cd)) {
            return false;
        }
        cds[size++] = cd;
        return true;
    }

    private boolean containsCD(CD cd) {
        for (int i = 0; i < size; i++) {
            if (cd.getMaCD() == cds[i].getMaCD()) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += cds[i].getGiaThanh();
        }
        return totalPrice;
    }

    public void sortByPriceDesc() {
        Arrays.sort(cds, 0, size, (cd1, cd2) -> Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh()));
    }

    public void sortByTitleAsc() {
        Arrays.sort(cds, 0, size, (cd1, cd2) -> cd1.getTuaCD().compareTo(cd2.getTuaCD()));
    }

    public void displayAllCDs() {
        for (int i = 0; i < size; i++) {
            System.out.println(cds[i]);
        }
    }
}

