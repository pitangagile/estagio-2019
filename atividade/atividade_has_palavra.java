package biblioteca.model.atividade;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "atividade_has_palavra")
public class atividade_has_palavra {


    @EmbeddedId
    private atividade_has_palavra_PK atividade_has_palavra_pk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        atividade_has_palavra that = (atividade_has_palavra) o;
        return Objects.equal(atividade_has_palavra_pk, that.atividade_has_palavra_pk);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(atividade_has_palavra_pk);
    }

    public atividade_has_palavra_PK getAtividade_has_palavra_pk() {
        return atividade_has_palavra_pk;
    }

    public void setAtividade_has_palavra_pk(atividade_has_palavra_PK atividade_has_palavra_pk) {
        this.atividade_has_palavra_pk = atividade_has_palavra_pk;
    }
}
