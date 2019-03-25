package biblioteca.model.newModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descicao;

    @OneToMany(mappedBy = "usuarioPK.codigoTipoUsuario")
    private Set<Usuario> usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUsuario that = (TipoUsuario) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    @Override
    public Long getId() {
        return null;
    }
}
