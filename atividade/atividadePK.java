package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class atividadePK  implements Serializable {

    @Column(name = "codigo_atividade")
    private Long codigo_atividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        atividadePK that = (atividadePK) o;
        return Objects.equal(codigo_atividade, that.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo_atividade);
    }

    public Long getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Long codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }
}
