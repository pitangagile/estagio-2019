package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

//@Entity
//@DiscriminatorValue("P") //no caso de criar uma coluna grande representando a classe abstrata contendo todos os filhos concretos juntos
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.CHAR)

//@Entity //abordagem de fazer tabelas para classes abstratas e classes concretas
//@Inheritance(strategy = InheritanceType.JOINED)

@Entity //abordagem de implementar apenas as tabelas das classes concretas
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //com table_per_class a classe precisa ser abstrata obrigatoriamente
public abstract class Pessoa implements IObjectPersistent<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //não pode quando usa .TABLE_PER_CLASS
    private long id;

    @Size(max = 100, min = 3)
    @Column(name = "pes_cl_nome", nullable = false)
    private String nome;

    @Size(max = 40, min = 3) //size fica válido por cima do length
    @Email(message = "Email inválido")
    @Column(name = "pes_cl_email", nullable = false)
    private String email;

    //    @Size(max = 11, min = 8)
//    @Column(name = "telefone",unique = true)
//    @Embedded
//    @OverridesAttribute({@AttributeOverride(name = "numero",column = @Column(name = "usucltelefone"))}) //sobrescrever o nome da coluna
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = Telefone.class, mappedBy = "usuario") //um usuário pode ter vários telefones
    private Set<Telefone> telefone;

    //alterando a estratégia de representar a herança nas tabelas, mexe na existência dessa coluna
//    @Column(name = "pes_cl_tipo", insertable = false, updatable = false)
//    private Character tipo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != pessoa.id) return false;
        return nome != null ? nome.equals(pessoa.nome) : pessoa.nome == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<Telefone> telefone) {
        this.telefone = telefone;
    }

//    public Character getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(Character tipo) {
//        this.tipo = tipo;
//    }
}
