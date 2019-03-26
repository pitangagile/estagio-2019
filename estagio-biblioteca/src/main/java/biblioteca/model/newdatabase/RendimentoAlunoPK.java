package biblioteca.model.newdatabase;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RendimentoAlunoPK implements Serializable {

    private Integer atividadeId;

    private Integer usuarioId;

    private Integer tipo_usuarioId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAlunoPK that = (RendimentoAlunoPK) o;
        return Objects.equals(atividadeId, that.atividadeId) &&
                Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(tipo_usuarioId, that.tipo_usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeId, usuarioId, tipo_usuarioId);
    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getTipo_usuarioId() {
        return tipo_usuarioId;
    }

    public void setTipo_usuarioId(Integer tipo_usuarioId) {
        this.tipo_usuarioId = tipo_usuarioId;
    }
}
