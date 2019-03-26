package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_acervo")
public class Acervo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ace_cl_nome")
    private String nome;

    @JoinColumn(name = "ace_cl_id")
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = AcervoLivro.class)
    private Set<AcervoLivro> acervoLivro;

    @Column(name = "ace_cl_quantidade")
    private int quantidade;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acervo acervo = (Acervo) o;
        return Objects.equal(id, acervo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    public Set<AcervoLivro> getAcervoLivro() {
        return acervoLivro;
    }

    public void setAcervoLivro(Set<AcervoLivro> acervoLivro) {
        this.acervoLivro = acervoLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}