package biblioteca.model.atividade;

import javax.persistence.*;

@Entity
@Table(name = "atividade_has_palavra")
public class atividade_has_palavra {


    @EmbeddedId
    private atividade_has_palavra_PK atividade_has_palavra_pk;
}
