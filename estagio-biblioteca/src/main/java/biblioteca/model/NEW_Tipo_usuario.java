package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_NEW_Tipo_usuario")
@Getter @Setter
public class NEW_Tipo_usuario implements IObjectPersistent<NEW_Tipo_usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name = "tpu_cl_descricao", nullable = false)
    private String descricao;

    @Override
    public NEW_Tipo_usuario getId() {
        return null;
    }
}
