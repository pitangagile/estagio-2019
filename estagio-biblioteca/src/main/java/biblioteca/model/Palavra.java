package biblioteca.model.Alunos;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "palavra")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo_palavra")
    private long codigoPalavra;

    @Column(name = "palavra")
    private String palavra;

    @Column(name = "figura")
    private String figura;

    @Column(name = "pala_separada")
    private String palaSeparada;

    @Column(name = "letra_ini")
    private String letraIni;

    @Column(name = "letra_final")
    private String letraFinal;

    @Column(name = "maius_ini")
    private String maiusIni;

    @Column(name = "minus_ini")
    private String minusIni;

    
    @OneToMany
    @JoinColumn(name = "atividade_has_palavra")
    private Set<AtividadeHasPalavra> atividadeHasPalavras;
    
    public void setCodigoPalavra(palavraPK codigoPalavra) {
        this.codigoPalavra = codigoPalavra;
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

    public String getLetraIni() {
        return letraIni;
    }

    public void setLetraIni(String letraIni) {
        this.letraIni = letraIni;
    }

    public String getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(String letraFinal) {
        this.letraFinal = letraFinal;
    }

    public String getMaiusIni() {
        return maiusIni;
    }

    public void setMaiusIni(String maiusIni) {
        this.maiusIni = maiusIni;
    }

    public String getMinusIni() {
        return minusIni;
    }

    public void setMinusIni(String minusIni) {
        this.minusIni = minusIni;
    }
}

}
