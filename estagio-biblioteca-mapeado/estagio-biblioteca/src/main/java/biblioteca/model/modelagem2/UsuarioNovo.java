package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.modelagem1.AcervoLivro;
import biblioteca.model.modelagem1.Endereco;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "tb_usuario_novo")
public class UsuarioNovo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoUsuario;

    @JoinColumn(name = "usuario_codigo_usuario")
    @JoinTable(name = "tb_usuario_has_atividade",
            joinColumns = @JoinColumn(name = "usuario_codigo_usuario"),
            inverseJoinColumns = @JoinColumn(name = "atividade_codigo_atividade"))
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Atividade.class)
    private Set<Atividade> atividade;

    @Size(min = 30, max = 100)
    @Column(name = "tipo_user")
    private Integer tipoUser;

    @Size(min = 30, max = 100)
    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "endereco")
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Endereco.class)
    private Endereco endereco;

    @Size(min = 8, max = 8)
    @Column(name = "data_nasci")
    private String dataNasc;

    @Size(min = 10, max = 30)
    @Column(name = "login")
    private String login;

    @Size(min = 6, max = 8)
    @Column(name = "senha")
    private String senha;

    @Override
    public Long getId() {
        return null;
    }


}
