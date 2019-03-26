package biblioteca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "usuario", targetEntity = Telefone.class)
    private Set<Telefone> telefone;

    @Size(max = 100,min = 2)
    @Column(name = "pes_cl_nome",nullable = false)
    private String nome;

    @Size(max = 40,min = 3)
    @Column(name = "pes_cl_email", nullable = false)
    private String email;

    @Column(name = "pes_cl_tipo", insertable = false, updatable = false)
    private Character tipo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
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
