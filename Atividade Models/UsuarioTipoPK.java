package biblioteca.model.Atividades;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UsuarioTipoPK implements Serializable {

    @Column(name = "codigo_usuario", nullable = false)
    private Long codigoUsuario;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_codigo", referencedColumnName = "tipo_usuario_codigo")
    private TipoUsuario tipoUsuarioCodigo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioTipoPK that = (UsuarioTipoPK) o;

        if (codigoUsuario != null ? !codigoUsuario.equals(that.codigoUsuario) : that.codigoUsuario != null)
            return false;
        return tipoUsuarioCodigo != null ? tipoUsuarioCodigo.equals(that.tipoUsuarioCodigo) : that.tipoUsuarioCodigo == null;
    }

    @Override
    public int hashCode() {
        int result = codigoUsuario != null ? codigoUsuario.hashCode() : 0;
        result = 31 * result + (tipoUsuarioCodigo != null ? tipoUsuarioCodigo.hashCode() : 0);
        return result;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public TipoUsuario getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public void setTipoUsuarioCodigo(TipoUsuario tipoUsuarioCodigo) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
    }
}
