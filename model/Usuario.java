package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 11,max = 11)
    @Column(name = "usu_cl_cpf")
    private String cpf;


    @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = Endereco.class, mappedBy = "usuario")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, targetEntity = Emprestimo.class, mappedBy = "usuario")
    private Set<Emprestimo> emprestimo;

    public Usuario() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

}
