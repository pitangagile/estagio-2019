package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario implements IObjectPersistent {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_usuario")
    private Set<Usuario> usuarios;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Size
    @Column(name = "tiu_cl_descricao")
    private String descricao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoUsuario that = (TipoUsuario) o;
        return codigo == that.codigo &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao);
    }

    @Override
    public Object getId() {
        return null;
    }
}
