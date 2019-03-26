package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Map;


@Entity
@Table(name = "rendimento_aluno")
public class RendimentoAluno implements IObjectPersistent<RendimentoAlunoPK> {

    //chave composta
    @EmbeddedId
    private RendimentoAlunoPK rendimentoAlunoPK;

    
    @MapsId("codigoAtividade")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    private Atividade atividade;

    
    @MapsId("codigoTipoUsuario")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_tipo_usuario_codigo",insertable = false,updatable = false)
    private Usuario usuario;

    
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
    
   

    public void setRendimentoAlunoPK(RendimentoAlunoPK rendimentoAlunoPK) {
        this.rendimentoAlunoPK = rendimentoAlunoPK;
    }

    public Long getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Long codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public Long getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Long codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Long getData2() {
        return data2;
    }

    public void setData2(Long data2) {
        this.data2 = data2;
    }

    public Long getRendimento() {
        return rendimento;
    }

    public void setRendimento(Long rendimento) {
        this.rendimento = rendimento;
    }
}

}
