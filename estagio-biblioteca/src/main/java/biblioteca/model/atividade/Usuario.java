package biblioteca.model.atividade;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @EmbeddedId
    private UsuarioPK usuarioPK;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "tipo_usuario_codigo", referencedColumnName = "codigo",insertable = false, updatable = false)
    })
    private TipoUsuario tipoUsuario;


    @Size(max = 20,min = 1)
    @Column(name = "tipo_user", nullable = false)
    private Long tipoUser;

    @Size(max = 100,min = 2)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 150,min = 4)
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Size(max = 8,min = 8)
    @Column(name = "data_nasc", nullable = false)
    private String dataNasc;

    @Size(max = 15,min = 4)
    @Column(name = "login", nullable = false)
    private String login;

    @Size(max = 15,min = 8)
    @Column(name = "senha", nullable = false)
    private String senha;

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Long getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(Long tipoUser) {
        this.tipoUser = tipoUser;
    }

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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioPK, usuario.usuarioPK) &&
                Objects.equals(tipoUsuario, usuario.tipoUsuario) &&
                Objects.equals(tipoUser, usuario.tipoUser) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(endereco, usuario.endereco) &&
                Objects.equals(dataNasc, usuario.dataNasc) &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioPK, tipoUsuario, tipoUser, nome, endereco, dataNasc, login, senha);
    }
}
