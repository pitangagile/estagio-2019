package biblioteca.model.newModel;


import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "palavra")
public class Palavra implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "codigo.codigoPalavra") //explicitando um mappedBy, nenhuma tabela é criada a mais
    private Set<Atividade_has_Palavra> atividadepalavra;

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

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public Long getId() {
        return null;
    }
}
