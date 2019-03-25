package biblioteca.model.atividade;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_has_atividade")
public class usuario_has_atividade implements Serializable {

    @EmbeddedId
    private usuario_has_atividadePK usuario_has_atividadePK;
}
