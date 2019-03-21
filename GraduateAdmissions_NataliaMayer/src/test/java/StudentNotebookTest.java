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

        this.students = Mockito.spy(new ArrayList<StudentVO>());
        students.add(getStudentVO());
        Mockito.doReturn(false).when(students.get(Mockito.anyInt())).isApproved();

        Boolean aprovado = studentNotebook.isAnApprovedUser(1);
        Assert.assertFalse(aprovado);

        Mockito.verify(students, new Times(1)).size();

    }

    @Test
    public void usuarioAprovadoComIdExistente() {

        this.students = Mockito.spy(new ArrayList<StudentVO>());
        students.add(getStudentVO());
        Mockito.doReturn(true).when(students.get(Mockito.anyInt())).isApproved();

        Boolean aprovado = studentNotebook.isAnApprovedUser(1);
        Assert.assertTrue(aprovado);

        Mockito.verify(students, new Times(1)).size();

    }

    @Test
    public void usuarioInexistente() {
        // retorna falso quando pega qualquer aluno, pois ele n existe na lista.
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        Mockito.doReturn(false).when(students.get(Mockito.anyInt()));
        Mockito.verify(students, new Times(1)).size();
    }

    @Test
    public void semUsuarioCarregados() {
        //se retornar 0 é pq o array ta zerado
        this.students = Mockito.spy(new ArrayList<StudentVO>());
        Mockito.doReturn(0).when(students.size());
        Mockito.verify(students, new Times(1)).size();

    }
}
