package biblioteca.model.alunoAtividade;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_Palavra")
public class Palavra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo_palavra;

  @Column(name = "pal_palavra")
  private String palavra;

  @Column(name = "pal_figura")
  private String figura;

  @Column(name = "pal_palaSeparada")
  private String pala_separada;

  @Column(name = "pal_letraIni")
  private String letra_ini;

  @Column(name = "pal_letraFinal")
  private String letra_final;

  @Column(name = "pal_maiusIni")
  private String maius_ini;

  @Column(name = "pal_minusIni")
  private String minus_ini;

  //Será criando uma tabela que representará o relacionamento entre atividade e palavra
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinTable(name = "atividade_has_palavra",joinColumns = @JoinColumn(name="palavra_cl_id"),inverseJoinColumns = @JoinColumn(name = "atividade_cl_id"))
  private Set<Atividade> atividades;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Palavra palavra = (Palavra) o;
    return Objects.equal(codigo_palavra, palavra.codigo_palavra);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(codigo_palavra);
  }

  public Integer getCodigo_palavra() {
    return codigo_palavra;
  }

  public void setCodigo_palavra(Integer codigo_palavra) {
    this.codigo_palavra = codigo_palavra;
  }

  public String getPalavra() {
    return palavra;
  }

  public void setPalavra(String palavra) {
    this.palavra = palavra;
  }

  public String getFigura() {
    return figura;
  }

  public void setFigura(String figura) {
    this.figura = figura;
  }

  public String getPala_separada() {
    return pala_separada;
  }

  public void setPala_separada(String pala_separada) {
    this.pala_separada = pala_separada;
  }

  public String getLetra_ini() {
    return letra_ini;
  }

  public void setLetra_ini(String letra_ini) {
    this.letra_ini = letra_ini;
  }

  public String getLetra_final() {
    return letra_final;
  }

  public void setLetra_final(String letra_final) {
    this.letra_final = letra_final;
  }

  public String getMaius_ini() {
    return maius_ini;
  }

  public void setMaius_ini(String maius_ini) {
    this.maius_ini = maius_ini;
  }

  public String getMinus_ini() {
    return minus_ini;
  }

  public void setMinus_ini(String minus_ini) {
    this.minus_ini = minus_ini;
  }

}
