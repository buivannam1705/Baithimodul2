package manager;

import io.IO;
import model.Student;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);

    public static ArrayList<Student> getStudents() {
        return students;
    }


    public static void setStudents(ArrayList<Student> students) {
        Manager.students = students;
    }

    static ArrayList<Student> students = new ArrayList<>();
    public final String REGEX_STRING = "[ny]";

    public void  Create() {

        System.out.println("Nhập mã sinh viên: ");
        String code = scanner.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập giới tính sinh viên: ");
        String gender = scanner.nextLine();

        System.out.println("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        System.out.println("Nhập điểm TB sinh viên: ");
        double GPA;
        while (true) {
            try {
                GPA = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai định dạng!chọn lại");
            }
        }
        Student product = new Student(code, name, age, gender, address, GPA);
        students.add(product);
    }

    public void sort () {
        int choice = 3;
        System.out.println("1. Sắp xếp điểm trung bình tăng dần.");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần.");
        System.out.println("3. Thoát.");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choice > 3) System.out.println("Vui lòng nhập lại");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice > 3);
        switch (choice) {
            case 1:
                up();
                break;
            case 2:
                down();
                break;
            case 3:
                return;
        }

    }



    public void show() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
            
        }
    }

    public void add() {

    }


    public void update(){
        System.out.println("Nhập mã sinh viên muốn sửa ");
        String tk = scanner.nextLine();
        if (checktk(tk) == -1) {
            System.out.println("Mã không tồn tại ");
        } else {
            int index = checktk(tk);
            System.out.println("Bạn Muốn Sửa Gì");
            System.out.println("1. Sửa ID");
            System.out.println("2. Sửa tên");
            System.out.println("3.Sửa tuổi");
            System.out.println("4.Sửa giới Tính ");
            System.out.println("5.Sửa địa chỉ ");
            System.out.println("6. Sửa điểm trung bình");
            int choie = Integer.parseInt(scanner.nextLine());
            switch (choie) {
                case 1:
                    System.out.println("Nhập ID Muốn Thay Đổi ");
                    String newid = scanner.nextLine();
                    students.get(index).setCode(newid);
                    System.out.println("Thành Công ");

                    break;
                case 2:
                    System.out.println("Nhập Tên Muốn Thay Đổi ");
                    String name = scanner.nextLine();
                    students.get(index).setName(name);
                    System.out.println("Thành Công ");
                    break;
                case 3:
                    System.out.println("Nhập tuổi muốn sửa");
                    int age = Integer.parseInt(scanner.nextLine());
                    students.get(index).setAge(age);
                    break;
                case 4:
                    System.out.println("Nhập giới Tính Muốn Thay Đổi ");
                    String newgender = scanner.nextLine();
                    students.get(index).setGender(newgender);
                    System.out.println("Thành Công ");
                    break;
                case 5:
                    System.out.println("Nhập địa chỉ muốn thay đổi");
                    String address = scanner.nextLine();
                    students.get(index).setAddress(address);
                    System.out.println("Thành công");
                    break;
                case 6:
                    System.out.println("Nhập điểm trung bình muốn thay đổi");
                    Double diem = Double.parseDouble(scanner.nextLine());
                    students.get(index).setGPA(diem);
                    break;
                case 7:
                    return;

            }

        }

    }
    public int checktk(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(code)) {
                return i;
            }

        }
        return -1;
    }


    public void delete() {
        System.out.println("Nhập mã sinh viên bạn muốn xóa:  ");
        String code = scanner.nextLine();
        System.out.println("Bạn có chắc sẽ xóa sinh viên (yes:y hoặc no:n): ");
        String choice = check(REGEX_STRING);
        if (choice.equals("y")) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getCode().equalsIgnoreCase(code)) {
                    students.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        } else {
            System.out.println("Hủy bỏ xóa!");
        }

    }



    public String check(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Sai định dạng, nhập lại.");
        }
    }


    public void down() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGPA() < students.get(j).getGPA()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();
    }


    public void up() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGPA() > students.get(j).getGPA()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();
    }
    public void doctufile() {
        System.out.println("Đọc từ File sẽ mất dữ liệu hiện tại, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            students = IO.read();
            System.out.println("Đã đọc xong, chọn chức năng xem danh sách để kiểm tra.");
        }
    }


    public void ghivaofile() {
        System.out.println("Ghi vào File sẽ mất dữ liệu đang lưu, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            IO.write(students);
            System.out.println("Ghi file thành công, Chọn chức năng đọc file để kiểm tra.");
        }
    }
    public String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại.");
        }
    }
}
