package biblioteca.model.newdatabase;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioHasAtividadePK implements Serializable {

    private Integer tipo_usuarioId;

    private Integer usuarioId;

    private Integer atividadeId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasAtividadePK that = (UsuarioHasAtividadePK) o;
        return Objects.equals(tipo_usuarioId, that.tipo_usuarioId) &&
                Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(atividadeId, that.atividadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo_usuarioId, usuarioId, atividadeId);
    }

    public Integer getTipo_usuarioId() {
        return tipo_usuarioId;
    }

    public void setTipo_usuarioId(Integer tipo_usuarioId) {
        this.tipo_usuarioId = tipo_usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }
}
