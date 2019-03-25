package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name = "tbcompra")
public class Compra implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "com_cl_livro")
    private Livro livro;

    @Column(name = "com_cl_preco")
    private double preco;

    @Column(name = "com_cl_quantidade")
    private int quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compra compra = (Compra) o;

        return id == compra.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public Long getId() {
        return null;
    }
}
