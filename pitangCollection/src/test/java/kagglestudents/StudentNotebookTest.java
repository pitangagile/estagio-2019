package kagglestudents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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

    @After
    public void limpaLista() {
        System.out.println("Finalizando mais um teste");
        students = new ArrayList<StudentVO>();

    }

    private StudentVO getStudentVO() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(1);
        studentVO.setCgpa(new BigDecimal(352.00));
        studentVO.setLor(new BigDecimal(352.00));
        studentVO.setChance(new BigDecimal("25.12"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(256.88));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);
        return studentVO;
    }

    @Test(expected = NoSuchElementException.class)
    public void semUsuarioCarregados() {

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent1).load();
        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        studentNotebook1.isAnApprovedUser(1);
    }

    @Test
    public void usuarioAprovadoComIdExistente() {

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());

        studentVOList1.add(studentVO1);

        when(extractStudent1.load()).thenReturn(studentVOList1);
        when(studentVO1.isApproved()).thenReturn(true);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        assertTrue(studentNotebook1.isAnApprovedUser(1));
    }

    @Test
    public void usuarioNaoAprovadoComIdExistente() {

        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        Mockito.doReturn(false).when(studentVO1).isApproved();
        studentVOList1.add(studentVO1);

        when(studentVOList1.get(Mockito.anyInt()).isApproved()).thenReturn(false);
        //Mockito.doReturn(false).when(studentVOList1.get(Mockito.anyInt())).isApproved();  //PQ ESSE DAQUI DA ERRO, COMPARADO COM O DE CIMA?
        //Mockito.when(studentVOList1.get(Mockito.anyInt())).thenReturn(studentVO1); //ESSE CÓDIGO QUE TAVA DANDO PAU

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertFalse(studentNotebook1.isAnApprovedUser(1));

        //VERSÃO DE LUAN

//       ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
//        StudentVO student = Mockito.spy(getStudentVO());
//
//        //We'd like not approved
//        Mockito.doReturn(false).when(student).isApproved();
//
//        //Add the mock to list of mock
//        studentsList.add(student);
//
//        // I want my mock be returned
//        Mockito.when(studentsList.get(Mockito.anyInt())).thenReturn(student);
//
//
//        // Mock all other to setup
//        ExtractStudent extractStudent = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(studentsList).when(extractStudent).load();
//
//        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);
//
//        // Must me False
//        Boolean aprovado = studentNotebook.isAnApprovedUser(1);
//
//        assertFalse(aprovado);
//
//        Mockito.verify(studentsList, new Times(1)).size();

    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioInexistente() {

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());

        studentVOList1.add(studentVO1);

        when(extractStudent1.load()).thenReturn(studentVOList1);
        // when(studentVO1.getId()).thenReturn(999);
        when(studentVOList1.get(Mockito.anyInt()).getId()).thenReturn(999);
        // Mockito.when(studentVOList1.get(Mockito.anyInt()).getId().equals(Mockito.anyInt())).thenReturn(false);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        studentNotebook1.isAnApprovedUser(11);
    }

    @Test
    public void isAnApprovedCgpa() {

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());

        studentVOList1.add(studentVO1);
        Mockito.doReturn(true).when(studentVO1).isApprovedCgpa();

        when(studentVOList1.get(Mockito.anyInt()).isApprovedCgpa()).thenReturn(true);
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        assertTrue(studentNotebook1.isAnApprovedCgpa(new BigDecimal(352.00)));

    }

    @Test
    public void isNotAnApprovedCgpa() {
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        Mockito.doReturn(false).when(studentVO1).isApprovedCgpa();
        studentVOList1.add(studentVO1);

        when(studentVOList1.get(Mockito.anyInt()).isApprovedCgpa()).thenReturn(false);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertFalse(studentNotebook1.isAnApprovedCgpa(new BigDecimal(352.00)));

    }

    @Test
    public void isAnApprovedLor() {
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());

        studentVOList1.add(studentVO1);
        Mockito.doReturn(true).when(studentVO1).isApprovedLor();

        when(studentVOList1.get(Mockito.anyInt()).isApprovedLor()).thenReturn(true);
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        assertTrue(studentNotebook1.isAnApprovedLor(new BigDecimal(352.00)));
    }

    @Test
    public void isNotAnApprovedLor() {
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        Mockito.doReturn(false).when(studentVO1).isApprovedLor();
        studentVOList1.add(studentVO1);

        when(studentVOList1.get(Mockito.anyInt()).isApprovedLor()).thenReturn(false);

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertFalse(studentNotebook1.isAnApprovedLor(new BigDecimal(352.00)));
    }

    @Test
    public void sopPercentage() {
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(getStudentVO());
        StudentVO studentVO3 = Mockito.spy(getStudentVO());
        StudentVO studentVO4 = Mockito.spy(getStudentVO());
        studentVOList1.add(studentVO1);
        studentVOList1.add(studentVO2);
        studentVOList1.add(studentVO3);
        studentVOList1.add(studentVO4);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();
        Mockito.doReturn(true).when(studentVO3).isApproved();
        Mockito.doReturn(false).when(studentVO4).isApproved();

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertEquals(75, studentNotebook1.sopPercentage(0, new BigDecimal(400.00)), 0);
    }

    @Test
    public void lorPercentage() {
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(getStudentVO());
        StudentVO studentVO3 = Mockito.spy(getStudentVO());
        StudentVO studentVO4 = Mockito.spy(getStudentVO());
        studentVOList1.add(studentVO1);
        studentVOList1.add(studentVO2);
        studentVOList1.add(studentVO3);
        studentVOList1.add(studentVO4);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();
        Mockito.doReturn(true).when(studentVO3).isApproved();
        Mockito.doReturn(false).when(studentVO4).isApproved();

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertEquals(75, studentNotebook1.lorPercentage(0, new BigDecimal(400.00)), 0);
    }

    @Test
    public void cgpaPercentage() {
        List<StudentVO> studentVOList1 = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO studentVO1 = Mockito.spy(getStudentVO());
        StudentVO studentVO2 = Mockito.spy(getStudentVO());
        StudentVO studentVO3 = Mockito.spy(getStudentVO());
        StudentVO studentVO4 = Mockito.spy(getStudentVO());
        studentVOList1.add(studentVO1);
        studentVOList1.add(studentVO2);
        studentVOList1.add(studentVO3);
        studentVOList1.add(studentVO4);

        Mockito.doReturn(true).when(studentVO1).isApproved();
        Mockito.doReturn(true).when(studentVO2).isApproved();
        Mockito.doReturn(true).when(studentVO3).isApproved();
        Mockito.doReturn(false).when(studentVO4).isApproved();

        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        when(extractStudent1.load()).thenReturn(studentVOList1);

        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        assertEquals(75, studentNotebook1.cgpaPercentage(0, new BigDecimal(400.00)), 0);
    }
}