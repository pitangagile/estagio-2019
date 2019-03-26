package biblioteca.model.Alunos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//chave composta
@Embeddable
public class AtividadeHasPalavraPK implements Serializable {

	@Column(name = "palavra_codigo_palavra", nullable = false)
    private long palavra;
    
    @Column(name = "atividade_codigo_atividade", nullable = false)
    private long atividade;

    @Override
    public int hashCode() {
        return Objects.hashCode(atividade, palavra);
}

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
}
