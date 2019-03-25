package biblioteca.model.model2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<RendimentoAlunoId> {

    @EmbeddedId
    RendimentoAlunoId rendimentoAlunoId;

    @MapsId("atividade_codigo_atividade")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    private Atividade atividade;

    @MapsId("usuario_tipo_usuario_codigo")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false,updatable = false)
    private TipoUsuarioX usuario_tipo;

    @MapsId("usuario_codigo_usuario")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario",insertable = false, updatable = false)
    private UsuarioX usuario;

    @Column(name = "codigo_aluno")
    private Integer codigoAluno;

    @Column(name = "codigo_atividade")
    private Integer codigoAtividade;

    @Column(name = "data_2")
    private  Integer data_2;

    @Column(name = "rendimento")
    private Integer rendimento;

    @Override
    public RendimentoAlunoId getId() {
        return null;
    }
}
