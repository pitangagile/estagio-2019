package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.modelagem1.Telefone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_tipousuario")
public class TipoUsuario implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 50, max = 150)
    @Column(name = "descricao")
    private String descricao;

    @JoinColumn(name = "tipo_usuario_codigo")
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = UsuarioNovo.class)
    private Set<UsuarioNovo> usuarioNovo;

    @Override
    public Long getId() {
        return null;
    }
}
