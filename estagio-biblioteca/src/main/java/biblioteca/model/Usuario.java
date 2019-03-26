package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "tb_usuario",schema = "biblioteca")
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "usuario", targetEntity = Telefone.class)
    private Set<Telefone> telefone;

    @Size(max = 11,min = 11)
    @Column(name = "usu_cl_cpf", nullable = false)
    private String cpf;

    @OneToOne()
    private Endereco endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equal(id, usuario.id) &&
                Objects.equal(telefone, usuario.telefone) &&
                Objects.equal(cpf, usuario.cpf) &&
                Objects.equal(endereco, usuario.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), id, telefone, cpf, endereco);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Set<Telefone> getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(Set<Telefone> telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
