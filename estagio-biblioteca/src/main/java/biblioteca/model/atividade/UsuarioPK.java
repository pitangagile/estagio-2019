package biblioteca.model.atividade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioPK implements Serializable {

    @Column(name = "codigo_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUsuario;

    @Column(name = "tipo_usuario_codigo", insertable = false, updatable = false)
    private Long tipoUsuarioCodigo;

    public UsuarioPK(){
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public Long getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPK usuarioPK = (UsuarioPK) o;
        return Objects.equals(codigoUsuario, usuarioPK.codigoUsuario) &&
                Objects.equals(tipoUsuarioCodigo, usuarioPK.tipoUsuarioCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUsuario, tipoUsuarioCodigo);
    }
}
