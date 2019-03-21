import kagglestudents.AbstractExtractStudent;
import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class KaggleTest {

    @Mock
    ExtractStudent extractStudent = new ExtractStudent();

    StudentNotebook.TestType testType;
    StudentNotebook.ConditionType conditionType;

    StudentNotebook studentNotebook = new StudentNotebook(extractStudent);

    @Mock
    StudentVO studentVO = new StudentVO(1,337,118,4, new BigDecimal(4.5),new BigDecimal(4.5),new BigDecimal(9.5), new BigDecimal(0.92));
    @Mock
    List<StudentVO> listStudent = new ArrayList<StudentVO>();

    @Before
    public void start(){
        initMocks(this);
        listStudent.add(studentVO);
    }

    @Test
    public void isApprovedUserWithExistingId(){
        // Define how mock should behave
        when(extractStudent.load()).thenReturn(listStudent);
        when(studentVO.isApprovedById()).thenReturn(true);
        // Testing our object with ID, CGPA and LOR
        assertTrue(studentNotebook.isAnApprovedUser(1, testType.ID, 0));
        assertTrue(studentNotebook.isAnApprovedUser(1, testType.CGPA, 8.5));
        assertTrue(studentNotebook.isAnApprovedUser(1, testType.LOR, 3));
        // Verify if method of mock object has called
        verify(extractStudent, atMost(1)).load();
    }

    @Test
    public void isNotApprovedUserWithExistingId(){
        // Define how mock should behave
        when(extractStudent.load()).thenReturn(listStudent);
        when(studentVO.isApprovedById()).thenReturn(false);
        // Testing our object with ID, CGPA and LOR
        assertFalse(studentNotebook.isAnApprovedUser(54, testType.ID, 0));
        assertFalse(studentNotebook.isAnApprovedUser(54, testType.CGPA, 8.5));
        assertFalse(studentNotebook.isAnApprovedUser(54, testType.LOR, 3));
        // Verify if method of mock object has called
        verify(extractStudent, atMost(1)).load();
    }

    @Test (expected = NoSuchElementException.class)
    public void isInvalidUser(){
        // Define how mock should behave
        when(extractStudent.load()).thenReturn(new ArrayList<StudentVO>());
        // Testing our object
        assertTrue(studentNotebook.isAnApprovedUser(401, testType.ID, 0));
    }

    // Test not complete
    @Test (expected = Exception.class)
    public void listWithNoStudents(){
        // Define how mock should behave
        when(extractStudent.load()).thenReturn(new ArrayList<StudentVO>());
        // Testing our object
        assertTrue(studentNotebook.isAnApprovedUser(1, testType.CGPA, 0));
        // Verify if method of mock object has called
        verify(extractStudent, atMost(1)).load();
    }

    /* This test check the percentage of students that has your entry value equals, greater or less then the value
     of test type */
    @Test
    public void percentApprovedUser(){
        // Define how mock should behave
        when(extractStudent.load()).thenReturn(listStudent);

        // Checks if the percentage of students with entry value 8 is equal to the value of CGPA test type
        assertEquals(2.0, studentNotebook.getPercentApprovedUserByValueAndCondition(new BigDecimal(8.0), conditionType.EQUALS, testType.CGPA), 0.001);
        // Checks if the percentage of students with entry value 8 is greater then the value of CGPA test type
        assertEquals(83.0, studentNotebook.getPercentApprovedUserByValueAndCondition(new BigDecimal(8.0), conditionType.GREATER_THEN, testType.CGPA), 0.001);
        // Checks if the percentage of students with entry value 8 is less then the value of CGPA test type
        assertEquals(14.0, studentNotebook.getPercentApprovedUserByValueAndCondition(new BigDecimal(8.0), conditionType.LESS_THEN, testType.CGPA), 0.001);

        // Verify if method of mock object has called
        verify(extractStudent, atMost(1)).load();
    }
}
