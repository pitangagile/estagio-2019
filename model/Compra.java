package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_compra")
public class Compra implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name="livros_da_compra", joinColumns=
            {@JoinColumn(name="compra_id")}, inverseJoinColumns=
            {@JoinColumn(name="livro_id")})
    private List<Livro> livros;

    @Column(name = "com_cl_valor")
    private Float valor;

    @Override
    public Long getId() {
        return null;
    }
}
