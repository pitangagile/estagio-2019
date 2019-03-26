package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_palavra")
public class Palavra implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPalavra;

    @Size(min = 30, max = 50)
    @Column(name = "pal_cl_palavra")
    private String palavra;

    @Size(min = 50, max = 100)
    @Column(name = "pal_cl_figura")
    private String figura;

    @Size(min = 10, max = 30)
    @Column(name = "pal_cl_pala_separada")
    private String palaSeparada;

    @Size(min = 1, max = 1)
    @Column(name = "pal_cl_letra_ini")
    private Character letraInicial;

    @Size(min = 1, max = 1)
    @Column(name = "pal_cl_letra_final")
    private Character letraFinal;

    @Size(min = 1, max = 1)
    @Column(name = "pal_cl_maius_ini")
    private Character maiusInicial;

    @Size(min = 1, max = 1)
    @Column(name = "pal_cl_minus_ini")
    private Character minusInicial;

    @ManyToMany(mappedBy = "palavra")
    private Set<Atividade> atividade;

    @Override
    public Long getId() {
        return null;
    }
}
