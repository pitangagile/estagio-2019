package biblioteca.model.atividade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioAtividade {

    @EmbeddedId
    private UsuarioAtividadePK usuarioAtividadePK;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "usuario_codigo_usuario", referencedColumnName = "codigo_usuario", insertable = false, updatable = false),
            @JoinColumn(name = "usuario_tipo_usuario_codigo", referencedColumnName = "tipo_usuario_codigo", insertable = false, updatable = false)
    })
    private Usuario usuario;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "atividade_codigo_atividade", referencedColumnName = "codigo_atividade", insertable = false, updatable = false)
    })
    private Atividade atividade;

    public UsuarioAtividadePK getUsuarioAtividadePK() {
        return usuarioAtividadePK;
    }

    public void setUsuarioAtividadePK(UsuarioAtividadePK usuarioAtividadePK) {
        this.usuarioAtividadePK = usuarioAtividadePK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAtividade that = (UsuarioAtividade) o;
        return Objects.equals(usuarioAtividadePK, that.usuarioAtividadePK) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(atividade, that.atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioAtividadePK, usuario, atividade);
    }
}
