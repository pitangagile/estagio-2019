package biblioteca.model.Alunos;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


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

    @ManyToOne
    @JoinColumn(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    @OneToMany
    @JoinColumn(name = "usuario_has_atividade")
    private Set<UsuarioHasAtividade> usuarioHasAtividades;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equal(codigoUsuario, usuario.codigoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoUsuario);
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public long getTipoUsuarioCodigo() {
        return tipoUsuarioCodigo;
    }

    public void setTipoUsuarioCodigo(long tipoUsuarioCodigo) {
        this.tipoUsuarioCodigo = tipoUsuarioCodigo;
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
