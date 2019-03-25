package biblioteca.model.atividade;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_usuario;

    @JoinColumn(name = "tipo_usuario_codigo", insertable = false, updatable = false, nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private tipo_usuario tipo_usuario_codigo;


    @Size()
    @Column(name = "tipo_user")
    private Long tipo_user;

    @Size()
    @Column(name = "nome")
    private String nome;

    @Size()
    @Column(name = "endereco")
    private String endereco;

    @Size()
    @Column(name = "data_nasci")
    private String data_nasci;

    @Size()
    @Column(name = "login")
    private String login;

    @Size()
    @Column(name = "senha")
    private String senha;


}
