package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tbusuario")
public class Usuario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "usuario", targetEntity = Telefone.class)
    private Set<Telefone> telefone;


    /*@Size(max = 11,min = 4)
    @Column(name = "ctelefone")
    private String telefone;*/

    @Size()
    @Column(name = "usu_cl_senha")
    private String senha;

    @Size(max = 11,min = 11)
    @Column(name = "usu_cl_cpf", nullable = false)
    private String cpf;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_logradouro", nullable = false)
    private String logradouro;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_cep", nullable = false)
    private String cep;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_ estado", nullable = false)
    private String estado;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_cidade", nullable = false)
    private String cidade;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_bairro", nullable = false)
    private String bairro;

    @Size(max = 100,min = 10)
    @Column(name = "usu_cl_complemento", nullable = false)
    private String complemento;


    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(telefone, usuario.telefone) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(cpf, usuario.cpf) &&
                Objects.equals(logradouro, usuario.logradouro) &&
                Objects.equals(cep, usuario.cep) &&
                Objects.equals(estado, usuario.estado) &&
                Objects.equals(cidade, usuario.cidade) &&
                Objects.equals(bairro, usuario.bairro) &&
                Objects.equals(complemento, usuario.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, telefone, senha, cpf, logradouro, cep, estado, cidade, bairro, complemento);
    }
}
