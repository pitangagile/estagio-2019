import kagglestudents.ExtractStudent;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.internal.verification.Times;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.*;

public class TesteKanggle {


  public StudentNotebook stdtNoteBook;
  public ExtractStudent extractStudent;

  public List<StudentVO> students;

  @Mock
  public List<StudentVO> listMocked;

  @Before
  public void start(){
    this.extractStudent = new ExtractStudent();
    this.stdtNoteBook = new StudentNotebook(this.extractStudent);
    }

    //ADICIONAR AFTER

  public StudentVO returnStudent(){
    StudentVO studentVO = new StudentVO();
    studentVO.setId(2);
    studentVO.setCgpa(new BigDecimal(6.9));
    studentVO.setLor(new BigDecimal(4.0));
    studentVO.setChance(new BigDecimal(0.92));
    studentVO.setGre(120);
    studentVO.setResearch(new Byte((byte) '0'));
    studentVO.setSop(new BigDecimal(3.8));
    studentVO.setToelf(247);
    studentVO.setUniversityRating(322);
    return studentVO;
  }

  @Test
  public void usuarioAprovadoComIdExistente(){

    //Adicionando estudante ficticio ao mock
   this.listMocked = Arrays.asList(this.returnStudent());

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    //Verificando se o usuario com id 2 é aprovado
    assertTrue(this.stdtNoteBook.isAnApprovedUser(2));

  }

  @Test(expected = NoSuchElementException.class)
  public void usuarioNaoExiste(){

    //Adicionando estudante ficticio ao mock
    this.listMocked = Arrays.asList(this.returnStudent());

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    //Esse id nao existe, tem que lançar a exception
      this.stdtNoteBook.isAnApprovedUser(3);
  }

  @Test
  public void listaNaoCarregada() {

    ExtractStudent extractStudent2 = Mockito.spy(new ExtractStudent());
    StudentNotebook studentNotebook = new StudentNotebook(extractStudent2);

    Mockito.doReturn(new ArrayList<StudentVO>()).when(extractStudent2).load();
    studentNotebook.isAnApprovedUser(1);
  }

  @Test
  public void usuarioNaoAprovadoComIdExistente(){

    ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
    StudentVO student = Mockito.spy(this.returnStudent());

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
    Boolean aprovado = studentNotebook.isAnApprovedUser(2);

    assertFalse(aprovado);

    Mockito.verify(studentsList, new Times(1)).size();

  }

  @Test
  public void usuarioAprovadoPorCgpaLor(){

    this.listMocked = Arrays.asList(this.returnStudent());

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    //Verify if user, given cgpa, was approved
    assertTrue(this.stdtNoteBook.isAnApprovedUserGivenCgpaLor("CGPA",new BigDecimal(6.9)));

    //Verify if user, given lor, was approved
    assertTrue(this.stdtNoteBook.isAnApprovedUserGivenCgpaLor("lor",new BigDecimal(4.0)));


  }


  @Test
  public void usuarioReprovadoPorCgpaLor(){

    ArrayList<StudentVO> studentsList = Mockito.spy(new ArrayList<StudentVO>());
    StudentVO student = Mockito.spy(this.returnStudent());

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


    // Must me False to CGPA
    Boolean aprovado = studentNotebook.isAnApprovedUserGivenCgpaLor("cgpa",new BigDecimal(6.9));

    //Must be false to LOR
    Boolean aprovado2 = studentNotebook.isAnApprovedUserGivenCgpaLor("lor",new BigDecimal(4.0));

    assertFalse(aprovado);
    assertFalse(aprovado2);
    

  }

  @Test
  public void porcentagemAprovadosDadoCgpa(){

    //Add another student for calculate percentage
    StudentVO studentVO = new StudentVO();
    studentVO.setId(3);
    studentVO.setCgpa(new BigDecimal(7.2));
    studentVO.setLor(new BigDecimal(3.6));
    studentVO.setChance(new BigDecimal(0.90));
    studentVO.setGre(120);
    studentVO.setResearch(new Byte((byte) '0'));
    studentVO.setSop(new BigDecimal(3.8));
    studentVO.setToelf(247);
    studentVO.setUniversityRating(322);

    this.listMocked = Arrays.asList(this.returnStudent(),studentVO);

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    assertEquals(50.0, this.stdtNoteBook.percentageApprovedUserCgpa(">",new BigDecimal(7.0)), 0.001);
    assertEquals(0.0,this.stdtNoteBook.percentageApprovedUserCgpa("<", new BigDecimal(6.8)),0.001);
    assertEquals(50.0, this.stdtNoteBook.percentageApprovedUserCgpa("=",new BigDecimal(7.2)), 0.001);

  }

  @Test
  public void porcentagemAprovadosDadoLor(){

    //Add another student for calculate percentage
    StudentVO studentVO = new StudentVO();
    studentVO.setId(3);
    studentVO.setCgpa(new BigDecimal(7.2));
    studentVO.setLor(new BigDecimal(3.6));
    studentVO.setChance(new BigDecimal(0.90));
    studentVO.setGre(120);
    studentVO.setResearch(new Byte((byte) '0'));
    studentVO.setSop(new BigDecimal(3.8));
    studentVO.setToelf(247);
    studentVO.setUniversityRating(322);

    this.listMocked = Arrays.asList(this.returnStudent(),studentVO);

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    assertEquals(50.0, this.stdtNoteBook.percentageApprovedUserLor(">",new BigDecimal(3.6)), 0.001);
    assertEquals(0.0,this.stdtNoteBook.percentageApprovedUserLor("<", new BigDecimal(3.5)),0.001);
    assertEquals(50.0, this.stdtNoteBook.percentageApprovedUserLor("=",new BigDecimal(4.0)), 0.001);

  }

  @Test
  public void porcentagemAprovadosDadoSop(){

    //Add another student
    StudentVO studentVO = new StudentVO();
    studentVO.setId(3);
    studentVO.setCgpa(new BigDecimal(7.2));
    studentVO.setLor(new BigDecimal(3.6));
    studentVO.setChance(new BigDecimal(0.90));
    studentVO.setGre(120);
    studentVO.setResearch(new Byte((byte) '0'));
    studentVO.setSop(new BigDecimal(3.8));
    studentVO.setToelf(247);
    studentVO.setUniversityRating(322);

    this.listMocked = Arrays.asList(this.returnStudent(),studentVO);

    Whitebox.setInternalState(this.stdtNoteBook,"studentNotebookList",this.listMocked);

    assertEquals(100.0, this.stdtNoteBook.percentageApprovedUserSop(">",new BigDecimal(3.6)), 0.001);
    assertEquals(0.0,this.stdtNoteBook.percentageApprovedUserSop("<", new BigDecimal(3.8)),0.001);
    assertEquals(100.0, this.stdtNoteBook.percentageApprovedUserSop("=",new BigDecimal(3.8)), 0.001);

  }



}
