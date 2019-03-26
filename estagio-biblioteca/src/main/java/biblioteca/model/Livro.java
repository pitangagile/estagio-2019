package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_livro", schema = "biblioteca")
public class Livro implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100,min = 2)
    @Column(name = "liv_cl_titulo",nullable = false)
    private String titulo;

    @Size(max = 100,min = 10)
    @Column(name = "liv_cl_sinopse")
    private String sinopse;

    @Size(max = 9,min = 4)
    @Column(name = "liv_cl_anolancamento")
    private String anoLancamento;

    @ManyToMany(mappedBy = "livros", fetch = FetchType.EAGER)
    private Set<Emprestimo> emprestimos;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AcervoLivro> acervoLivro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) &&
                Objects.equals(titulo, livro.titulo) &&
                Objects.equals(sinopse, livro.sinopse) &&
                Objects.equals(anoLancamento, livro.anoLancamento) &&
                Objects.equals(emprestimos, livro.emprestimos) &&
                Objects.equals(acervoLivro, livro.acervoLivro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, sinopse, anoLancamento, emprestimos, acervoLivro);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Set<AcervoLivro> getAcervoLivro() {
        return acervoLivro;
    }

    public void setAcervoLivro(Set<AcervoLivro> acervoLivro) {
        this.acervoLivro = acervoLivro;
    }
}
