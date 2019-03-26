package biblioteca.model.Atividades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "palavra")
public class Palavra {

    @Id
    @Column(name="codigo_palavra", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, min = 2)
    @Column(name = "palavra",nullable = false)
    private String palavra;

    @Size(max = 50, min = 2)
    @Column(name = "figura",nullable = false)
    private String figura;

    @Size(max = 50, min = 2)
    @Column(name = "pala_separada",nullable = false)
    private String palaSeparada;

    @Size(max = 1, min = 1)
    @Column(name = "letra_ini",length = 1,nullable = false)
    private String letraIni;

    @Size(max = 1, min = 1)
    @Column(name = "letra_final",length = 1,nullable = false)
    private String letraFinal;

    @Size(max = 1, min = 1)
    @Column(name = "maius_ini",length = 1,nullable = false)
    private String maiusIni;

    @Size(max = 1, min = 1)
    @Column(name = "minus_ini",length = 1,nullable = false)
    private String minusIni;

    @ManyToMany(mappedBy = "palavras")
    private Set<Atividade> atividades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Palavra palavra = (Palavra) o;

        return id != null ? id.equals(palavra.id) : palavra.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
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
