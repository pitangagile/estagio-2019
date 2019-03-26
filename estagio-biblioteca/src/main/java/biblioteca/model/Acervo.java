package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_acervo", schema = "biblioteca")
public class Acervo implements IObjectPersistent<Long> {

    @OneToMany(mappedBy = "acervos", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcervoLivro> acervoLivro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ace_cl_nome")
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acervo acervo = (Acervo) o;
        return Objects.equals(acervoLivro, acervo.acervoLivro) &&
                Objects.equals(id, acervo.id) &&
                Objects.equals(nome, acervo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acervoLivro, id, nome);
    }

    public Set<AcervoLivro> getAcervoLivro() {
        return acervoLivro;
    }

    public void setAcervoLivro(Set<AcervoLivro> acervoLivro) {
        this.acervoLivro = acervoLivro;
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

    @Override
    public Long getId() {
        return this.id;
    }
}
