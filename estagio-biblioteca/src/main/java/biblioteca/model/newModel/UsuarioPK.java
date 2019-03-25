package biblioteca.model.newModel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UsuarioPK implements Serializable {

    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @ManyToOne
    @JoinColumn(name = "codigo_tipousuario", referencedColumnName = "id")
    private TipoUsuario codigoTipoUsuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioPK usuarioPK = (UsuarioPK) o;

        if (codigoUsuario != null ? !codigoUsuario.equals(usuarioPK.codigoUsuario) : usuarioPK.codigoUsuario != null)
            return false;
        return codigoTipoUsuario != null ? codigoTipoUsuario.equals(usuarioPK.codigoTipoUsuario) : usuarioPK.codigoTipoUsuario == null;
    }

    @Override
    public int hashCode() {
        int result = codigoUsuario != null ? codigoUsuario.hashCode() : 0;
        result = 31 * result + (codigoTipoUsuario != null ? codigoTipoUsuario.hashCode() : 0);
        return result;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public TipoUsuario getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(TipoUsuario codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }
}
