package biblioteca.model.atividade_usuario;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AtividadeTemPalavraPK implements Serializable {

    @Column(name = "atp_cl_atividadeCodigoAtividade", nullable = false)
    private long atividadeCodigoAtividade;

    @Column(name = "atp_cl_palavraCodigoPalavra", nullable = false)
    private long palavraCodigoPalavra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeTemPalavraPK that = (AtividadeTemPalavraPK) o;
        return atividadeCodigoAtividade == that.atividadeCodigoAtividade &&
                palavraCodigoPalavra == that.palavraCodigoPalavra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeCodigoAtividade, palavraCodigoPalavra);
    }

    public long getAtividadeCodigoAtividade() {
        return atividadeCodigoAtividade;
    }

    public void setAtividadeCodigoAtividade(long atividadeCodigoAtividade) {
        this.atividadeCodigoAtividade = atividadeCodigoAtividade;
    }

    public long getPalavraCodigoPalavra() {
        return palavraCodigoPalavra;
    }

    public void setPalavraCodigoPalavra(long palavraCodigoPalavra) {
        this.palavraCodigoPalavra = palavraCodigoPalavra;
    }
}
