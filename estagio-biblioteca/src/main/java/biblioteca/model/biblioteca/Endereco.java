package biblioteca.model.biblioteca;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbendereco")
public class Endereco implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

    @Size(min = 7,max = 7)
    private String cep;

    @OneToOne
    @JoinColumn(name = "end_cl_usuario")
    private Usuario usuario;


    @Override
    public Long getId() {
        return this.id;
    }
}
