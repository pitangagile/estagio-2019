package biblioteca.model.atividade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AtividadePalavraPK implements Serializable {

    @Column(name = "atividade_codigo_atividade")
    private Long atividadeCodigo;

    @Column(name = "palavra_codigo_palavra")
    private Long palavraCodigo;

    public AtividadePalavraPK(){

    }

    public Long getAtividadeCodigo() {
        return atividadeCodigo;
    }

    public Long getPalavraCodigo() {
        return palavraCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadePalavraPK that = (AtividadePalavraPK) o;
        return Objects.equals(atividadeCodigo, that.atividadeCodigo) &&
                Objects.equals(palavraCodigo, that.palavraCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeCodigo, palavraCodigo);
    }
}
