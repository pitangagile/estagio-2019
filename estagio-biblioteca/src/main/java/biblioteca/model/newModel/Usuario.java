package biblioteca.model.newModel;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements IObjectPersistent<Long> {

    @EmbeddedId
    private UsuarioPK usuarioPK;

    @OneToMany(mappedBy = "id.codigoUsuario")
    private Set<Usuario_has_Atividade> usuarioAtividade;

    @OneToMany(mappedBy = "usuario")
    private Set<RendimentoAluno> rendimentoAluno;

    @Column(name = "tipo_user")
    private Integer tipo_usuario;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return usuarioPK != null ? usuarioPK.equals(usuario.usuarioPK) : usuario.usuarioPK == null;
    }

    @Override
    public int hashCode() {
        return usuarioPK != null ? usuarioPK.hashCode() : 0;
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Integer getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Integer tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
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
    public Long getId() {
        return null;
    }
}
