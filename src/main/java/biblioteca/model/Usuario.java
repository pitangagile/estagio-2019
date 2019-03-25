package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
//@DiscriminatorValue("U")
//@PrimaryKeyJoinColumn(name = "id")
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {


  @Size(max = 11,min = 11)
  @Column(name = "usu_cl_cpf")
  private String cpf;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true,targetEntity = Endereço.class, mappedBy = "usuario")
  private Endereço endereco;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true,targetEntity = Emprestimo.class,mappedBy = "usuario")
  private Emprestimo emprestimo;


  @Override
  public Long getId() {
    return null;
  }
}
