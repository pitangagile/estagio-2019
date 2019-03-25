package biblioteca.model.newModel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AtividadePalavraPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_atividade", referencedColumnName = "id")
    private Atividade codigoAtividade;

    @ManyToOne
    @JoinColumn(name = "codigo_palavra", referencedColumnName = "id")
    private Palavra codigoPalavra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtividadePalavraPK that = (AtividadePalavraPK) o;

        if (codigoAtividade != null ? !codigoAtividade.equals(that.codigoAtividade) : that.codigoAtividade != null)
            return false;
        return codigoPalavra != null ? codigoPalavra.equals(that.codigoPalavra) : that.codigoPalavra == null;
    }

    @Override
    public int hashCode() {
        int result = codigoAtividade != null ? codigoAtividade.hashCode() : 0;
        result = 31 * result + (codigoPalavra != null ? codigoPalavra.hashCode() : 0);
        return result;
    }

    public Atividade getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Atividade codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Palavra getCodigoPalavra() {
        return codigoPalavra;
    }

    public void setCodigoPalavra(Palavra codigoPalavra) {
        this.codigoPalavra = codigoPalavra;
    }
}
