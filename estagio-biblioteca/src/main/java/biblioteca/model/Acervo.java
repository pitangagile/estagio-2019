package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_acervo")
public class Acervo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "ace_cl_nome")
    private String nome;

    @OneToMany(mappedBy = "acervo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AcervoLivro> acervoLivro;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acervo acervo = (Acervo) o;
        return Objects.equals(Id, acervo.Id) &&
                Objects.equals(nome, acervo.nome) &&
                Objects.equals(acervoLivro, acervo.acervoLivro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, acervoLivro);
    }

    @Override
    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<AcervoLivro> getAcervoLivro() {
        return acervoLivro;
    }

    public void setAcervoLivro(Set<AcervoLivro> acervoLivro) {
        this.acervoLivro = acervoLivro;
    }


}
