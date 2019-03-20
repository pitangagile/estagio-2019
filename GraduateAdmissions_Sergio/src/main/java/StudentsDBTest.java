import org.junit.*;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;


public class StudentsDBTest {
    private StudentsDB list;

    @Before
    public void init() {
        this.list = new StudentsDB();
    }

    @Test
    public void approvedExistingStudent() {
        Student student = spy(newStudent());
        Mockito.doReturn(true).when(student).wasApproved();
        list.load(student);
        Assert.assertTrue("It should return true if the student has been approved", list.approved(1));
    }

    @Test
     public void notApprovedExistingStudent() {
        Student student = spy(newStudent());
        Mockito.doReturn(false).when(student).wasApproved();
        list.load(student);
        Assert.assertFalse("It should return false if the student has not been approved", list.approved(1));
    }

    @Test
    public void approveNonExistingStudent() {
        // Serial number -1 does not exist
        Assert.assertFalse("It should return false if the serial number does not exist", list.approved(-1));
    }

    @Test
    public void approveEmptyList() {
        this.list = spy(new StudentsDB());
        //List aways start empty
        Mockito.doReturn(false).when(list).approved(anyInt());
        Assert.assertFalse("It should return false if the list is empty", list.approved(1));
    }

    @Test
    public void approvedExistingStudentByGPAnLOR() {
        Student student = spy(newStudent());
        Mockito.doReturn(true).when(student).wasApproved();
        list.load(student);
        //lor and cgpa of sample student created in newStudent()
        Assert.assertTrue("It should return true if the student has been approved", list.approved(4.5f, 9.65f));
    }

    @Test
    public void notApprovedExistingStudentByGPAnLOR() {
        Student student = spy(newStudent());
        Mockito.doReturn(false).when(student).wasApproved();
        list.load(student);
        //lor and cgpa of sample student created in newStudent()
        Assert.assertFalse("It should return false if the student has been approved", list.approved(4.5f, 9.65f));
    }

    @Test
    public void approveNonExistingStudentByGPAnLOR() {
        // CGPA and LOR do not match any student
        Assert.assertFalse("It should return false if the serial number does not exist", list.approved(0f, 0f));
    }

    @Test
    public void approveEmptyListByGPAnLOR() {
        StudentsDB spy = spy(new StudentsDB());
        Mockito.doReturn(false).when(spy).approved(anyFloat(), anyFloat());
        //List aways start empty
        Assert.assertFalse("It should return false if the list is empty", spy.approved(4.5f, 9.65f));
    }



    @Test
    public void percentApprovedByLOR() {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        try {
            //the method loadStudents inflate the mock with some students that match the percentage tested below
            Assert.assertEquals(75f, spy.percentApprovedByLOR(3.0f, '>'), 0);
            Assert.assertEquals(50f, spy.percentApprovedByLOR(3.0f, '<'), 0);
            Assert.assertEquals(0f, spy.percentApprovedByLOR(3.0f, '='), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected=Exception.class)
    public void percentApprovedByLorNonExistingOperator() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        //it will throw an exception because '*' it's not an operator
        spy.percentApprovedByLOR(3.0f, '*');
    }

    @Test(expected=Exception.class)
    public void percentApprovedByLorEmptyList() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        //it will throw an exception because the list is empty
        spy.percentApprovedByLOR(3.0f, '>');
    }

    @Test
    public void percentApprovedByCGPA() {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        try {
            //the method loadStudents inflate the mock with some students that match the percentage tested below
            Assert.assertEquals(75f, spy.percentApprovedByCGPA(8.00f, '>'), 0);
            Assert.assertEquals(50f, spy.percentApprovedByCGPA(8.00f, '<'), 0);
            Assert.assertEquals(0f, spy.percentApprovedByCGPA(8.00f, '='), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected=Exception.class)
    public void percentApprovedByCGPANonExistingOperator() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        //it will throw an exception because '*' it's not an operator
        spy.percentApprovedByCGPA(9.00f, '*');
    }

    @Test(expected=Exception.class)
    public void percentApprovedByCGPAEmptyList() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        //it will throw an exception because the list is empty
        spy.percentApprovedByCGPA(9.00f, '>');
    }

    @Test
    public void percentApprovedBySOAP() {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        try {
            //the method loadStudents inflate the mock with some students that match the percentage tested below
            Assert.assertEquals(100f, spy.percentApprovedBySOAP(4.5f, '>'), 0);
            Assert.assertEquals(25f, spy.percentApprovedBySOAP(4.5f, '<'), 0);
            Assert.assertEquals(100f, spy.percentApprovedBySOAP(4.5f, '='), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected=Exception.class)
    public void percentApprovedBySOAPNonExistingOperator() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        loadStudents(spy);
        //it will throw an exception because '*' it's not an operator
        spy.percentApprovedBySOAP(3.5f, '*');
    }

    @Test(expected=Exception.class)
    public void percentApprovedBySOAPEmptyList() throws Exception {
        StudentsDB spy = spy(new StudentsDB());
        //it will throw an exception because the list is empty
        spy.percentApprovedBySOAP(3.5f, '>');
    }

    public Student newStudent() {
        return new Student(1,	337,	118,	4,	4.5f,	4.5f,	9.65f,	true,	0.92f);
    }

    public void loadStudents(StudentsDB studentsDB) {
        studentsDB.load(new Student(1,	337,	118,	4,	4.5f,	4.5f,	9.65f,	true,	0.92f));
        studentsDB.load(new Student(2,	228,	120,	2,	2.5f,	2.0f,	8.00f,	false,	0.52f));
        studentsDB.load(new Student(3,	423,	110,	3,	4.0f,	3.5f,	7.67f,	true,	0.72f));
        studentsDB.load(new Student(4,	214,	90,	4,	3.5f,	4.5f,	9.54f,	false,	0.62f));
        studentsDB.load(new Student(5,	376,	112,	5,	5f,	4.0f,	9.89f,	true,	0.82f));
        studentsDB.load(new Student(6,	359,	105,	1,	2.5f,	3.0f,	7.38f,	false,	0.62f));
        studentsDB.load(new Student(7,	123,	96,	4,	4.5f,	1.5f,	8.53f,	true,	0.95f));
    }
}
