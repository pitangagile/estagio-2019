package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;


//@Entity //no caso de criar uma coluna grande representando a classe abstrata contendo todos os filhos concretos juntos
//@DiscriminatorValue("U")

//@Entity //abordagem de fazer tabelas para classes abstratas e classes concretas
//@PrimaryKeyJoinColumn(name = "id")

@Entity //abordagem de implementar apenas as tabelas das classes concretas
@Table(name = "tbusuario")
public class Usuario extends Pessoa {
    @Size(max = 11, min = 11)
    @Column(name = "usu_cl_cpf",nullable = false, length = 11)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = Endereco.class, mappedBy = "usuario") //usuário tem só um endereço
    private Endereco endereco;

    @OneToMany(targetEntity = Emprestimo.class, mappedBy = "usuario")
    private Set<Emprestimo> emprestimo;
}
