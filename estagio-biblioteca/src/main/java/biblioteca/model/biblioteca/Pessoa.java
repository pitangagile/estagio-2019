package biblioteca.model.biblioteca;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
//@DiscriminatorValue("P")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "tipoPessoa", length = 1, discriminatorType = DiscriminatorType.CHAR)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Telefone.class, mappedBy = "usuario")
    private Set<Telefone> telefones;

    @Size(max = 40,min = 3)
    @Email(message = "Email invalido")
    @Column(name = "usu_cl_email", nullable = false)
    private String email;


}
