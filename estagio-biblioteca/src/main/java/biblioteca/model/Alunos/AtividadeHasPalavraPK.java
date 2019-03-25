package biblioteca.model.Alunos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//classe embarcável para construção de chave composta
// para a tabela "atividade_has_palavra"
@Embeddable
public class AtividadeHasPalavraPK implements Serializable {

    //chave que mapeia uma atividade
    @Column(name = "atividade_codigo_atividade", nullable = false)
    private long atividade;

    //chave que mapeia uma palavra
    @Column(name = "palavra_codigo_palavra", nullable = false)
    private long palavra;

    public long getAtividade() {
        return atividade;
    }

    public void setAtividade(long atividade) {
        this.atividade = atividade;
    }

    public long getPalavra() {
        return palavra;
    }

    public void setPalavra(long palavra) {
        this.palavra = palavra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtividadeHasPalavraPK that = (AtividadeHasPalavraPK) o;

        if (atividade != that.atividade) return false;
        return palavra == that.palavra;
    }

    @Override
    public int hashCode() {
        int result = (int) (atividade ^ (atividade >>> 32));
        result = 31 * result + (int) (palavra ^ (palavra >>> 32));
        return result;
    }
}
