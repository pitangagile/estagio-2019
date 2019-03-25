package biblioteca.model.atividade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tipo_usuario")
public class tipo_usuario implements Serializable {

    @EmbeddedId
    private tipo_usuarioPK codigo;

    @Size
    @Column(name = "descricao")
    private String descricao;

}
