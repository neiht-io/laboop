
import java.time.LocalDate;

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
        Product product1 = new Product("Nước tương", "sp4", 8);
        Product product2 = new Product("Gạo", "sp1", 18);
        Product product3 = new Product("Đường", "sp3", 10);
        Product product4 = new Product("Gạo", "sp1", 18);

        Order order = new Order(1, LocalDate.now());
        order.addLineItem(product1, 10);
        order.addLineItem(product2, 5);
        order.addLineItem(product3, 1);
        order.addLineItem(product4, 1);

        System.out.println(order.toString());
    }
    }

