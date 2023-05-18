
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
public class StudentManagement {
    
private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        int choice;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Lấy danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Xóa sinh viên theo mã");
            System.out.println("4. Sửa thông tin sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo mã");
            System.out.println("6. Tìm kiếm sinh viên theo tên");
            System.out.println("7. Sắp xếp danh sách theo mã sinh viên tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    sortByIdAscending();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private void displayStudents() {
        System.out.println("===== DANH SÁCH SINH VIÊN =====");
        for (Student student : students) {
            System.out.println(student);
        }
    }

private void addStudent() {
    System.out.println("===== THÊM SINH VIÊN MỚI =====");
    System.out.print("Nhập mã sinh viên: ");
    String id = scanner.nextLine();
    System.out.print("Nhập họ tên sinh viên: ");
    String name = scanner.nextLine();
    System.out.print("Nhập năm sinh: ");
    int birthYear = scanner.nextInt();
    scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

    // Kiểm tra xem sinh viên có trùng mã không
    for (Student student : students) {
        if (student.getId().equals(id)) {
            System.out.println("Mã sinh viên đã tồn tại!");
            return;
        }
    }

    Student newStudent = new Student(id, name, birthYear);
    students.add(newStudent);
    System.out.println("Thêm sinh viên thành công!");
}


    private void removeStudent() {
        System.out.println("===== XÓA SINH VIÊN =====");
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();

        // Tìm sinh viên theo mã và xóa
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Xóa sinh viên thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã " + id);
    }

    private void editStudent() {
        System.out.println("===== SỬA THÔNG TIN SINH VIÊN =====");
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String id = scanner.nextLine();

        // Tìm sinh viên theo mã và sửa thông tin
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Nhập họ tên mới: ");
                String name = scanner.nextLine();
                System.out.print("Nhập năm sinh mới: ");
                int birthYear = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

                student.setName(name);
                student.setBirthYear(birthYear);
                System.out.println("Sửa thông tin sinh viên thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã " + id);
    }

    private void searchById() {
        System.out.println("===== TÌM KIẾM SINH VIÊN THEO MÃ =====");
        System.out.print("Nhập mã sinh viên cần tìm: ");
        String id = scanner.nextLine();

        // Tìm sinh viên theo mã
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã " + id);
    }

    private void searchByName() {
        System.out.println("===== TÌM KIẾM SINH VIÊN THEO TÊN =====");
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();

        // Tìm sinh viên theo tên
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với tên " + name);
        }
    }

    private void sortByIdAscending() {
        System.out.println("===== SẮP XẾP DANH SÁCH SINH VIÊN THEO MÃ TĂNG DẦN =====");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });

        displayStudents();
    }


}