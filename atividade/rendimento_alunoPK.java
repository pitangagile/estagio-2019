package biblioteca.model.atividade;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class rendimento_alunoPK implements Serializable {

    @JoinColumn(name = "atividade_codigo_atividade", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private atividade atividade;

    @JoinColumn(name = "usuario_tipo_usuario_codigo", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private tipo_usuario tipo_usuario;

    @JoinColumn(name = "usuario_codigo_usuario", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private usuario usuario;

}
