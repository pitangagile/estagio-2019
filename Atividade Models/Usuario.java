package biblioteca.model.Atividades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    /*@Id
    @Column(name="codigo_usuario", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @EmbeddedId
    UsuarioTipoPK usuarioTipoPK;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_codigo")
    private TipoUsuario tipoUsuario;

    @Column(name = "tipo_user")
    private int tipoUser;

    @Size(max = 50, min = 2)
    @Column(name = "nome",nullable = false)
    private String nome;

    @Size(max = 100, min = 2)
    @Column(name = "endereco")
    private String endereco;

    @Size(max = 15, min = 6)
    @Column(name = "data_nasci")
    private String dataNasci;

    @Size(max = 50, min = 2)
    @Column(name = "login",nullable = false)
    private String login;

    @Size(max = 50, min = 2)
    @Column(name = "senha",nullable = false)
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id != null ? id.equals(usuario.id) : usuario.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
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

    public String getDataNasci() {
        return dataNasci;
    }

    public void setDataNasci(String dataNasci) {
        this.dataNasci = dataNasci;
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
}
