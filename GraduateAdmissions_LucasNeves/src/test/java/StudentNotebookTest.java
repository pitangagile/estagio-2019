import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.verification.Times;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentNotebookTest {

    @Mock
    public List<StudentVO> students;

    public StudentNotebook studentNotebook;

    public ExtractStudent extractStudent;

    @Before
    public void criaParametroListasStudent() {
        students = new ArrayList<StudentVO>();
        StudentVO studentVO = getStudentVO();

        this.students.add(studentVO);

        extractStudent = new ExtractStudent();
        studentNotebook = new StudentNotebook(extractStudent);

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
    public void usuarioNaoAprovadoComIdExistente() {

        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());

        //We'd like not approved
        Mockito.doReturn(false).when(student).isApproved();

        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        // Must me False
        Boolean aprovado = studentNotebook.isAnApprovedUser(1);

        Assert.assertFalse(aprovado);

        Mockito.verify(studentsList, new Times(1)).size();

    }

    @Test
    public void usuarioAprovadoComIdExistente() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());

        //We'd like not approved
        Mockito.doReturn(true).when(student).isApproved();

        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        // Must me False
        Boolean aprovado = studentNotebook.isAnApprovedUser(1);

        Assert.assertTrue(aprovado);

        Mockito.verify(studentsList, new Times(1)).size();

    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistente() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());

        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        studentNotebook.isAnApprovedUser(10);

    }

    @Test(expected = NoSuchElementException.class)
    public void semUsuarioCarregados() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());

        studentsList.get(0);

        //studentNotebook.isAnApprovedUser(10);

    }

    @Test
    public void isAnApprovedUserByCgpaTest(){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());
        student.setCgpa(new BigDecimal(7.0));
        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        Boolean aprovado = studentNotebook.isAnApprovedUserByCgpa(new BigDecimal(7.0),1);

        Assert.assertTrue(aprovado);

        //Mockito.verify(studentsList, new Times(1));
    }
    @Test
    public void isAnReprovedUserByCgpaTest(){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());
        student.setCgpa(new BigDecimal(7.0));
        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        Boolean reprovado = studentNotebook.isAnApprovedUserByCgpa(new BigDecimal(9.0),1);

        Assert.assertFalse(reprovado);

        //Mockito.verify(studentsList, new Times(1));
    }
    @Test
    public void isAnApprovedUserByLorTest(){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());
        student.setLor(new BigDecimal(7.0));
        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        Boolean aprovado = studentNotebook.isAnApprovedUserByLor(new BigDecimal(7.0),1);

        Assert.assertTrue(aprovado);

        //Mockito.verify(studentsList, new Times(1));
    }
    @Test
    public void isAnReprovedUserByLorTest(){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(getStudentVO());
        student.setLor(new BigDecimal(7.0));
        //Add the mock to list of mock
        studentsList.add(student);

        // I want my mock be returned
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);


        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        Boolean reprovado = studentNotebook.isAnApprovedUserByLor(new BigDecimal(9.0),1);

        Assert.assertFalse(reprovado);

        //Mockito.verify(studentsList, new Times(1));
    }

    @Test
    public void procentegeOfApprovedByCgpaTest(){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student1 = new StudentVO();
        student1.setCgpa(new BigDecimal(8.0));
        StudentVO student2 = new StudentVO();
        student2.setCgpa(new BigDecimal(5.0));
        StudentVO student3 = new StudentVO();
        student3.setCgpa(new BigDecimal(7.0));
        StudentVO student4 = new StudentVO();
        student4.setCgpa(new BigDecimal(9.0));
        //Add the mock to list of mock
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);

        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

        Assert.assertEquals(0.5,studentNotebook.procentegeOfApprovedByCgpa(new BigDecimal(6.0), '>'),0.0001);
        //Mockito.verify(studentsList, new Times(1));
    }
}
