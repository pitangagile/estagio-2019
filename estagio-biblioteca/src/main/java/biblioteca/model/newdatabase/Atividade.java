package biblioteca.model.newdatabase;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_atividade;

    @OneToMany
    @JoinColumn(name = "atividade_FK")
    private Set<Atividade_has_Palavra> atividade_has_palavras;

    @OneToMany
    @JoinColumn(name = "atividade_usuario")
    private Set<Usuario_has_Atividade> usuario_has_atividades;

    @OneToMany()
    @JoinColumn(name = "atividadeId_FK")
    private Set<Rendimento_aluno> rendimento_alunos;

    @Column(name = "atv_cl_nome")
    private String nome;

    @Column(name = "atv_cl_descrição")
    private String descrição;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(codigo_atividade, atividade.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_atividade);
    }

    public Integer getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Integer codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public Set<Atividade_has_Palavra> getAtividade_has_palavras() {
        return atividade_has_palavras;
    }

    public void setAtividade_has_palavras(Set<Atividade_has_Palavra> atividade_has_palavras) {
        this.atividade_has_palavras = atividade_has_palavras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Set<Usuario_has_Atividade> getUsuario_has_atividades() {
        return usuario_has_atividades;
    }

    public void setUsuario_has_atividades(Set<Usuario_has_Atividade> usuario_has_atividades) {
        this.usuario_has_atividades = usuario_has_atividades;
    }

    public Set<Rendimento_aluno> getRendimento_alunos() {
        return rendimento_alunos;
    }

    public void setRendimento_alunos(Set<Rendimento_aluno> rendimento_alunos) {
        this.rendimento_alunos = rendimento_alunos;
    }
}
