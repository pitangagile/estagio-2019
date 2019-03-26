package biblioteca.model.atividade_usuario;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_palavra")
public class Palavra implements IObjectPersistent<Long> {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "palavra")
    private Set<AtividadeTemPalavra> atividade_tem_palavras;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_palavra;

    @Size(max = 20, min = 1)
    @Column(name = "pal_cl_palavra")
    private String palavra;

    @Size(max = 20, min = 1)
    @Column(name = "pal_cl_figura")
    private String figura;

    @Size(max = 10, min = 1)
    @Column(name = "pal_cl_pala_separada")
    private String pala_separada;

    @Size(max = 1, min = 1)
    @Column(name = "pal_cl_letra_ini")
    private String letra_ini;

    @Size(max = 1, min = 1)
    @Column(name = "pal_cl_letra_final")
    private String letra_final;

    @Size(max = 1, min = 1)
    @Column(name = "pal_cl_maius_ini")
    private String maius_ini;

    @Size(max = 1, min = 1)
    @Column(name = "pal_cl_minus_ini")
    private String minus_ini;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palavra palavra1 = (Palavra) o;
        return Objects.equals(atividade_tem_palavras, palavra1.atividade_tem_palavras) &&
                Objects.equals(codigo_palavra, palavra1.codigo_palavra) &&
                Objects.equals(palavra, palavra1.palavra) &&
                Objects.equals(figura, palavra1.figura) &&
                Objects.equals(pala_separada, palavra1.pala_separada) &&
                Objects.equals(letra_ini, palavra1.letra_ini) &&
                Objects.equals(letra_final, palavra1.letra_final) &&
                Objects.equals(maius_ini, palavra1.maius_ini) &&
                Objects.equals(minus_ini, palavra1.minus_ini);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividade_tem_palavras, codigo_palavra, palavra, figura, pala_separada, letra_ini, letra_final, maius_ini, minus_ini);
    }

    public Set<AtividadeTemPalavra> getAtividade_tem_palavras() {
        return atividade_tem_palavras;
    }

    public void setAtividade_tem_palavras(Set<AtividadeTemPalavra> atividade_tem_palavras) {
        this.atividade_tem_palavras = atividade_tem_palavras;
    }

    public Long getCodigo_palavra() {
        return codigo_palavra;
    }

    public void setCodigo_palavra(Long codigo_palavra) {
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

    @Override
    public Long getId() {
        return this.codigo_palavra;
    }
}
