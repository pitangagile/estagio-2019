package biblioteca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_acervo")
public class Acervo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prod_cl_quantidade")
    private Integer quantidade;


    /*@JoinTable(name = "tb_livroacervo",
    joinColumns = @JoinColumn(name = "liv_cl_id"),
    inverseJoinColumns = @JoinColumn(name = "ace_cl_id"))*/
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AcervoLivro> livros;

    @Column(name = "prod_cl_preco")
    private double preco;








}
