package student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;
    private static StudentManager instance;

    private StudentManager() {
        studentList = new ArrayList<>();
        //Add some students
        studentList.add(new Student("SV1","Sơn", 30, false,"HàNam",8));
        studentList.add(new Student("SV2","Nam", 33, false,"HàNội",8));
        studentList.add(new Student("SV3","Hùng", 25, false,"HàTây",8));
        studentList.add(new Student("SV4","Nam", 26, false,"SócSơn",8));
        studentList.add(new Student("SV5","Chung", 28, false,"NamĐịnh",8));
        studentList.add(new Student("SV6","Hiếu", 23, false,"HàNam",8));
        studentList.add(new Student("SV7","Công", 27, false,"NinhBình",8));
    }
    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    public Student search(String id) {
        Student student = studentList.stream().filter(e->e.getId() ==id).findFirst().orElse(null);
        return student;
    }
    public int searchAndReturnIndex(String id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i ++) {
            if (studentList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
