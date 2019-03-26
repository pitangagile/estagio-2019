package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

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



    @OneToMany(mappedBy = "acervo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AcervoLivro> acervoLivro;


    @Override
    public Long getId() {
        return this.id;
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
}
