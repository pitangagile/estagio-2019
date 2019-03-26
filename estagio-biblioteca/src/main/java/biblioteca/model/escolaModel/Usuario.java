package biblioteca.model.escolaModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_usuario_escola")
public class Usuario implements IObjectPersistent<UsuarioTipoPK> {

    //Chamei essa tabela de tb_usuario_escola pra não confundir com a tabela usuario do exercicio em sala.
    //Aqui eu embarco a chave composta na classe usuario.
    @EmbeddedId
    UsuarioTipoPK usuarioTipoPK;

    @Column(name = "usu_cl_tipouser")
    private Integer tipo_user;

    @Column(name = "usu_cl_nome")
    private String nome;

    @Column(name = "usu_cl_endereco")
    private String endereco;

    @Column(name = "usu_cl_datanasci")
    private String data_nasci;

    @Column(name = "usu_cl_login")
    private String login;

    @Column(name = "usu_cl_senha")
    private String senha;

    /* Um usuario pode ter várias atividades, e uma atividade pode estar associada a varios usuarios
     Nesse caso para que a tabela usuario has atividade exista dei um jointable juntando os ids das respectivas tabelas
     Como usuario possui chave composta foi necessário o uso de JoinColumns.*/
    @JoinTable(name = "tb_usuario_has_atividade",
            joinColumns = {
                    @JoinColumn(
                            name = "fk_usu_id",insertable = false, updatable = false),
                    @JoinColumn(
                            name = "fk_tipousu_id",insertable = false, updatable = false)},
            foreignKey = @ForeignKey(name = "fk_usu"),
            inverseJoinColumns = @JoinColumn(name="fk_ati_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Atividade> atividades;

    /*Um usuario pode ter varios rendimentos associados a ele*/
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RendimentoAluno> rendimentoAlunos;

    //Equals and hascodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioTipoPK, usuario.usuarioTipoPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioTipoPK);
    }

    // Getters and setters
    public UsuarioTipoPK getUsuarioTipoPK() {
        return usuarioTipoPK;
    }

    public void setUsuarioTipoPK(UsuarioTipoPK usuarioTipoPK) {
        this.usuarioTipoPK = usuarioTipoPK;
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

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Set<RendimentoAluno> getRendimentoAlunos() {
        return rendimentoAlunos;
    }

    public void setRendimentoAlunos(Set<RendimentoAluno> rendimentoAlunos) {
        this.rendimentoAlunos = rendimentoAlunos;
    }

    @Override
    public UsuarioTipoPK getId() {
        return this.usuarioTipoPK;
    }
}
