import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentTest {

    String arquivo = "Admission_Predict.csv";
    BufferedReader bufferedReader = null;
    String linha = "";
    int passo = 0;

    @Mock

    StudentNotebook studentNotebook;
    ExtractStudent extractStudent;
    List<StudentVO> list;

    //Factory
    //Strategy
    //Composite

    @Before

    public void start() {

        this.extractStudent = new ExtractStudent();
        this.studentNotebook = new StudentNotebook(extractStudent);

    }

    StudentNotebook studentNotebook1 = mock(StudentNotebook.class);

    @Test

    public void isAnAprovedUserExistente() {

        Assert.assertTrue(studentNotebook.isAnApprovedUser(1));

    }

    @Test(expected = NoSuchElementException.class)

    public void isAnApprovedUserInexistente() {

        Assert.assertTrue(studentNotebook.isAnApprovedUser(556));

    }

    @Test

    public void isApprovedUserExistenteReprovado() {

        when(studentNotebook1.isAnApprovedUser(1)).thenReturn(true);

        Assert.assertEquals(studentNotebook1.isAnApprovedUser(1), true);

    }

    @Test

    public void isApprovedBySop() {

        BigDecimal sop = new BigDecimal("7.5");
        Assert.assertTrue(studentNotebook.isApprovedBySop(sop));

    }



    @Test

    public void percentageApprovedCgpa() {

            Double compara = studentNotebook.percentageapprovedCgpa();
            Assert.assertEquals(99.75, compara, 0);

        }

    @Test

    public void percentageApprovedLor() {

        Double compara = studentNotebook.percentageapprovedLor();
        Assert.assertEquals(31.5, compara, 0);

    }

    @Test

    public void percentageApprovedSop(){

        Double compara = studentNotebook.percentageapprovedSop();
        Assert.assertEquals(40.0, compara, 0);

    }

    }


