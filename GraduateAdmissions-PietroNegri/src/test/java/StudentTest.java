
import student.*;
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

public class StudentTest {


    public List<StudentVO> students;
    public StudentNotebook studentNotebook;
    public ExtractStudent extractStudent;


    @Before
    public void Start() {
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
        studentVO.setLor(new BigDecimal(120.00));
        studentVO.setChance(new BigDecimal("25.12"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(256.88));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);
        return studentVO;
    }


    @After
    public void End() {
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


        // Must be False
        Boolean aprovado = studentNotebook.isAnApprovedUser(1);

        Assert.assertFalse(aprovado);

        Mockito.verify(studentsList, new Times(1)).size();


    }

    @Test
    public void usuarioAprovadoComIdExistente() {

        Assert.assertTrue(studentNotebook.isAnApprovedUser(1));

    }


    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistente() {
        studentNotebook.isAnApprovedUser(10);

    }

    @Test(expected = NoSuchElementException.class)
    public void semUsuarioCarregados() {
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent1).load();

        StudentNotebook studentNotebook = new StudentNotebook(extractStudent1);

        studentNotebook.isAnApprovedUser(0);

    }

    @Test
    public void ReprovadoCgpa() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO = Mockito.spy(getStudentVO());

        //not approved
        Mockito.doReturn(false).when(studentVO).isApproved();

        //add mock to list
        studentsList.add(studentVO);

        //return my created mock when I call list
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(studentVO);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertFalse(studentNotebook1.isAnApprovedUserByCgpa(new BigDecimal(352.00)));
    }

    @Test
    public void AprovadoCgpa() {

        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO = Mockito.spy(getStudentVO());

        //not approved
        Mockito.doReturn(true).when(studentVO).isApproved();

        //add mock to list
        studentsList.add(studentVO);

        //return my created mock when I call list
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(studentVO);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertTrue(studentNotebook1.isAnApprovedUserByCgpa(new BigDecimal(352.00)));
    }

    @Test
    public void ReprovadoLor() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO = Mockito.spy(getStudentVO());

        //not approved
        Mockito.doReturn(false).when(studentVO).isApproved();

        //add mock to list
        studentsList.add(studentVO);

        //return my created mock when I call list
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(studentVO);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertFalse(studentNotebook1.isAnApprovedUserByLor(new BigDecimal(120.00)));
    }

    @Test
    public void AprovadoLor() {
        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO = Mockito.spy(getStudentVO());

        //not approved
        Mockito.doReturn(true).when(studentVO).isApproved();

        //add mock to list
        studentsList.add(studentVO);

        //return my created mock when I call list
        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(studentVO);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertTrue(studentNotebook1.isAnApprovedUserByLor(new BigDecimal(120.00)));
    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistenteCgpa() {
        studentNotebook.isAnApprovedUserByCgpa(new BigDecimal(14.00));

    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistenteLor() {
        studentNotebook.isAnApprovedUserByLor(new BigDecimal(14.00));

    }

    @Test
    public void percentagemAprovadoSop() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(2);
        studentVO.setCgpa(new BigDecimal(40.00));
        studentVO.setLor(new BigDecimal(15.00));
        studentVO.setChance(new BigDecimal("70.15"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(112.80));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);

        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(studentVO);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();

        studentsList.add(studentVO1);
        studentsList.add(studentVO2);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertEquals(50.0, studentNotebook1.percentApprovedBySop(new BigDecimal(112.80), '='), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedBySop(new BigDecimal(200.00), '>'), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedBySop(new BigDecimal(200.00), '<'), 0);

    }

    @Test
    public void percentagemAprovadoLor() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(2);
        studentVO.setCgpa(new BigDecimal(40.00));
        studentVO.setLor(new BigDecimal(15.00));
        studentVO.setChance(new BigDecimal("70.15"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(112.80));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);

        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(studentVO);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();

        studentsList.add(studentVO1);
        studentsList.add(studentVO2);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByLor(new BigDecimal(15.00), '='), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByLor(new BigDecimal(60.00), '>'), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByLor(new BigDecimal(20.00), '<'), 0);

    }

    @Test
    public void percentagemAprovadoCgpa() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(2);
        studentVO.setCgpa(new BigDecimal(40.00));
        studentVO.setLor(new BigDecimal(15.00));
        studentVO.setChance(new BigDecimal("70.15"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(112.80));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);

        ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(studentVO);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();

        studentsList.add(studentVO1);
        studentsList.add(studentVO2);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(studentsList).when(extractStudent1).load();

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByCgpa(new BigDecimal(40.00), '='), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByCgpa(new BigDecimal(70.00), '>'), 0);
        Assert.assertEquals(50.0, studentNotebook1.percentApprovedByCgpa(new BigDecimal(50.00), '<'), 0);

    }

    @Test(expected = NullPointerException.class)
    public void PercentagemAprovadoCgpaOperandoErrado() {

        studentNotebook.percentApprovedByCgpa(new BigDecimal(30.00), 'k');
    }

    @Test(expected = NullPointerException.class)
    public void PercentagemAprovadoSopOperandoErrado() {

        studentNotebook.percentApprovedBySop(new BigDecimal(30.00), 'k');
    }

    @Test(expected = NullPointerException.class)
    public void PercentagemAprovadoLorOperandoErrado() {

        studentNotebook.percentApprovedByLor(new BigDecimal(30.00), 'k');
    }


}