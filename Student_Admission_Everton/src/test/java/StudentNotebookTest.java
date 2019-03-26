import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebookTest {
    StudentNotebook studentNotebook;
    ExtractStudent extractStudent;

    StudentVO studentVO, studentVO1, studentVO2, studentVO3;

    static BigDecimal NOVE = new BigDecimal(9.0);
    static BigDecimal QUATRO = new BigDecimal(4.0);
    static BigDecimal OITO = new BigDecimal(8.0);
    static BigDecimal SETEMEIO = new BigDecimal(7.5);
    static BigDecimal OITOMEIO = new BigDecimal(8.5);

    @Before
    public void setup() throws IOException {
        this.extractStudent = new ExtractStudent();
        this.studentNotebook = new StudentNotebook(this.extractStudent);
        this.studentVO = new StudentVO();
        this.studentVO1 = new StudentVO();
        this.studentVO2 = new StudentVO();
        this.studentVO3 = new StudentVO();
    }

    @Mock
    public List<StudentVO> mockedlist = new ArrayList<StudentVO>();


    @Test
    public  void isAnApprovedUserTest(){
        this.studentVO.setId(5);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertFalse(studentNotebook.isAnApprovedUser(5));  //list is empty

        mockedlist.add(studentVO);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertTrue(studentNotebook.isAnApprovedUser(5));  //in the list

        Assert.assertFalse(studentNotebook.isAnApprovedUser(0)); //not in the list

    }
    @Test
    public void isAnApprovedUserCgpaLorTest(){
        this.studentVO.setCgpa(NOVE);
        this.studentVO.setLor(QUATRO);

        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertFalse(studentNotebook.isAnApprovedUser(NOVE, QUATRO));  //list is empty

        mockedlist.add(studentVO);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertFalse(studentNotebook.isAnApprovedUser(NOVE,QUATRO)); //not in the list

        Assert.assertTrue(studentNotebook.isAnApprovedUser(QUATRO, NOVE)); //in the list

    }


    @Test
    public void approvedRateCgpaLesserThanTest(){
        studentVO.setCgpa(NOVE);
        studentVO1.setCgpa(OITO);
        studentVO2.setCgpa(OITOMEIO);
        studentVO3.setCgpa(SETEMEIO);

        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaLesserThan(OITO), 0.01);  //list is empty

        mockedlist.add(studentVO);
        mockedlist.add(studentVO1);
        mockedlist.add(studentVO2);
        mockedlist.add(studentVO3);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.25, studentNotebook.approvedRateCgpaLesserThan(OITO),0.01);

        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaLesserThan(SETEMEIO), 0.01);

        Assert.assertEquals(0.75, studentNotebook.approvedRateCgpaLesserThan(NOVE), 0.01);

        Assert.assertEquals(0.5, studentNotebook.approvedRateCgpaLesserThan(OITOMEIO), 0.01);

    }

    @Test
    public void approvedRateCgpaBiggerThanTest(){
        studentVO.setCgpa(NOVE);
        studentVO1.setCgpa(OITO);
        studentVO2.setCgpa(OITOMEIO);
        studentVO3.setCgpa(SETEMEIO);

        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaBiggerThan(OITO), 0.01);  //list is empty

        mockedlist.add(studentVO);
        mockedlist.add(studentVO1);
        mockedlist.add(studentVO2);
        mockedlist.add(studentVO3);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.5, studentNotebook.approvedRateCgpaBiggerThan(OITO),0.01);

        Assert.assertEquals(0.75, studentNotebook.approvedRateCgpaBiggerThan(SETEMEIO), 0.01);

        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaBiggerThan(NOVE), 0.01);

        Assert.assertEquals(0.25, studentNotebook.approvedRateCgpaBiggerThan(OITOMEIO), 0.01);

    }

    @Test
    public void approvedRateCgpaEqualToTest(){
        studentVO.setCgpa(OITO);
        studentVO1.setCgpa(OITO);
        studentVO2.setCgpa(OITO);
        studentVO3.setCgpa(SETEMEIO);

        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaEqualTo(OITO), 0.01);  //list is empty

        mockedlist.add(studentVO);
        mockedlist.add(studentVO1);
        mockedlist.add(studentVO2);
        mockedlist.add(studentVO3);
        Whitebox.setInternalState(studentNotebook, "studentNotebookList", mockedlist);
        Assert.assertEquals(0.75, studentNotebook.approvedRateCgpaEqualTo(OITO),0.01);

        Assert.assertEquals(0.25, studentNotebook.approvedRateCgpaEqualTo(SETEMEIO), 0.01);

        Assert.assertEquals(0.0, studentNotebook.approvedRateCgpaEqualTo(NOVE), 0.01);

    }






}
