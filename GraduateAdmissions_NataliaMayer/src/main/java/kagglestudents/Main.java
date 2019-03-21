package kagglestudents;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ExtractStudent teste = new ExtractStudent();
        StudentNotebook alunoNotebook = new StudentNotebook(teste);
        //carregando a lista de estudantes na lista stundetvos
        ArrayList<StudentVO> studentVOS = teste.load();
        StudentVO student = new StudentVO();

        System.out.println(studentVOS.size()); //Mostra tamanho da lista de alunos
        System.out.println(alunoNotebook.isAnApprovedUser(2)); // Função pra mostrar se o aluno de id tal foi aprovado

        //Percorrendo a lista de estudante e printando o resultado dos métodos, true pra aprovados e false pra reprovados.
        // A media foi colocada no metodo so pra fins de teste.
        for(int i =0 ; i < studentVOS.size();i++){
            System.out.println(studentVOS.get(i).isApproved());
            System.out.println(studentVOS.get(i).isApprovedCPGA());
            System.out.println(studentVOS.get(i).isApprovedLOR());
        }

        // chamando os metodos da porcentagem, passando a lista de alunos e um valor pra calcular a porcentagem, e a operação
        //OP 1 "<" / OP 2 "=" / OP 3 ">"
        System.out.println(student.porcentagemCGPA(studentVOS, BigDecimal.valueOf(9.65),1));
        System.out.println(student.porcentagemLOR(studentVOS, BigDecimal.valueOf(2.5),2));
        System.out.println(student.porcentagemSOP(studentVOS, BigDecimal.valueOf(3.0),3));


    }
}
