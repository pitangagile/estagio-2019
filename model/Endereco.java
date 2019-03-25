package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbendereco")
public class Endereco implements IObjectPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "end_cl_usuario")
    private Usuario usuario;

    @Size(max = 200,min = 2)
    @Column(name = "end_cl_logadouro", nullable = false)
    private String logadouro;

    @Size(max = 100,min = 2)
    @Column(name = "end_cl_bairro", nullable = false)
    private String bairro;

    @Size(max = 100,min = 2)
    @Column(name = "end_cl_cidade", nullable = false)
    private String cidade;

    @Size(max = 100,min = 2)
    @Column(name = "end_cl_estado", nullable = false)
    private String estado;

    @Size(max = 200,min = 2)
    @Column(name = "end_cl_complemento", nullable = false)
    private String complemento;
    @Override
    public Object getId() {
        return this.id;
    }
}
