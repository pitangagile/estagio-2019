package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class tipo_usuarioPK implements Serializable {

    @Column(name = "codigo")
    private Long codigo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tipo_usuarioPK that = (tipo_usuarioPK) o;
        return Objects.equal(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
