package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_has_atividade")
public class usuario_has_atividade implements Serializable {

    @EmbeddedId
    private usuario_has_atividadePK usuario_has_atividadePK;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usuario_has_atividade that = (usuario_has_atividade) o;
        return Objects.equal(usuario_has_atividadePK, that.usuario_has_atividadePK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario_has_atividadePK);
    }

    public biblioteca.model.atividade.usuario_has_atividadePK getUsuario_has_atividadePK() {
        return usuario_has_atividadePK;
    }

    public void setUsuario_has_atividadePK(biblioteca.model.atividade.usuario_has_atividadePK usuario_has_atividadePK) {
        this.usuario_has_atividadePK = usuario_has_atividadePK;
    }
}
