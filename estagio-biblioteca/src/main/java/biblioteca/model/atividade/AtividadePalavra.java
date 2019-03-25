package biblioteca.model.atividade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "atividade_has_palavra")
public class AtividadePalavra {

    @EmbeddedId
    private AtividadePalavraPK atividadePalavraPK;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "palavra_codigo_palavra", referencedColumnName = "codigo_palavra", insertable = false, updatable = false)
    })
    private Palavra palavra;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade", insertable = false, updatable = false)
    })
    private Atividade atividade;

    public AtividadePalavraPK getAtividadePalavraPK() {
        return atividadePalavraPK;
    }

    public void setAtividadePalavraPK(AtividadePalavraPK atividadePalavraPK) {
        this.atividadePalavraPK = atividadePalavraPK;
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadePalavra that = (AtividadePalavra) o;
        return Objects.equals(atividadePalavraPK, that.atividadePalavraPK) &&
                Objects.equals(palavra, that.palavra) &&
                Objects.equals(atividade, that.atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadePalavraPK, palavra, atividade);
    }
}
