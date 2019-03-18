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

    }

    @Test
    public void usuarioInexistente() {

    }

    @Test
    public void semUsuarioCarregados() {

    }
}
