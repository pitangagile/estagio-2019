package biblioteca.model.atividade;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "palavra")
public class palavra implements Serializable {

    @EmbeddedId
    private palavraPK codigo_palavra;

    @Size
    @Column(name = "palavra")
    private String palavra;

    @Size
    @Column(name = "figura")
    private String figura;

    @Size
    @Column(name = "pala_separada")
    private String pala_separada;

    @Size
    @Column(name = "letra_ini")
    private String letra_ini;

    @Size
    @Column(name = "letra_final")
    private String letra_final;

    @Size
    @Column(name = "maius_ini")
    private String maius_ini;

    @Size
    @Column(name = "minus_ini")
    private String minus_ini;


}
