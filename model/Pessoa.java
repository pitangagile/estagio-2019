package biblioteca.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 150,min = 2)
    @Column(name = "usu_cl_nome",nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.DETACH, orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = Telefone.class, mappedBy = "usuario")
    private Set<Telefone> telefone;

    @Size(max = 40,min = 3)
    @Email( message = "o email deve ser válido")
    @Column(name = "usu_cl_email", nullable = false)
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<Telefone> telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(telefone, pessoa.telefone) &&
                Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone, email);
    }
}
