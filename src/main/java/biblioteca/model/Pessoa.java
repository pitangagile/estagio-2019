package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
//@DiscriminatorValue("P")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="tipo",discriminatorType = DiscriminatorType.STRING, length = 1)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements IObjectPersistent<Long> {

  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY, targetEntity = Telefone.class, mappedBy = "usuario")
  private Set<Telefone> telefone;

  @Column(name = "pes_cl_nome")
  private String nome;

  @Size(max = 40,min = 3)
  @Email(message = "Email inválido")
  @Column(name = "pes_cl_email",nullable = false)
  private String email;

  @Column(name = "pes_cl_tipo",insertable = false, updatable = false)
  private Character tipo;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pessoa pessoa = (Pessoa) o;

    if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) return false;
    return nome != null ? nome.equals(pessoa.nome) : pessoa.nome == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    return result;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Telefone> getTelefone() {
    return telefone;
  }

  public void setTelefone(Set<Telefone> telefone) {
    this.telefone = telefone;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Character getTipo() {
    return tipo;
  }

  public void setTipo(Character tipo) {
    this.tipo = tipo;
  }
}

