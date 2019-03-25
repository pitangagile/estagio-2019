package biblioteca.model.escola;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "esc_usuario_has_atividade")
public class UsuarioAtividade implements IObjectPersistent<UsuarioAtividadePK>{


    @EmbeddedId
    private UsuarioAtividadePK usuarioAtividadePK;

    @JoinColumns(value = {
            @JoinColumn(name =  "usuario_codigo_usuario", insertable = false, updatable = false),
            @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
    },foreignKey = @ForeignKey(name = "FK_ATIVIDADE_USER"))
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("atividade_codigo_atividade")
    @JoinColumn(name = "atividade_codigo_atividade")
    private Atividade atividade;


    @Override
    public UsuarioAtividadePK getId() {
        return usuarioAtividadePK;
    }
}
