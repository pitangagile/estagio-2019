package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_Atividade_Tem_Palavra")
public class AtividadeTemPalavra implements IObjectPersistent<AtividadeTemPalavraPK> {

    @EmbeddedId
    private AtividadeTemPalavraPK atividadeTemPalavraPK;

    @MapsId("atividadeCodigoAtividade")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atividadeCodigoAtividade")
    private Atividade atividade;

    @MapsId("palavraCodigoPalavra")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palavraCodigoPalavra")
    private Palavra palavra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeTemPalavra that = (AtividadeTemPalavra) o;
        return Objects.equals(atividadeTemPalavraPK, that.atividadeTemPalavraPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeTemPalavraPK);
    }

    public AtividadeTemPalavraPK getAtividadeTemPalavraPK() {
        return atividadeTemPalavraPK;
    }

    public void setAtividadeTemPalavraPK(AtividadeTemPalavraPK atividadeTemPalavraPK) {
        this.atividadeTemPalavraPK = atividadeTemPalavraPK;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    @Override
    public AtividadeTemPalavraPK getId() {
        return this.atividadeTemPalavraPK;
    }
}
