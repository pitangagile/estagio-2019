import kagglestudents.ExtractStudent;
import kagglestudents.ExtractStudentCSV;
import kagglestudents.StudentNotebook;
import kagglestudents.StudentVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.times;

public class StudentNotebookTest {
    @Mock
    StudentNotebook studentNotebook;
    @Mock
    ExtractStudent extract;
    @Mock
    ExtractStudentCSV extractCsv;
    @Mock
    StudentVO estudante;

    @Before
    public void start(){
        extract = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(criarListaTeste()).when(extract).load();
        studentNotebook = new StudentNotebook(extract);
    }

    public List<StudentVO> criarListaTeste(){
        List<StudentVO> lista = new ArrayList<StudentVO>();

        StudentVO st1 = new StudentVO(); //aprovado
        st1.setId(1);
        st1.setChance(new BigDecimal(0.85));
        st1.setCgpa(new BigDecimal(10));
        st1.setLor(new BigDecimal(3));
        st1.setSop(new BigDecimal(2));

        StudentVO st2 = new StudentVO(); //não aprovado
        st2.setId(2);
        st2.setChance(new BigDecimal(0.50));
        st2.setCgpa(new BigDecimal(20));
        st2.setLor(new BigDecimal(4));
        st2.setSop(new BigDecimal(3));

        StudentVO st3 = new StudentVO(); //aprovado
        st3.setId(3);
        st3.setChance(new BigDecimal(0.78));
        st3.setCgpa(new BigDecimal(30));
        st3.setLor(new BigDecimal(5));
        st3.setSop(new BigDecimal(4));

        StudentVO st4 = new StudentVO(); //aprovado
        st4.setId(4);
        st4.setChance(new BigDecimal(0.66)); //não aprovado
        st4.setCgpa(new BigDecimal(40));
        st4.setLor(new BigDecimal(6));
        st4.setSop(new BigDecimal(4));

        lista.add(st1);
        lista.add(st2);
        lista.add(st3);
        lista.add(st4);
        return lista;
    }
    @Test
    public void usuarioAprovadoComIdExistente(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        Assert.assertTrue(studentNotebook.isAnApprovedUserId(1));
    }

