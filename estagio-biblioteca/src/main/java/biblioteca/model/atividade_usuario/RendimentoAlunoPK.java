package biblioteca.model.atividade_usuario;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RendimentoAlunoPK implements Serializable {

    @Column(name = "atividade_codigo_atividade", nullable = false)
    private long atividadeCodigoAtividade;

    @Column(name = "usuario_tipo_usuario_codigo", nullable = false)
    private long usuarioTipoUsuarioCodigo;

    @Column(name = "usuario_codigo_usuario", nullable = false)
    private long usuarioCodigoUsuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendimentoAlunoPK that = (RendimentoAlunoPK) o;
        return atividadeCodigoAtividade == that.atividadeCodigoAtividade &&
                usuarioTipoUsuarioCodigo == that.usuarioTipoUsuarioCodigo &&
                usuarioCodigoUsuario == that.usuarioCodigoUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividadeCodigoAtividade, usuarioTipoUsuarioCodigo, usuarioCodigoUsuario);
    }

    public long getAtividadeCodigoAtividade() {
        return atividadeCodigoAtividade;
    }

    public void setAtividadeCodigoAtividade(long atividadeCodigoAtividade) {
        this.atividadeCodigoAtividade = atividadeCodigoAtividade;
    }

    public long getUsuarioTipoUsuarioCodigo() {
        return usuarioTipoUsuarioCodigo;
    }

    public void setUsuarioTipoUsuarioCodigo(long usuarioTipoUsuarioCodigo) {
        this.usuarioTipoUsuarioCodigo = usuarioTipoUsuarioCodigo;
    }

    public long getUsuarioCodigoUsuario() {
        return usuarioCodigoUsuario;
    }

    public void setUsuarioCodigoUsuario(long usuarioCodigoUsuario) {
        this.usuarioCodigoUsuario = usuarioCodigoUsuario;
    }
}
