package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_NEW_Palavra")
@Getter @Setter
public class NEW_Palavra implements IObjectPersistent<NEW_Palavra> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plvr_cl_id")
    private Integer codigo_palavra;

    @Column(name = "plvr_cl_palavra")
    private String palavra;

    @Column(name = "plvr_cl_figura")
    private String figura;

    @Column(name = "plvr_cl_pala_Separada")
    private String pala_separada;

    @Size(max = 1, min = 1)
    @Column(name = "plvr_cl_letra_ini", length = 1)
    private String letra_ini;

    @Size(max = 1, min = 1)
    @Column(name = "plvr_cl_letra_final", length = 1)
    private String letra_final;

    @Size(max = 1, min = 1)
    @Column(name = "plvr_cl_maius_ini", length = 1)
    private String maius_ini;

    @Size(max = 1, min = 1)
    @Column(name = "plvr_cl_minus_ini", length = 1)
    private String minus_ini;

    //NxN mapeada em atividades
    @ManyToMany(mappedBy = "new_palavras", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<NEW_Atividade> new_atividades;

    @Override
    public NEW_Palavra getId() {
        return null;
    }
}
