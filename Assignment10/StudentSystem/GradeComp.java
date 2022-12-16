import java.util.Comparator;

/**
 * @author YXH_XianYu
 * Created On 2022-05-17
 */
public class GradeComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade() - o2.getGrade();
    }
}
