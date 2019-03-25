package biblioteca.model;

import io.swagger.models.auth.In;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class NEW_Tipo_usuarioPK implements Serializable {

    @Column(name = "New_Tipo_usuario")
    private Integer new_tipo_usuario;
}
