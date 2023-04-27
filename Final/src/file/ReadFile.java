package file;

import student.Student;
import student.StudentManager;

import java.io.*;
import java.util.Arrays;

public class ReadFile {
    private final String FILENAME = "students.csv";
    public void readFile() {
        try {
            File file = new File(FILENAME);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String headerLine = reader.readLine();
            String currentLine;
            //empty student list
            StudentManager.getInstance().getStudentList().clear();
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
                String data[] = currentLine.split(",");
//                System.out.println(Arrays.toString(data));
                Student student = new Student(data[1],data[2],Integer.parseInt(data[3]),Boolean.parseBoolean(data[4]),data[5],Double.parseDouble(data[6]));
                StudentManager.getInstance().addStudent(student);
                StudentManager.getInstance().display();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
