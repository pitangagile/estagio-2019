package biblioteca.model.alunoAtividade;


import biblioteca.model.Emprestimo;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo_atividade;

  @Column(name = "ati_nome")
  private String nome;

  @ManyToMany(mappedBy = "atividades")
  private Set<Palavra> palavras;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Atividade atividade = (Atividade) o;
    return Objects.equal(codigo_atividade, atividade.codigo_atividade) &&
      Objects.equal(nome, atividade.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(codigo_atividade, nome);
  }

  public Integer getCodigo_atividade() {
    return codigo_atividade;
  }

  public void setCodigo_atividade(Integer codigo_atividade) {
    this.codigo_atividade = codigo_atividade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
