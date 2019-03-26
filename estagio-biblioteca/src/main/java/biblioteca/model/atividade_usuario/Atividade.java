package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements IObjectPersistent<Long> {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "atividade")
    private Set<AtividadeTemPalavra> atividade_tem_palavras;

    @OneToMany(mappedBy = "atividade")
    private Set<UsuarioTemAtividade> usuario_tem_atividades;

    @OneToMany(mappedBy = "atividade")
    private Set<RendimentoAluno> rendimentoAlunos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_atividade;

    @Size(max = 20, min = 2)
    @Column(name = "ati_cl_nome")
    private String nome;

    @Size(max = 20, min = 2)
    @Column(name = "ati_cl_descricao")
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(atividade_tem_palavras, atividade.atividade_tem_palavras) &&
                Objects.equals(usuario_tem_atividades, atividade.usuario_tem_atividades) &&
                Objects.equals(rendimentoAlunos, atividade.rendimentoAlunos) &&
                Objects.equals(codigo_atividade, atividade.codigo_atividade) &&
                Objects.equals(nome, atividade.nome) &&
                Objects.equals(descricao, atividade.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividade_tem_palavras, usuario_tem_atividades, rendimentoAlunos, codigo_atividade, nome, descricao);
    }

    public Set<AtividadeTemPalavra> getAtividade_tem_palavras() {
        return atividade_tem_palavras;
    }

    public void setAtividade_tem_palavras(Set<AtividadeTemPalavra> atividade_tem_palavras) {
        this.atividade_tem_palavras = atividade_tem_palavras;
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

    public Long getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Long codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return this.codigo_atividade;
    }
}
