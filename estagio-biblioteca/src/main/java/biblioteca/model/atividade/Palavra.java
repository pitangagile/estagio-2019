package biblioteca.model.atividade;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "palavra")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_palavra")
    private Long id;

    @Size(max = 20,min = 1)
    @Column(name = "palavra", nullable = false)
    private String palavra;

    @Size(max = 20,min = 1)
    @Column(name = "pala_separada", nullable = false)
    private String palavraSeparada;

    @Size(max = 20,min = 1)
    @Column(name = "letra_ini", nullable = false)
    private String letraInicial;

    @Size(max = 20,min = 1)
    @Column(name = "letra_final", nullable = false)
    private String letraFinal;

    @Size(max = 20,min = 1)
    @Column(name = "figura", nullable = false)
    private String figura;

    @Size(max = 20,min = 1)
    @Column(name = "maius_ini", nullable = false)
    private String maisculaInicial;

    @Size(max = 20,min = 1)
    @Column(name = "minus_ini", nullable = false)
    private String minusculaInicial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavraSeparada() {
        return palavraSeparada;
    }

    public void setPalavraSeparada(String palavraSeparada) {
        this.palavraSeparada = palavraSeparada;
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

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public String getMaisculaInicial() {
        return maisculaInicial;
    }

    public void setMaisculaInicial(String maisculaInicial) {
        this.maisculaInicial = maisculaInicial;
    }

    public String getMinusculaInicial() {
        return minusculaInicial;
    }

    public void setMinusculaInicial(String minusculaInicial) {
        this.minusculaInicial = minusculaInicial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palavra palavra1 = (Palavra) o;
        return Objects.equals(id, palavra1.id) &&
                Objects.equals(palavra, palavra1.palavra) &&
                Objects.equals(palavraSeparada, palavra1.palavraSeparada) &&
                Objects.equals(letraInicial, palavra1.letraInicial) &&
                Objects.equals(letraFinal, palavra1.letraFinal) &&
                Objects.equals(figura, palavra1.figura) &&
                Objects.equals(maisculaInicial, palavra1.maisculaInicial) &&
                Objects.equals(minusculaInicial, palavra1.minusculaInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, palavra, palavraSeparada, letraInicial, letraFinal, figura, maisculaInicial, minusculaInicial);
    }
}
