import kagglestudents.ExtractStudent;
import kagglestudents.StudentVO;
import kagglestudents.StudentNotebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.internal.verification.Times;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

public class StudentTeste {

    public StudentNotebook studentNotebook;
    public List<StudentVO> students;
    @Mock
    public ExtractStudent extractStudent;

    @Mock
    public Double[] valoresList;

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
        studentVO.setCgpa(new BigDecimal(9.65));
        studentVO.setChance(new BigDecimal("0.92"));
        studentVO.setGre(337);
        studentVO.setResearch(new Byte((byte) '1'));
        studentVO.setSop(new BigDecimal(4.5));
        studentVO.setToelf(118);
        studentVO.setUniversityRating(4);
        studentVO.setLor(new BigDecimal(4.5));

        return studentVO;
    }


    @After
    public void limpaLista() {
        System.out.println("Finalizando mais um teste");
        students = new ArrayList<StudentVO>();

    }

    @Test
    public void usuarioAprovadoComId(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(true).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isAnApprovedUser(1);
        assertTrue(aprovado);
    }

    @Test (expected = NoSuchElementException.class)
    public void usuarioNaoAprovadoComIdExistente(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(false).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isAnApprovedUser(4);
        assertFalse(aprovado);
    }

    @Test
    public void usuarioNaoExistente(){
        studentNotebook.isAnApprovedUser(4);
    }

    @Test (expected = NoSuchElementException.class)
    public void semUsuarioCarregado(){
        ExtractStudent extractStudent1 = spy(new ExtractStudent());
        Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent1).load();
        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);
        studentNotebook1.isAnApprovedUser(1);
    }

    @Test
    public void usuarioAprovadoCGPA(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(true).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isApprovedCGPA(new BigDecimal(352.00));
        assertTrue(aprovado);
    }

    @Test
    public void usuarioNaoAprovadoCGPA(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(false).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isApprovedCGPA(new BigDecimal(352.00));
        assertFalse(aprovado);
    }

    @Test
    public void usuarioAprovadoLOR(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(true).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isApprovedLOR(new BigDecimal(4.50));
       // assertTrue(aprovado);
    }

    @Test
    public void usuarioNaoAprovadoLOR(){
        students = spy(new ArrayList<StudentVO>());
        Mockito.doReturn(false).when(students).get(Mockito.anyInt());
        Boolean aprovado = studentNotebook.isApprovedLOR(new BigDecimal(10));
        assertFalse(aprovado);
    }

    @Test
    public void porcentagemAprovacaoSop(){
        valoresList = new Double[]{4.5,4.0,3.0,3.5,2.0,4.5,3.0,2.0,2.0,3.5};
        Whitebox.setInternalState(studentNotebook, "list", valoresList);
        studentNotebook.porcentagemAprovacao(3.0, "igual");
    }

    @Test
    public void porcentagemAprovacaoCGPA(){
        valoresList = new Double[]{9.65,8.87,8.0,8.67,8.21,9.34,8.2,7.9,8.0,8.6,8.4,9.0,9.1};
        Whitebox.setInternalState(studentNotebook, "list", valoresList);
        studentNotebook.porcentagemAprovacao(8.5, "menor");
    }


}
