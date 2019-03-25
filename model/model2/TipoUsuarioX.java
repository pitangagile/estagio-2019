package biblioteca.model.model2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuarioX implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_tipo_usuario;

    @Size(min = 3, max = 50)
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tipo_usuario", targetEntity = UsuarioX.class, fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<UsuarioX> usuarioXSet;

    @Override
    public Integer getId() {
        return null;
    }
}
