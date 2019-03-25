package biblioteca.model.newModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atividade_has_palavra")
public class Atividade_has_Palavra implements IObjectPersistent<Long> {
    @EmbeddedId
    AtividadePalavraPK codigo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade_has_Palavra that = (Atividade_has_Palavra) o;

        return codigo != null ? codigo.equals(that.codigo) : that.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    public AtividadePalavraPK getCodigo() {
        return codigo;
    }

    public void setCodigo(AtividadePalavraPK codigo) {
        this.codigo = codigo;
    }

    @Override
    public Long getId() {
        return null;
    }
}
