package biblioteca.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "tb_usuario")
@Getter @Setter
public class Usuario extends Pessoa {

    @Size(max = 11, min = 11)
    @Column(name = "usr_cl_cpf", length = 11)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Emprestimo.class, mappedBy = "usuario")
    private Set<Emprestimo> emprestimo;

    public Usuario() {
    }

}
