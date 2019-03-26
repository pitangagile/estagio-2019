package biblioteca.model.atividade_usuario;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioTemAtividadePk implements Serializable {

    @Column(name = "usuario_codigo_usuario", nullable = false)
    private Long codigoUsuario;

    @Column(name = "usuario_tipo_usuario_codigo", nullable = false)
    private Long tipoUsuarioCodigo;

    @Column(name = "atividade_codigo_atividade", nullable = false)
    private Long codigoAtividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioTemAtividadePk that = (UsuarioTemAtividadePk) o;
        return Objects.equals(codigoUsuario, that.codigoUsuario) &&
                Objects.equals(tipoUsuarioCodigo, that.tipoUsuarioCodigo) &&
                Objects.equals(codigoAtividade, that.codigoAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUsuario, tipoUsuarioCodigo, codigoAtividade);
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Long getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public void setTipoUsuarioCodigo(Long tipoUsuarioCodigo) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
    }

    public Long getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Long codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }
}
