import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import java.math.BigDecimal;
import java.util.ArrayList;

public class StudentTest {


    ArrayList<StudentVO> students;
    StudentVO student;

    @Before
    public void criaParametroListasStudent() {
        students = new ArrayList<StudentVO>();
        StudentVO studentVO = getStudentVO();
        this.students.add(studentVO);
    }

    private StudentVO getStudentVO() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(1);
        studentVO.setCgpa(new BigDecimal(352.00));
        studentVO.setChance(new BigDecimal("25.12"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(256.88));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);
        return studentVO;
    }

    @After
    public void limpaLista() {
        System.out.println("Finalizando mais um teste");
        students = new ArrayList<StudentVO>();

    }

    @Test
    public void isApproved(){
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        students.add(getStudentVO());
        Mockito.doReturn(true).when(students.get(Mockito.anyInt())).isApproved();

        Boolean aprovado = getStudentVO().isApproved();
        Assert.assertTrue(aprovado);

    }

    @Test
    public void isApprovedCPGA(){
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        students.add(getStudentVO());
        Mockito.doReturn(true).when(students.get(Mockito.anyInt())).isApprovedCPGA();

        Boolean aprovado = getStudentVO().isApprovedCPGA();
        Assert.assertTrue(aprovado);

    }

    @Test
    public void isApprovedLOR(){
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        students.add(getStudentVO());
        Mockito.doReturn(true).when(students.get(Mockito.anyInt())).isApprovedLOR();

        Boolean aprovado = getStudentVO().isApprovedLOR();
        Assert.assertTrue(aprovado);

    }

    @Test
    public void porcentagemSOP(){
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        BigDecimal valor = new BigDecimal(3.0);
        int op = 3;
        student = Mockito.spy(new StudentVO());
        //Colocando alguns estudantes na lista pra que possa ser testada a porcentagem
        students.add(new StudentVO(1,337,118,544,BigDecimal.valueOf(4.5),BigDecimal.valueOf(3.2),BigDecimal.valueOf(9.65), (byte) 1,BigDecimal.valueOf(0.93)));
        students.add(new StudentVO(2,315,107,543,BigDecimal.valueOf(3.5),BigDecimal.valueOf(4.9),BigDecimal.valueOf(8.22), (byte) 1,BigDecimal.valueOf(0.77)));
        students.add(new StudentVO(3,307,120,324,BigDecimal.valueOf(3.2),BigDecimal.valueOf(2.2),BigDecimal.valueOf(7.60), (byte) 0,BigDecimal.valueOf(0.86)));
        students.add(new StudentVO(4,377,102,444,BigDecimal.valueOf(1.8),BigDecimal.valueOf(4.3),BigDecimal.valueOf(6.15), (byte) 1,BigDecimal.valueOf(0.74)));
        students.add(new StudentVO(5,298,106,453,BigDecimal.valueOf(2.0),BigDecimal.valueOf(3.5),BigDecimal.valueOf(4.65), (byte) 0,BigDecimal.valueOf(0.32)));
        students.add(new StudentVO(6,265,115,421,BigDecimal.valueOf(2.5),BigDecimal.valueOf(2.5),BigDecimal.valueOf(9.34), (byte) 1,BigDecimal.valueOf(0.54)));


        Assert.assertEquals(BigDecimal.valueOf(0.75),student.porcentagemSOP(students,valor,op));

    }

    @Test
    public void porcentagemLOR(){
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        BigDecimal valor = new BigDecimal(3.0);
        int op = 3;
        student = Mockito.spy(new StudentVO());
        //Colocando alguns estudantes na lista pra que possa ser testada a porcentagem
        students.add(new StudentVO(1,337,118,544,BigDecimal.valueOf(4.5),BigDecimal.valueOf(3.2),BigDecimal.valueOf(9.65), (byte) 1,BigDecimal.valueOf(0.93)));
        students.add(new StudentVO(2,315,107,543,BigDecimal.valueOf(3.5),BigDecimal.valueOf(4.9),BigDecimal.valueOf(8.22), (byte) 1,BigDecimal.valueOf(0.77)));
        students.add(new StudentVO(3,307,120,324,BigDecimal.valueOf(3.2),BigDecimal.valueOf(2.2),BigDecimal.valueOf(7.60), (byte) 0,BigDecimal.valueOf(0.86)));
        students.add(new StudentVO(4,377,102,444,BigDecimal.valueOf(1.8),BigDecimal.valueOf(4.3),BigDecimal.valueOf(6.15), (byte) 1,BigDecimal.valueOf(0.74)));
        students.add(new StudentVO(5,298,106,453,BigDecimal.valueOf(2.0),BigDecimal.valueOf(1.5),BigDecimal.valueOf(4.65), (byte) 0,BigDecimal.valueOf(0.32)));
        students.add(new StudentVO(6,265,115,421,BigDecimal.valueOf(2.5),BigDecimal.valueOf(2.5),BigDecimal.valueOf(9.34), (byte) 1,BigDecimal.valueOf(0.54)));


        Assert.assertEquals(BigDecimal.valueOf(0.75),student.porcentagemLOR(students,valor,op));

    }

    @Test
    public void porcentagemCGPA(){

        this.students = Mockito.spy(new ArrayList<StudentVO>());
        BigDecimal valor = new BigDecimal(3.0);
        int op = 3;
        student = Mockito.spy(new StudentVO());
        //Colocando alguns estudantes na lista pra que possa ser testada a porcentagem
        students.add(new StudentVO(1,337,118,544,BigDecimal.valueOf(4.5),BigDecimal.valueOf(3.2),BigDecimal.valueOf(9.65), (byte) 1,BigDecimal.valueOf(0.93)));
        students.add(new StudentVO(2,315,107,543,BigDecimal.valueOf(3.5),BigDecimal.valueOf(4.9),BigDecimal.valueOf(8.22), (byte) 1,BigDecimal.valueOf(0.77)));
        students.add(new StudentVO(3,307,120,324,BigDecimal.valueOf(3.2),BigDecimal.valueOf(2.2),BigDecimal.valueOf(7.60), (byte) 0,BigDecimal.valueOf(0.86)));
        students.add(new StudentVO(4,377,102,444,BigDecimal.valueOf(1.8),BigDecimal.valueOf(4.3),BigDecimal.valueOf(1.15), (byte) 1,BigDecimal.valueOf(0.74)));
        students.add(new StudentVO(5,298,106,453,BigDecimal.valueOf(2.0),BigDecimal.valueOf(3.5),BigDecimal.valueOf(4.65), (byte) 0,BigDecimal.valueOf(0.32)));
        students.add(new StudentVO(6,265,115,421,BigDecimal.valueOf(2.5),BigDecimal.valueOf(2.5),BigDecimal.valueOf(9.34), (byte) 1,BigDecimal.valueOf(0.54)));


        Assert.assertEquals(BigDecimal.valueOf(0.75),student.porcentagemCGPA(students,valor,op));

    }

}
