package biblioteca.model.model2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioHasAtividade implements IObjectPersistent<UsuarioHasAtividadeId> {

    @EmbeddedId
    private UsuarioHasAtividadeId usuarioHasAtividadeId;

    @MapsId("codigoUsuario")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario",insertable = false,updatable = false)
    UsuarioX usuario;

    @MapsId("codigoTipoUsuario")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false, updatable = false)
    TipoUsuarioX tipo_usuario;

    @MapsId("codigoAtividade")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    Atividade atividade;

    @Override
    public UsuarioHasAtividadeId getId() {
        return null;
    }

    public UsuarioHasAtividadeId getUsuarioHasAtividadeId() {
        return usuarioHasAtividadeId;
    }

    public void setUsuarioHasAtividadeId(UsuarioHasAtividadeId usuarioHasAtividadeId) {
        this.usuarioHasAtividadeId = usuarioHasAtividadeId;
    }

    public UsuarioX getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioX usuario) {
        this.usuario = usuario;
    }

    public TipoUsuarioX getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuarioX tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
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
        UsuarioHasAtividade that = (UsuarioHasAtividade) o;
        return Objects.equals(usuarioHasAtividadeId, that.usuarioHasAtividadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioHasAtividadeId);
    }
}
