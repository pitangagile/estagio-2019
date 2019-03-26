package biblioteca.model.atividade;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tipo_usuario")
public class tipo_usuario implements Serializable {

    @EmbeddedId
    private tipo_usuarioPK codigo;

    @Size
    @Column(name = "descricao")
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tipo_usuario that = (tipo_usuario) o;
        return Objects.equal(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public tipo_usuarioPK getCodigo() {
        return codigo;
    }

    public void setCodigo(tipo_usuarioPK codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
