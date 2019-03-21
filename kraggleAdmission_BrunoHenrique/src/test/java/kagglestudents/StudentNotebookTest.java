package kagglestudents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.Whitebox;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentNotebookTest {

    StudentNotebook studentNotebook;
    @Mock
    List<StudentVO> otherStudent;
    @Mock
    StudentVO studentVO;
    @Mock
    ExtractStudent extractStudent;

    @Before
    public void start(){
        studentNotebook = new StudentNotebook(new ExtractStudent());
        //extractStudent = Mockito.mock(ExtractStudent.class);
        extractStudent = new ExtractStudent();


        otherStudent = (List<StudentVO>) Whitebox.getInternalState(this.studentNotebook, "studentNotebookList");
    }

    @After
    public void end(){
        otherStudent = null;
        studentNotebook = null;
        extractStudent = null;
    }

    //SOP LOR, CPGA PERCENT
    @Test
    public void approvalPercentCGPA(){
        double avereage = 0.0;
        int qtdOfApproved = 0;
        assertNotEquals(0.0, studentNotebook.approvedByCgpa(3));
        for(StudentVO svo : this.otherStudent){
            if(svo.getCgpa().doubleValue() >=3.0 &&
            svo.isApproved()){
                avereage = avereage + svo.getCgpa().doubleValue();
                qtdOfApproved++;
            }

        }
        avereage = (avereage/qtdOfApproved)*100;
        assertEquals(new BigDecimal(avereage), new BigDecimal(this.studentNotebook.approvedByCgpa(3)));

    }

    @Test
    public void approvalPercentLOR(){
        double avereage = 0.0;
        int qtdOfApproved = 0;
        assertNotEquals(0.0, studentNotebook.approvedByLor(3));
        for(StudentVO svo : this.otherStudent){
            if(svo.getLor().doubleValue() >=3.0 &&
            svo.isApproved()){
                avereage = avereage + svo.getLor().doubleValue();
                qtdOfApproved++;
            }

        }
        avereage = (avereage/qtdOfApproved)*100;
        assertEquals(new BigDecimal(avereage), new BigDecimal(this.studentNotebook.approvedByLor(3)));

    }

    @Test
    public void approvalPercentSOP(){
        double avereage = 0.0;
        int qtdOfApproved = 0;
        assertNotEquals(0.0, studentNotebook.approvedBySop(3));
        for(StudentVO svo : this.otherStudent){
            if(svo.getSop().doubleValue() >=3.0 &&
            svo.isApproved()){
                avereage = avereage + svo.getSop().doubleValue();
                qtdOfApproved++;
            }

        }
        avereage = (avereage/qtdOfApproved)*100;
        assertEquals(new BigDecimal(avereage), new BigDecimal(this.studentNotebook.approvedBySop(3)));



    }

    //VALID SOP AND CGPA
    @Test
    public void unvalidSopOrCgpa(){

        //StudentNotebook sn = Mockito.spy(new StudentNotebook(extractStudent));

        //Mockito.verify(sn).isAnApprovedUser(new BigDecimal(4.5), new BigDecimal(9.65));
        assertTrue(studentNotebook.isAnApprovedUser(new BigDecimal("4.5"), new BigDecimal("9.65")));
        assertFalse(studentNotebook.isAnApprovedUser(new BigDecimal("1"), new BigDecimal("1")));

    }

    @Test
    public void isntApprovedBySopAndCgpa(){
        BigDecimal lor,cgpa;
        cgpa = new BigDecimal(352.00);
        lor = new BigDecimal(352.00);

        StudentNotebook sn = Mockito.spy(new StudentNotebook(extractStudent));
        Mockito.doReturn(Boolean.FALSE).when(sn).isAnApprovedUser(lor, cgpa);
        assertFalse(sn.isAnApprovedUser(lor, cgpa));
    }

    @Test
    public void isApprovedBySopAndCgpa(){
        BigDecimal lor,cgpa;
        cgpa = new BigDecimal(352.00);
        lor = new BigDecimal(352.00);
        StudentNotebook sn = Mockito.spy(new StudentNotebook(extractStudent));
        Mockito.doReturn(Boolean.TRUE).when(sn).isAnApprovedUser(lor, cgpa);
        assertTrue(sn.isAnApprovedUser(lor, cgpa));

    }


    //APROVADO POR ID

    @Test
    public void isAnApprovedUserWithUnvalidId() {
        assertNotNull("O usuario deveria ser nulo, pois não há esse Id", studentNotebook.isAnApprovedUser(1));


    }

    @Test
    public void isAnApprovedUserWithValidId(){
        assertTrue("O metodo deveria retornar 'true' pois o id é valido", studentNotebook.isAnApprovedUser(1));
        //Mockito.doReturn(this.studentVO.isApproved());

        for(StudentVO sv : otherStudent){
            if(sv.getId() == 1 && !sv.isApproved()){
                fail("O usuario deveria estar aprovado!");
            }
        }

    }
    @Test
    public void unoadedUsers(){
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        //Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent1).load();
        StudentNotebook studentNotebook1 = new StudentNotebook(extractStudent1);

        studentNotebook1.isAnApprovedUser(1);


    }

    @Test
    public void isAnUnapprovedUserWithValidUser(){
        ExtractStudent extractStudent1 = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent1).load();
        StudentNotebook sn = Mockito.spy(new StudentNotebook(extractStudent1));
        StudentVO studentVO = Mockito.spy(new StudentVO());
        studentVO.setId(1);
        sn.studentNotebookList.add(studentVO);

        Mockito.doReturn(Boolean.FALSE).when(studentVO).isApproved();


        assertFalse(sn.isAnApprovedUser(1));
    }





}