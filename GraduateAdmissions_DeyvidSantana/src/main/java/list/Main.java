package list;

import persistente.Aluno;
import persistente.ObjetoPersistenteAbstrato;
import persistente.Professor;

public class Main {
    public static void main(String... args){
       ObjetoPersistenteAbstrato aluno = new Aluno();
       ObjetoPersistenteAbstrato professor = new Professor();
       aluno.salvar();
    }
}
