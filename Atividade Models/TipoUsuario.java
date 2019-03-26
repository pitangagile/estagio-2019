package biblioteca.model.Atividades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, min = 2)
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Usuario.class, mappedBy = "tipo_usuario")
    private Set<Usuario> usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUsuario that = (TipoUsuario) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return descricao != null ? descricao.equals(that.descricao) : that.descricao == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
