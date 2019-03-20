import org.mockito.internal.stubbing.answers.ThrowsException;

import java.util.ArrayList;
import java.util.List;

public class StudentsDB {

    private List<Student> list;

    public StudentsDB() {
        this.list = new ArrayList<Student>();
    }

    public void load(Student student) {
        //Student student = new Student(1,	337,	118,	4,	4.5f,	4.5f,	9.65f,	true,	0.92f);
        this.list.add(student);
    }

    public boolean approved(int serialNum) {

        for (Student student: list) {
            if (student.getSerialNum() == serialNum) {
                return student.wasApproved();
            }
        }
        return false;
    }

    public boolean approved(float lor, float cgpa) {
        for (Student student: list) {
            if (student.getCGPA() == cgpa && student.getLOR() == lor) {
                return student.wasApproved();
            }
        }
        return false;
    }

    public float percentApprovedBySOAP(float soap, char operator) throws Exception {
        float approved = 0f;
        float total = 0f;
        if (list.isEmpty()) {
            throw new Exception("List it's empty");
        }
        switch (operator){
            case '=':
                for (Student student:list) {
                    if (student.getSOP() == soap){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '>':
                for (Student student:list) {
                    if (student.getSOP() > soap){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '<':
                for (Student student:list) {
                    if (student.getSOP() < soap){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            default:
                throw new Exception("invalid operator");
        }
        return (float) (approved/total * 100);

    }

    public float percentApprovedByCGPA(float cgpa, char operator) throws Exception {
        float approved = 0;
        float total = 0;
        if (list.isEmpty()) {
            throw new Exception("List it's empty");
        }
        switch (operator){
            case '=':
                for (Student student:list) {
                    if (student.getCGPA() == cgpa){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '>':
                for (Student student:list) {
                    if (student.getCGPA() > cgpa){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '<':
                for (Student student:list) {
                    if (student.getCGPA() < cgpa){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            default:
                throw new Exception("invalid operator");
        }
        return (float) (approved/total * 100);

    }

    public float percentApprovedByLOR(float lor, char operator) throws Exception {
        float approved = 0;
        float total = 0;
        if (list.isEmpty()) {
            throw new Exception("List it's empty");
        }
        switch (operator){
            case '=':
                for (Student student:list) {
                    if (student.getLOR() == lor){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '>':
                for (Student student:list) {
                    if (student.getLOR() > lor){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            case '<':
                for (Student student:list) {
                    if (student.getLOR() < lor){
                        total++;
                        if (student.wasApproved()){
                            approved++;
                        }
                    }
                }
                break;
            default:
                throw new Exception("invalid operator");
        }
        return (float) ((approved/total) * 100);

    }
}
