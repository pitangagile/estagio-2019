package biblioteca.model.Alunos;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

//Tabela de relacionamento entre atividade e palavra
@Entity
@Table(name = "atividade_has_palavra")
public class AtividadeHasPalavra implements IObjectPersistent<AtividadeHasPalavraPK> {

    
    @EmbeddedId
    private AtividadeHasPalavraPK atividadeHasPalavraPK;

    @MapsId("atividade")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_codigo_atividade",nullable = false,updatable = false)
    private Atividade atividade;

  
    @MapsId("palavra")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "palavra_codigo_palavra",nullable = false,updatable = false)
    private Palavra palavra;

    
    @Override
    public int hashCode() {
        return Objects.hashCode(atividade_has_palavra_pk);
}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeHasPalavra atividade = (AtividadeHasPalavra) o;
return Objects.equal(atividadeHasPalavraPk, atividade.atividadeHasPalavraPk);
}
    
    public AtividadeHasPalavraPK getAtividadeHasPalavra_pk() {
        return atividadeHasPalavraPk;
    }

    public void setAtividadeHasPalavraPk(AtividadeHasPalavraPK atividadeHasPalavraPk) {
        this.atividadeHasPalavraPK = atividadeHasPalavraPK;
    }
}
