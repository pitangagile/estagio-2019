package biblioteca.model.escolaModel;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_palavra")
public class Palavra implements IObjectPersistent<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_palavra;

    @Column(name = "pal_cl_palavra")
    private String palavra;

    @Column(name = "pal_cl_figura")
    private String figura;

    @Column(name = "pal_cl_palaseparada")
    private String pala_separada;

    @Column(name = "pal_cl_letraini")
    private String letra_ini;

    @Column(name = "pal_cl_letrafinal")
    private String letra_final;

    @Column(name = "pal_cl_maiusini")
    private String maius_ini;

    @Column(name = "pal_cl_minusini")
    private String minus_ini;


    /* Uma palavra pode estar em várias atividades e uma atividade pode ter várias palavras, por isso foi escolhido manytomany
    Para que a tabela atividade has palavra seja criada, dei um joinTable com as colunas dos respectivos ids. */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "tb_atividade_has_palavra",joinColumns = @JoinColumn(name = "pal_cl_id"),inverseJoinColumns = @JoinColumn(name = "ati_cl_id"))
    private Set<Atividade> atividades;

    //Equals and Hashcodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palavra palavra = (Palavra) o;
        return Objects.equals(codigo_palavra, palavra.codigo_palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_palavra);
    }

    //Getters and setters

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

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public Integer getId() {
        return codigo_palavra;
    }
}