package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

//Tabela de relacionamento entre atividade e palavra
@Entity
@Table(name = "atividade_has_palavra")
public class AtividadeHasPalavra implements IObjectPersistent<AtividadeHasPalavraPK> {

    //classe embarcável utilizada para representar a chave composta da tabela
    @EmbeddedId
    private AtividadeHasPalavraPK atividadeHasPalavraPK;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e uma atividade
    @MapsId("atividade")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade",nullable = false,updatable = false)
    private Atividade atividade;

    //Mapeando id da classe embarcável e fazendo relacionamento de muitos para um
    // entre os elementos da tabela e uma palavra
    @MapsId("palavra")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "palavra_codigo_palavra",nullable = false,updatable = false)
    private Palavra palavra;

    @Override
    public AtividadeHasPalavraPK getId() {
        return null;
    }
}
