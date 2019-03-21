
import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;




import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebookTest {

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

    private StudentNotebook getStudentNotebook(StudentVO studentVO){
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        studentsList.add(studentVO);
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(studentVO);
        // Mock all other to setup
        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent).load();
        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);
        return new StudentNotebook(extractStudent);

    }

    @After
    public void limpaLista() {
        System.out.println("Finalizando mais um teste");
        students = new ArrayList<StudentVO>();

    }


    @Test(expected = NoSuchElementException.class)
    public void semUsuarioCarregados() {
        ArrayList<StudentVO> studentsVOS = Mockito.spy(new ArrayList<StudentVO>());
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsVOS).when(extractStudent1).load();
        StudentNotebook notebook1 = new StudentNotebook(extractStudent1);
        notebook1.isAnApprovedUser(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistente() {
        ArrayList<StudentVO> studentsVOS = Mockito.spy(new ArrayList<StudentVO>());
        studentsVOS.add(getStudentVO());
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsVOS).when(extractStudent1).load();
        StudentNotebook notebook1 = new StudentNotebook(extractStudent1);
        notebook1.isAnApprovedUser(3);

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

        //We'd like approved
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
        Assert.assertTrue(studentNotebook.isAnApprovedUser(1));

        Mockito.verify(studentsList, new Times(1)).size();

    }


    @Test
    public void porcentagemAprovadoCGPAIgual(){

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setCgpa(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByCGPA(0.6, '=') == 1);
    }
    @Test
    public void porcentagemAprovadoCGPAMenor() {

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setCgpa(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByCGPA(0.7, '<') == 1);
    }

    @Test
    public void porcentagemAprovadoCGPAMaior() {
        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setCgpa(new BigDecimal(0.8));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByCGPA(0.6, '>') == 1);
    }
    @Test
    public void porcentagemAprovadoSOPIgual(){

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setSop(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAProvedBySOP(0.6, '=') == 1);
    }
    @Test
    public void porcentagemAprovadoSOPMenor() {

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setSop(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAProvedBySOP(0.7, '<') == 1);
    }

    @Test
    public void porcentagemAprovadoSOPMaior() {
        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setSop(new BigDecimal(0.8));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAProvedBySOP(0.6, '>') == 1);
    }

    @Test
    public void porcentagemAprovadoLORIgual(){

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setLor(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByLOR(0.6, '=') == 1);
    }
    @Test
    public void porcentagemAprovadoLORMenor() {

        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setLor(new BigDecimal(0.6));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByLOR(0.7, '<') == 1);
    }

    @Test
    public void porcentagemAprovadoLORMaior() {
        StudentVO student = Mockito.spy(getStudentVO());
        Mockito.when(student.isApproved()).thenReturn(true);
        student.setLor(new BigDecimal(0.8));
        StudentNotebook notebook1 = this.getStudentNotebook(student);
        Assert.assertTrue(notebook1.studentsAprovedByLOR(0.6, '>') == 1);
    }


}
