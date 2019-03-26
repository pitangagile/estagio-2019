package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;


@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioHasAtividade implements IObjectPersistent<UsuarioHasAtividadePK> {

    
    @EmbeddedId
    private UsuarioHasAtividadePK usuarioHasAtividadePK;

    
    @MapsId("codigoUsuario")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario",insertable = false,updatable = false)
    Usuario usuario;

    
    @MapsId("codigoTipoUsuario")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false, updatable = false)
    Usuario usuario1;

    
    @MapsId("codigoAtividade")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    Atividade atividade;

    @Override
    public UsuarioHasAtividadePK getId() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasAtividade that = (UsuarioHasAtividade) o;
        return Objects.equal(usuarioHasAtividadePK, that.usuarioHasAtividadePK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuarioHasAtividadePK);
}

}
