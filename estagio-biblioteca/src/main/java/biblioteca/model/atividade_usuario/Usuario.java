package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements IObjectPersistent<Long> {

    @ManyToOne
    @JoinColumn(name = "tipo_codigo_usuario")
    private TipoUsuario tipo_usuario;

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioTemAtividade> usuario_tem_atividades;

    @OneToMany(mappedBy = "usuario")
    private Set<RendimentoAluno> rendimentoAlunos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_usuario;

    @Column(name = "usu_cl_tipo_user")
    private int tipo_user;

    @Size(max = 20, min = 2)
    @Column(name = "usu_cl_nome")
    private String nome;

    @Size(max = 40, min = 3)
    @Column(name = "usu_cl_endereco")
    private String endereco;

    @Size(max = 8, min = 6)
    @Column(name = "usu_cl_data_nasci")
    private Date data_nasci;

    @Size(max = 20, min = 1)
    @Column(name = "usu_cl_login")
    private String login;

    @Size(max = 12, min = 6, message = "Senha com pelo menos 6 caracteres e no máximo 12.")
    @Column(name = "usu_cl_senha")
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return tipo_user == usuario.tipo_user &&
                Objects.equals(tipo_usuario, usuario.tipo_usuario) &&
                Objects.equals(usuario_tem_atividades, usuario.usuario_tem_atividades) &&
                Objects.equals(rendimentoAlunos, usuario.rendimentoAlunos) &&
                Objects.equals(codigo_usuario, usuario.codigo_usuario) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(endereco, usuario.endereco) &&
                Objects.equals(data_nasci, usuario.data_nasci) &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo_usuario, usuario_tem_atividades, rendimentoAlunos, codigo_usuario, tipo_user, nome, endereco, data_nasci, login, senha);
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Set<UsuarioTemAtividade> getUsuario_tem_atividades() {
        return usuario_tem_atividades;
    }

    public void setUsuario_tem_atividades(Set<UsuarioTemAtividade> usuario_tem_atividades) {
        this.usuario_tem_atividades = usuario_tem_atividades;
    }

    public Set<RendimentoAluno> getRendimentoAlunos() {
        return rendimentoAlunos;
    }

    public void setRendimentoAlunos(Set<RendimentoAluno> rendimentoAlunos) {
        this.rendimentoAlunos = rendimentoAlunos;
    }

    public Long getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Long codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
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

    public Date getData_nasci() {
        return data_nasci;
    }

    public void setData_nasci(Date data_nasci) {
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

    @Override
    public Long getId() {
        return this.codigo_usuario;
    }
}
