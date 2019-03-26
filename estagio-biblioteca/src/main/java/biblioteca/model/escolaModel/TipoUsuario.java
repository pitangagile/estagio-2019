package biblioteca.model.escolaModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_tipoUsuario")
public class TipoUsuario implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_tipoUsuario;

    @Column(name = "tip_cl_descricao",nullable = false)
    private String descricao;

    /*Um tipo de usuario pode ter vários usuários*/
    @OneToMany(mappedBy = "usuarioTipoPK.codigo_usuario",cascade = CascadeType.ALL,orphanRemoval = false, targetEntity = Usuario.class)
    private Set<Usuario> usuarios;


    // Equals and hashcodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoUsuario that = (TipoUsuario) o;
        return Objects.equals(codigo_tipoUsuario, that.codigo_tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_tipoUsuario);
    }

    // Getters and setters

    public Integer getCodigo_tipoUsuario() {
        return codigo_tipoUsuario;
    }

    public void setCodigo_tipoUsuario(Integer codigo_tipoUsuario) {
        this.codigo_tipoUsuario = codigo_tipoUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Integer getId() {
        return this.codigo_tipoUsuario;
    }

    public Set<Usuario> getUsuarions() {
        return usuarios;
    }

    public void setUsuario(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
