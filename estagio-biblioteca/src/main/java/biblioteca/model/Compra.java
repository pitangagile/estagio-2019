package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_compra")
public class Compra implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, targetEntity = Livro.class, mappedBy = "compra")
    private Set<Livro> livros;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER, targetEntity = Fornecedor.class, mappedBy = "compra")
    private Fornecedor fornecedor;

    @Column(name = "comp_cl_valor")
    private Double valor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id) &&
                Objects.equals(livros, compra.livros) &&
                Objects.equals(fornecedor, compra.fornecedor) &&
                Objects.equals(valor, compra.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, livros, fornecedor, valor);
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
