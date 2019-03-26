package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_livro")
public class Livro implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liv_cl_id")
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

    @ManyToMany(mappedBy = "livros")
    private Set<Escritor> escritor;

    @ManyToMany(mappedBy = "livro", fetch = FetchType.EAGER)
    private Set<Emprestimo> emprestimo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AcervoLivro> acervoLivro;

    @ManyToOne
    private Compra compra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) &&
                Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo);
    }

    @Override
    public Long getId() {
        return this.id;
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

    public Set<Escritor> getEscritor() {
        return escritor;
    }

    public void setEscritor(Set<Escritor> escritor) {
        this.escritor = escritor;
    }

    public Set<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Set<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Set<AcervoLivro> getAcervoLivro() {
        return acervoLivro;
    }

    public void setAcervoLivro(Set<AcervoLivro> acervoLivro) {
        this.acervoLivro = acervoLivro;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

}
