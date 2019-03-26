package biblioteca.model.atividade;


import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "palavra")
public class palavra implements Serializable {

    @EmbeddedId
    private palavraPK codigo_palavra;

    @Size
    @Column(name = "palavra")
    private String palavra;

    @Size
    @Column(name = "figura")
    private String figura;

    @Size
    @Column(name = "pala_separada")
    private String pala_separada;

    @Size
    @Column(name = "letra_ini")
    private String letra_ini;

    @Size
    @Column(name = "letra_final")
    private String letra_final;

    @Size
    @Column(name = "maius_ini")
    private String maius_ini;

    @Size
    @Column(name = "minus_ini")
    private String minus_ini;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        palavra palavra = (palavra) o;
        return Objects.equal(codigo_palavra, palavra.codigo_palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo_palavra);
    }

    public palavraPK getCodigo_palavra() {
        return codigo_palavra;
    }

    public void setCodigo_palavra(palavraPK codigo_palavra) {
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
