package biblioteca.model.atividade;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class atividade_has_palavra_PK implements Serializable {


    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private atividade atividade;

    @JoinColumn(name = "palavra_codigo_palavra", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private palavra palavra;
}
