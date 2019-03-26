package biblioteca.model.atividade;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class atividade_has_palavra_PK implements Serializable {


    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private atividade atividade;

    @JoinColumn(name = "palavra_codigo_palavra", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private palavra palavra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        atividade_has_palavra_PK that = (atividade_has_palavra_PK) o;
        return Objects.equal(atividade, that.atividade) &&
                Objects.equal(palavra, that.palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(atividade, palavra);
    }

    public biblioteca.model.atividade.atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(biblioteca.model.atividade.atividade atividade) {
        this.atividade = atividade;
    }

    public biblioteca.model.atividade.palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(biblioteca.model.atividade.palavra palavra) {
        this.palavra = palavra;
    }
}
