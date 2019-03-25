package biblioteca.model.escola;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Esc_tb_palavra")
public class Palavra implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_palavra;

    private String palavra;
    private String figura;

    @Column(name = "pala_separada")
    private String palaSeparada;

    @Column(name = "letra_ini")
    private String letraInicial;

    @Column(name = "letra_fin")
    private String letraFinal;


    @Column(name = "maius_ini")
    private String maiusculaInicial;

    @Column(name = "minus_ini")
    private String minusculaInicial;

    @ManyToMany(mappedBy = "palavras")
    private Set<Atividade> atividades;


    @Override
    public Integer getId() {
        return this.codigo_palavra;
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

    public String getPalaSeparada() {
        return palaSeparada;
    }

    public void setPalaSeparada(String palaSeparada) {
        this.palaSeparada = palaSeparada;
    }

    public String getLetraInicial() {
        return letraInicial;
    }

    public void setLetraInicial(String letraInicial) {
        this.letraInicial = letraInicial;
    }

    public String getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(String letraFinal) {
        this.letraFinal = letraFinal;
    }

    public String getMaiusculaInicial() {
        return maiusculaInicial;
    }

    public void setMaiusculaInicial(String maiusculaInicial) {
        this.maiusculaInicial = maiusculaInicial;
    }

    public String getMinusculaInicial() {
        return minusculaInicial;
    }

    public void setMinusculaInicial(String minusculaInicial) {
        this.minusculaInicial = minusculaInicial;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palavra palavra1 = (Palavra) o;
        return Objects.equals(codigo_palavra, palavra1.codigo_palavra) &&
                Objects.equals(palavra, palavra1.palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_palavra, palavra);
    }


}
