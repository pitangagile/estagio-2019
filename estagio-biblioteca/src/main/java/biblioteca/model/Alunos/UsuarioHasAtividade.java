package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

//Tabela para representação de relacionamento entre atividade e usuario
@Entity
@Table(name = "usuario_has_atividade")
public class UsuarioHasAtividade implements IObjectPersistent<UsuarioHasAtividadePK> {

    //utilização de classe embarcável para geração de chave composta para a tabela
    @EmbeddedId
    private UsuarioHasAtividadePK usuarioHasAtividadePK;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e um usuario
    @MapsId("codigoUsuario")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario",insertable = false,updatable = false)
    Usuario usuario;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e um usuario
    @MapsId("codigoTipoUsuario")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false, updatable = false)
    Usuario usuario1;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e uma atividade
    @MapsId("codigoAtividade")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    Atividade atividade;

    @Override
    public UsuarioHasAtividadePK getId() {
        return null;
    }
}
