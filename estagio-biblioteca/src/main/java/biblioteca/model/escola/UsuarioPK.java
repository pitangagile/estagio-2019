package biblioteca.model.escola;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioPK implements Serializable {



    @Column(name = "codigo_usuario", nullable = false)
    private Integer codigoUsuario;

    @Column(name = "tipo_usuario_codigo", nullable = false)
    private Integer tipoUsuario;


    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPK usuarioPK = (UsuarioPK) o;
        return Objects.equals(codigoUsuario, usuarioPK.codigoUsuario) &&
                Objects.equals(tipoUsuario, usuarioPK.tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUsuario, tipoUsuario);
    }
}
