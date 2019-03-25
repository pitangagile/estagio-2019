package biblioteca.model.alunoAtividade;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;

  @Column(name = "tipUsu_descricao")
  private String descricao;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TipoUsuario that = (TipoUsuario) o;
    return Objects.equal(codigo, that.codigo) &&
      Objects.equal(descricao, that.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(codigo, descricao);
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
