import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author YXH_XianYu
 * Created On 2022-05-17
 */
public class StudentSystem {
    private ArrayList<Student> students;

    public static void main(String[] args) {
        StudentSystem ss=new StudentSystem();
        ss.readFromFileToArraylist();
        ss.display();
        System.out.println(ss.calculateScoreAverage());
        ss.sortArray();
        ss.display();
        ss.writeStudentFromFile();
    }

    // 显示所有学生的名字和对应分数
    public void display() {
        for(Student i: students)
            System.out.println(i.getName() + ": " + i.getGrade());
    }

    // 计算所有学生的平均分
    public float calculateScoreAverage() {
        float sum = 0;
        for(Student i: students) {
            sum += i.getGrade();
        }
        return sum / students.size();
    }

    public void sortArray() {
        Collections.sort(students, new GradeComp());
    }

    public void readFromFileToArraylist() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("StudentInfo.txt")));
            students = new ArrayList<>();
            String str;
            while((str = input.readLine()) != null) {
                String[] strings = str.split("_");
                students.add(new Student(strings[0], Integer.parseInt(strings[1])));
            }
            input.close();
        } catch (IOException e) {System.out.println("Exception: " + e);}
    }

    // 输出数据至"StudentInfo1.txt"
    public void writeStudentFromFile() {
        sortArray();
        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("StudentInfo1.txt")));
            for(Student i: students)
                output.write(i.getName() + "\t" + i.getGrade() + "\n");
            output.flush();
            output.close();
        } catch (IOException e) {System.out.println("Exception: " + e);}
    }
}
