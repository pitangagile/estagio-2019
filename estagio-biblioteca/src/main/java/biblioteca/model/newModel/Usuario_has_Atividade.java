package biblioteca.model.newModel;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_has_atividade")
public class Usuario_has_Atividade implements IObjectPersistent<Long> {

    @EmbeddedId
    private UsuarioAtividadePK id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario_has_Atividade that = (Usuario_has_Atividade) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setId(UsuarioAtividadePK id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return null;
    }
}
