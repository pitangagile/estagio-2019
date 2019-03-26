package biblioteca.model.atividade;


import com.google.common.base.Objects;

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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usuario usuario = (usuario) o;
        return Objects.equal(codigo_usuario, usuario.codigo_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo_usuario);
    }

    public Long getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Long codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public tipo_usuario getTipo_usuario_codigo() {
        return tipo_usuario_codigo;
    }

    public void setTipo_usuario_codigo(tipo_usuario tipo_usuario_codigo) {
        this.tipo_usuario_codigo = tipo_usuario_codigo;
    }

    public Long getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(Long tipo_user) {
        this.tipo_user = tipo_user;
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

    public String getData_nasci() {
        return data_nasci;
    }

    public void setData_nasci(String data_nasci) {
        this.data_nasci = data_nasci;
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
