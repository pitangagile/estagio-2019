package biblioteca.model.escola;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "esc_usuario")
public class Usuario implements IObjectPersistent<UsuarioPK> {


    /*
    @Id
    @Column(name = "codigo_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoUsuario;
    */

    @EmbeddedId
    private UsuarioPK usuarioPK;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_usuario_codigo",insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;


    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "data_nasci")
    private String dataNascimento;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
    private Set<UsuarioAtividade> usuarioAtividade;




    public void setCodigoUsuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    /*
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public UsuarioPK getId() {
        return usuarioPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioPK, usuario.usuarioPK) &&
                Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioPK, nome);
    }
}
