

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class KaggleTest {

    @Mock
    public StudentNotebook notebook;
    public ExtractStudent extractor;
    public List<StudentVO> students;
   
    @Before
    public void start() {
        students = new ArrayList<StudentVO>();
        StudentVO student =  new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92));

        this.students.add(student);
        extractor = new ExtractStudent();
        notebook = new StudentNotebook(extractor);
    }
    
    @Test
    public void existingIdApprovedUser() {
        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));

        
        Mockito.doReturn(true).when(student).isApproved();
        list.add(student);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(student);

        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);
        Assert.assertTrue(notebook.isAnApprovedUserByID(1));
        Mockito.verify(list, new Times(1)).size();
    }
    
    @Test
    public void existingIDbutNotApprovedUser() {

        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student2 =  Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));

        Mockito.doReturn(false).when(student2).isApproved();
        list.add(student2);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(student2);


        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);

        Assert.assertFalse(notebook.isAnApprovedUserByID(1));
        Mockito.verify(list, new Times(1)).size();
    }


    @Test(expected = NoSuchElementException.class)
    public void notValidUser() {
        Mockito.when(extractor.load()).thenReturn(new ArrayList<StudentVO>());
        Assert.assertTrue(notebook.isAnApprovedUserByID(1));

    }

    
	@Test(expected = NoSuchElementException.class)
	public void usersNotLoaded()	{
    ExtractStudent extractor1 = Mockito.spy(new ExtractStudent());
    StudentNotebook notebook1 = new StudentNotebook(extractor);
    
    Assert.assertFalse(notebook1.isAnApprovedUserByID(1));
}


    @Test
    public void approvedUserByCgpa(){
        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));
        //student.setCgpa(new BigDecimal(7.0));
        list.add(student);
        
        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);
        Assert.assertTrue(notebook.isAnApprovedUserbyCgpa(new BigDecimal(9.65)));

        //Mockito.verify(list, new Times(1));
    }
    @Test
    public void notApprovedUserByCgpa(){
        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));
        list.add(student);

        Mockito.when(list.get(Mockito.anyInt())).thenReturn(student);
        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);
        Assert.assertFalse(notebook.isAnApprovedUserbyCgpa(new BigDecimal(9.0)));
    }
    @Test
    public void approvedUserByLor(){
        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));
        list.add(student);

        Mockito.when(list.get(Mockito.anyInt())).thenReturn(student);

        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);
        Assert.assertTrue(notebook.isAnApprovedUserbyLor(new BigDecimal(7.0)));

    }
    @Test
    public void notApprovedUserByLorTest(){
        ArrayList<StudentVO> list = Mockito.spy(new ArrayList<StudentVO>());
        StudentVO student = Mockito.spy(new StudentVO(1, 337, 118, 4, new BigDecimal(4.5), new BigDecimal(4.5), 
        		new BigDecimal(9.65), (byte) 1, new BigDecimal(0.92)));
        list.add(student);

        Mockito.when(list.get(Mockito.anyInt())).thenReturn(student);

        ExtractStudent extractor = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(list).when(extractor).load();

        StudentNotebook notebook = new StudentNotebook(extractor);
        Assert.assertFalse(notebook.isAnApprovedUserbyLor(new BigDecimal(9.0)));
    }

    @Test
    public void invalidComparisonOperatorCgpa(){
        BigDecimal cgpa = new BigDecimal(8.65);
        Assert.assertNull(notebook.approvalPercentageByCgpa(cgpa, "a"));
        Assert.assertNull(notebook.approvalPercentageByCgpa(cgpa, "2"));
        Assert.assertNull(notebook.approvalPercentageByCgpa(cgpa, "."));
}
    
    @Test
    public void invalidComparisonOperatorLor(){
        BigDecimal lor = new BigDecimal(4.5);
        Assert.assertNull(notebook.approvalPercentageByLor(lor, "a"));
        Assert.assertNull(notebook.approvalPercentageByLor(lor, "2"));
        Assert.assertNull(notebook.approvalPercentageByLor(lor, "."));
}
    

    @Test
    public void invalidComparisonOperatorSop(){
        BigDecimal sop = new BigDecimal(4.5);
        Assert.assertNull(notebook.approvalPercentageBySop(sop, "a"));
        Assert.assertNull(notebook.approvalPercentageBySop(sop, "2"));
        Assert.assertNull(notebook.approvalPercentageBySop(sop, "."));
}
}