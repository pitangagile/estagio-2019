package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "atividade")
public class atividade implements Serializable {

    @EmbeddedId
    private atividadePK codigo_atividade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        atividade atividade = (atividade) o;
        return Objects.equal(codigo_atividade, atividade.codigo_atividade);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo_atividade);
    }

    public atividadePK getCodigo_atividade() {
        return codigo_atividade;
    }

    public void setCodigo_atividade(atividadePK codigo_atividade) {
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
}
