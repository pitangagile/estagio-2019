package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Map;

//tabela de rendimento de alunos, que representa o relacionamento entre usuario e atividade
@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<RendimentoAlunoPK> {

    //utilização da classe embarcável "RendimentoAlunoPK" para geração de chave composta
    @EmbeddedId
    private RendimentoAlunoPK rendimentoAlunoPK;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e uma atividade
    @MapsId("codigoAtividade")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    private Atividade atividade;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e um usuário
    @MapsId("codigoTipoUsuario")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false,updatable = false)
    private Usuario usuario;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e um usuário
    @MapsId("usuario_codigo_usuario")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo_usuario",insertable = false, updatable = false)
    private Usuario usuario1;

    @Column(name = "codigo_aluno")
    private long codigoAluno;

    @Column(name = "codigo_atividade")
    private long codigoAtividade;

    @Column(name = "data_2")
    private  long data2;

    @Column(name = "rendimento")
    private long rendimento;

    @Override
    public RendimentoAlunoPK getId() {
        return null;
    }

}
