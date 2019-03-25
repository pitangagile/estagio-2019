package biblioteca.model.model2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioX implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_usuario;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario")
    private TipoUsuarioX tipo_usuario;

    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private List<UsuarioHasAtividade> usuarioHasAtividades;

    @Column(name = "tipo_user", nullable = false)
    private Integer tipo_user;

    @Size(min = 3, max = 50)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(min = 3, max = 100)
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "data_nasci", nullable = false)
    private String data_nasci;

    @Size(min = 3, max = 50)
    @Column(name = "login", nullable = false)
    private String login;

    @Size(min = 6, max = 50)
    @Column(name = "senha", nullable = false)
    private String senha;


    @Override
    public Integer getId() {
        return this.codigo_usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioX usuarioX = (UsuarioX) o;
        return Objects.equals(codigo_usuario, usuarioX.codigo_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_usuario);
    }
}
