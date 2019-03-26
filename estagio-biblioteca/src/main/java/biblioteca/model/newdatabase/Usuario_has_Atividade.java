package biblioteca.model.newdatabase;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario_has_atividade")
public class Usuario_has_Atividade implements IObjectPersistent<UsuarioHasAtividadePK> {

    @EmbeddedId
    private UsuarioHasAtividadePK usuarioHasAtividadePK;

    @MapsId("usuarioId")
    @JoinColumn(name = "usuarioId")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuario;

    @MapsId("atividadeId")
    @JoinColumn(name = "atividadeId")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Atividade atividade;


    @MapsId("tipo_usuarioId")
    @JoinColumn(name = "tipo_usuarioId")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Tipo_Usuario tipo_usuario;


    @Override
    public UsuarioHasAtividadePK getId() {
        return this.usuarioHasAtividadePK;
    }
}
