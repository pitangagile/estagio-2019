package biblioteca.model.modelagem2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsuarioHasAtividade implements Serializable {

    private Integer usuarioTipoUsuarioCodigo;

    private Integer usuarioCodigoUsuario;

    private Integer atividadeCodigoAtividade;


}
