package biblioteca.model.atividade;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "rendimento_aluno")
public class rendimento_aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rendimento;

    @EmbeddedId
    private rendimento_alunoPK rendimento_alunoPK;

    @Size
    @Column(name = "codigo_aluno")
    private Long codigo_aluno;

    @Size
    @Column(name = "codigo_atividade")
    private Long codigo_atividade;

    @Size
    @Column(name = "data_2")
    private Long data_2;

    @Size
    @Column(name = "hora")
    private Long hora;

    @Size
    @Column(name = "rendimento")
    private Long rendimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        rendimento_aluno that = (rendimento_aluno) o;
        return Objects.equal(id_rendimento, that.id_rendimento) &&
                Objects.equal(rendimento_alunoPK, that.rendimento_alunoPK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_rendimento, rendimento_alunoPK);
    }

    public Long getId_rendimento() {
        return id_rendimento;
    }

    public void setId_rendimento(Long id_rendimento) {
        this.id_rendimento = id_rendimento;
    }

    public biblioteca.model.atividade.rendimento_alunoPK getRendimento_alunoPK() {
        return rendimento_alunoPK;
    }

    public void setRendimento_alunoPK(biblioteca.model.atividade.rendimento_alunoPK rendimento_alunoPK) {
        this.rendimento_alunoPK = rendimento_alunoPK;
    }

    public Long getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(Long codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public Long getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(Long codigo_atividade) {
        this.codigo_atividade = codigo_atividade;
    }

    public Long getData_2() {
        return data_2;
    }

    public void setData_2(Long data_2) {
        this.data_2 = data_2;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public Long getRendimento() {
        return rendimento;
    }

    public void setRendimento(Long rendimento) {
        this.rendimento = rendimento;
    }
}
