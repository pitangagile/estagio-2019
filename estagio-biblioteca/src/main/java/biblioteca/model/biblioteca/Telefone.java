package biblioteca.model.biblioteca;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbtelefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 2, message = "O DDD deve ter um tamanho de dois digitos")
    @Column(name = "tel_cl_ddd")
    private String ddd;


    @Column(name = "tel_cl_numero")
    private String numero;


    @ManyToOne
    @JoinColumn(name = "usu_cl_telefone")
    private Usuario usuario;



}
