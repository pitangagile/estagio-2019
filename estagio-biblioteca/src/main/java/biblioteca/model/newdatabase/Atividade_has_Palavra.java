package biblioteca.model.newdatabase;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_atividade_has_palavra")
public class Atividade_has_Palavra implements IObjectPersistent<AtividadeHasPalavraPK> {

    @EmbeddedId
    private AtividadeHasPalavraPK atividadeHasPalavraPK;

    @MapsId("atividadeId")
    @JoinColumn(name = "atividadeId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Atividade atividade;

    @MapsId("palavraId")
    @JoinColumn(name = "palavraId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Palavra palavra;


    @Override
    public AtividadeHasPalavraPK getId() {
        return this.atividadeHasPalavraPK;
    }


}
