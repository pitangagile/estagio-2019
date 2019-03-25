package biblioteca.model.Alunos;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

//Código da tabela "usuario"
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoUsuario;

    @Column(name = "tipo_usuario_codigo")
    private long tipoUsuarioCodigo;

    @Column(name = "tipo_user")
    private long tipoUser;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "data_nasci")
    private String dataNasci;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    //Relacionamento de muitos para um entre usuario e um tipo de usuario
    @ManyToOne
    @JoinColumn(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    //Relacionamento de um para muitos entre um usuario e a tabela de relacionamento de usuario e atividade
    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private Set<UsuarioHasAtividade> usuarioHasAtividades;

}
