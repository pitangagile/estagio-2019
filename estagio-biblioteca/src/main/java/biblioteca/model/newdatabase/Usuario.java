package biblioteca.model.newdatabase;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_usuario;

    @ManyToOne()
    private Tipo_Usuario tipo_usuario;

    @OneToMany()
    @JoinColumn(name = "usuario_atividade")
    private Set<Usuario_has_Atividade> usuario_has_atividades;


    @Column(name = "usu_cl_tipo_user")
    private Integer tipo_user;

    @Column(name = "usu_cl_nome")
    private String nome;

    @Column(name = "usu_cl_data_nasci")
    private String data_nasci;

    @Column(name = "usu_cl_login")
    private String login;

    @Column(name = "usu_cl_senha")
    private String senha;

    @Size(max = 100, min = 1)
    @Column(name = "usu_cl_logradouro", nullable = false)
    private String logradouro;

    @Size(max = 100, min = 1)
    @Column(name = "usu_cl_bairro", nullable = false)
    private String bairro;

    @Size(max = 100, min = 1)
    @Column(name = "usu_cl_cidade", nullable = false)
    private String cidade;

    @Size(max = 100, min = 1)
    @Column(name = "usu_cl_estado", nullable = false)
    private String estado;

    @Size(max = 8, min = 8)
    @Column(name = "usu_cl_cep", length = 8, nullable = false)
    private String cep;

    @Size(max = 100, min = 1)
    @Column(name = "usu_cl_complemento")
    private String complemento;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codigo_usuario, usuario.codigo_usuario) &&
                Objects.equals(tipo_usuario, usuario.tipo_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_usuario, tipo_usuario);
    }

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public Tipo_Usuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Tipo_Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Set<Usuario_has_Atividade> getUsuario_has_atividades() {
        return usuario_has_atividades;
    }

    public void setUsuario_has_atividades(Set<Usuario_has_Atividade> usuario_has_atividades) {
        this.usuario_has_atividades = usuario_has_atividades;
    }

    public Integer getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(Integer tipo_user) {
        this.tipo_user = tipo_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