    @Test
    public void usuarioNaoAprovadoComIdExistente(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        Assert.assertFalse(studentNotebook.isAnApprovedUserId(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void usuarioComIdInexistente(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        studentNotebook.isAnApprovedUserId(5);
    }

    @Test (expected = NoSuchElementException.class)
    public void semUsuariosCadastrados(){
//        extract = Mockito.spy(new ExtractStudent());
        Mockito.doReturn(new ArrayList<StudentVO>()).when(extract).load(); //fazer lista vazia
        studentNotebook = new StudentNotebook(extract);

        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");

        Assert.assertEquals(0, lista.size());
        studentNotebook.isAnApprovedUserId(1);
    }

    @Test
    public void UsuarioAprovadoPorCGPA(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        //        studentNotebook = Mockito.mock(new StudentNotebook(extract).getClass()); //quando mockado a lista é nula

        Assert.assertTrue(studentNotebook.isAnApprovedUserCGPA(new BigDecimal(10)));
    }

    @Test
    public void UsuarioNaoAprovadoPorCGPA(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        Assert.assertFalse(studentNotebook.isAnApprovedUserCGPA(new BigDecimal(20)));
    }

    @Test(expected = NoSuchElementException.class)
    public void UsuarioComCGPAInexistente(){
//        extract = Mockito.spy(new ExtractStudent());
//        Mockito.doReturn(criarListaTeste()).when(extract).load();
//        studentNotebook = new StudentNotebook(extract);

        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook,"studentNotebookList");

        Assert.assertNotEquals(0, lista.size()); //não pode estar vazia
        studentNotebook.isAnApprovedUserCGPA(new BigDecimal(100));
    }
    @Test
    public void UsuarioAprovadoPorLOR(){
        Assert.assertTrue(studentNotebook.isAnApprovedUserLOR(new BigDecimal(3)));
    }

    @Test
    public void UsuarioNaoAprovadoPorLOR(){
        Assert.assertFalse(studentNotebook.isAnApprovedUserLOR(new BigDecimal(4)));
    }

    @Test(expected = NoSuchElementException.class)
    public void UsuarioComLORInexistente(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook,"studentNotebookList");

        Assert.assertNotEquals(0, lista.size());
        studentNotebook.isAnApprovedUserLOR(new BigDecimal(100));
    }

    @Test
    public void percentualAprovacaoPorSOPMaior(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal sop = new BigDecimal(3);

        for(StudentVO e : lista){
            if(e.getSop().compareTo(sop) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoSOP(sop, ">"));
    }

    @Test
    public void percentualAprovacaoPorSOPIgual(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal sop = new BigDecimal(3);

        for(StudentVO e : lista){
            if(e.getSop().compareTo(sop) == 0) {
                total++;
                if (e.isApproved()) {
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoSOP(sop, "="));
    }

    @Test
    public void percentualAprovacaoPorSOPMenor(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal sop = new BigDecimal(3);

        for(StudentVO e : lista){
            if(e.getSop().compareTo(sop) < 0) {
                total++;
                if (e.isApproved()) {
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoSOP(sop, "<"));
    }

    @Test
    public void SinalInvalidoAprovacaoPorSOP(){
        BigDecimal sop = new BigDecimal(3);
        Assert.assertNull(studentNotebook.percentualAprovacaoSOP(sop, "$"));
        Assert.assertNull(studentNotebook.percentualAprovacaoSOP(sop, "#"));
        Assert.assertNull(studentNotebook.percentualAprovacaoSOP(sop, "+"));
    }

    @Test
    public void percentualAprovacaoPorLORMaior(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal lor = new BigDecimal(4);

        for(StudentVO e : lista){
            if(e.getLor().compareTo(lor) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoLOR(lor, ">"));
    }

    @Test
    public void percentualAprovacaoPorLORIgual(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal lor = new BigDecimal(4);

        for(StudentVO e : lista){
            if(e.getLor().compareTo(lor) == 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoLOR(lor, "="));
    }

    @Test
    public void percentualAprovacaoPorLORMenor(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal lor = new BigDecimal(4);

        for(StudentVO e : lista){
            if(e.getLor().compareTo(lor) < 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoLOR(lor, "<"));
    }

    @Test
    public void SinalInvalidoAprovacaoPorLOR(){
        BigDecimal sop = new BigDecimal(3);
        Assert.assertNull(studentNotebook.percentualAprovacaoLOR(sop, "$"));
        Assert.assertNull(studentNotebook.percentualAprovacaoLOR(sop, "#"));
        Assert.assertNull(studentNotebook.percentualAprovacaoLOR(sop, "+"));
    }

    @Test
    public void percentualAprovacaoPorCGPAImpossivel() {
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont = 0, total = 0;

        BigDecimal cgpa = new BigDecimal(40);

        for (StudentVO e : lista) {
            if (e.getCgpa().compareTo(cgpa) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoCGPA(cgpa, ">"));
    }
    @Test
    public void percentualAprovacaoPorCGPAMaior() {
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont = 0, total = 0;

        BigDecimal cgpa = new BigDecimal(20);

        for (StudentVO e : lista) {
            if (e.getCgpa().compareTo(cgpa) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoCGPA(cgpa, ">"));
    }

    @Test
    public void percentualAprovacaoPorCGPAIgual(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal cgpa = new BigDecimal(40);

        for(StudentVO e : lista){
            if(e.getCgpa().compareTo(cgpa) == 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }

        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoCGPA(cgpa, "="));
    }

    @Test
    public void percentualAprovacaoPorCGPAMenor(){
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal cgpa = new BigDecimal(40);

        for(StudentVO e : lista){
            if(e.getCgpa().compareTo(cgpa) < 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoCGPA(cgpa, "<"));
    }

    @Test
    public void SinalInvalidoAprovacaoPorCGPA(){
        BigDecimal sop = new BigDecimal(3);
        Assert.assertNull(studentNotebook.percentualAprovacaoCGPA(sop, "$"));
        Assert.assertNull(studentNotebook.percentualAprovacaoCGPA(sop, "#"));
        Assert.assertNull(studentNotebook.percentualAprovacaoCGPA(sop, "+"));
    }
    @Test
    public void percentualAprovacaoPorCGPAComNenhumCaso(){ //divisão por zero
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal cgpa = new BigDecimal(100);

        for(StudentVO e : lista){
            if(e.getCgpa().compareTo(cgpa) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoCGPA(cgpa, ">"));
    }
    @Test
    public void percentualAprovacaoPorSOPComNenhumCaso(){ //divisão por zero
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal sop = new BigDecimal(100);

        for(StudentVO e : lista){
            if(e.getSop().compareTo(sop) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoSOP(sop, ">"));
    }
    @Test
    public void percentualAprovacaoPorLORComNenhumCaso(){ //divisão por zero
        List<StudentVO> lista = (List<StudentVO>) Whitebox.getInternalState(studentNotebook, "studentNotebookList");
        double cont= 0, total = 0;

        BigDecimal lor = new BigDecimal(100);

        for(StudentVO e : lista){
            if(e.getLor().compareTo(lor) > 0) {
                total++;
                if (e.isApproved()) { //aprovados precisam de no mínimo 70% de chance
                    cont++;
                }
            }
        }
        double perc;
        if (cont != 0){  //evitar divisão por zero
            perc = (cont / total) * 100;
        }
        else{
            perc = 0;
        }
        System.out.print(cont+" / "+total+" = ");
        System.out.println("percentual de aprovação: "+perc);
        Assert.assertEquals(new BigDecimal(perc), studentNotebook.percentualAprovacaoLOR(lor, ">"));
    }
}
