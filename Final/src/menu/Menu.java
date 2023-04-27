package menu;

import student.Student;
import student.StudentManager;

import java.util.Scanner;

public class Menu {
    public final String[] menus = {"Xem danh sách sinh viên", "Thêm mới", "Cập nhật", "Xóa", "Sắp xếp", "Đọc từ file","Ghi vào file", "Thoát"};
    public final String[] menusAdd = {"Mã sinh viên", "Họ tên", "Tuổi","Giới tính", "Địa chỉ", "Điểm trung bình"};
    public final String[] display5Student = {"Lựa chọn \"Thêm mới\"", "Hiển thị 5 sinh viên"};
    public final String[] menuSorting = {"Sắp xếp điểm trung bình tăng dần"}
    public void display(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            for (int index = 1; index <= menus.length; index++) {
                System.out.println(index+". "+menus[index-1]);
            }
            System.out.println("Chọn chức năng:");
            int choosen = scanner.nextInt();
            System.out.println(choosen);
            switch (choosen) {
                case 1 -> {
                    System.out.println("Mời lựa chọn:");
                    for (int index = 0; index < display5Student.length; index++) {
                        System.out.println(index+ ". "+display5Student[index]);
                    }
                    int select = scanner.nextInt();
                    if (select == 0) {
                        addOneStudent();
                    }else if (select == 1) {
                        displayFiveStudent();
                    }

                }
                case 2 -> {
                    Student student = addOneStudent();
                    if (student != null) {
                        StudentManager.getInstance().addStudent(student);
                    }
                }
                case 3 -> {//edit
                    editStudent();
                }
                case 4 -> {//delete
                    deleteStudent();
                }
                case 5 -> {//sorting

                }
                case 8 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Nhập sai, mời nhập lại:");
                }
            }
        }
    }

    public void displayFiveStudent(){
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < 5; index ++) {
            String txt = scanner.nextLine();
            System.out.println(StudentManager.getInstance().getStudentList().get(index));
        }
    }
    public Student addOneStudent() {
        Student newStudent = null;
        Scanner scanner = new Scanner(System.in);
        boolean notFinish = true;
        while (notFinish){
            try{
                System.out.println("Nhập mã sinh viên:");
                String id = scanner.next();
                System.out.println("Nhập họ tên:");
                String name = scanner.next();
                System.out.println("Nhập tuổi:");
                int age = scanner.nextInt();
                System.out.println("Nhập giới tính (1-Nam,0-Nữ):");
                int sexInt = scanner.nextInt();
                boolean sex = sexInt == 0 ? true : false;
                System.out.println("Nhập địa chỉ:");
                String address = scanner.next();
                System.out.println("Nhập điểm trung bình:");
                double score = scanner.nextDouble();
                newStudent = new Student(id,name,age,sex,address,score);
                notFinish = false;
            } catch (Exception e) {
                System.out.println("Nhập sai, mời nhập lại!");
            }

        }
        return newStudent;
    }

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sinh viên cần chỉnh sửa");
        String id = scanner.next();
        Student student = StudentManager.getInstance().search(id);
        if (student != null) {
            //edit
            Student editStudent = addOneStudent();
            student = editStudent;
        } else {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sinh viên cần chỉnh sửa");
        String id = scanner.next();
        int index = StudentManager.getInstance().searchAndReturnIndex(id);
        if (index != -1) {
            //remove student
            System.out.println("Are you sure(y/n)");
            String select = scanner.next();
            if (select.equals('y')) {
                StudentManager.getInstance().getStudentList().remove(index);
            } else {
                //return
            }

        }else {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }
}
