package menu;

import manager.Manager;

import java.util.Scanner;

public class MenuManager {
    Manager manager = new Manager();
    Scanner scanner = new Scanner(System.in);
    public void Menu() {
        do {
            try {
                System.out.println("---Chương Trình Quản Lý Sinh Viên---");
                System.out.println("1. Xem danh sách sinh viên");
                System.out.println("2. Thêm mới ");
                System.out.println("3.Cập nhật");
                System.out.println("4.Xóa");
                System.out.println("5.Sắp xếp");
                System.out.println("6.Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8.Thoát");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        manager.show();
                        break;
                    case 2:
                        manager.Create();
                        break;
                    case 3:
                        manager.update();
                        break;
                    case 4:
                        manager.delete();
                        break;
                    case 5:
                        manager.sort();
                        break;
                    case 6:
                        manager.doctufile();
                        break;
                    case 7:
                        manager.ghivaofile();
                        break;
                    case 8:
                        return;
                }
            } catch (Exception e) {

            }

        }while (true);
    }
}
