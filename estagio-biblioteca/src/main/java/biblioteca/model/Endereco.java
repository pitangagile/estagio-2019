package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tb_endereco", schema = "biblioteca")
public class Endereco implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100,min = 10)
    @Column(name = "end_cl_logradouro", nullable = false)
    private String logradouro;

    @Size(max = 100,min = 10)
    @Column(name = "end_cl_cep", nullable = false)
    private String cep;

    @Size(max = 50,min = 2)
    @Column(name = "end_cl_ estado", nullable = false)
    private String estado;

    @Size(max = 50,min = 2)
    @Column(name = "end_cl_cidade", nullable = false)
    private String cidade;

    @Size(max = 50,min = 2)
    @Column(name = "end_cl_bairro", nullable = false)
    private String bairro;

    @Size(max = 50,min = 2)
    @Column(name = "end_cl_complemento", nullable = false)
    private String complemento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(logradouro, endereco.logradouro) &&
                Objects.equals(cep, endereco.cep) &&
                Objects.equals(estado, endereco.estado) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(complemento, endereco.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, cep, estado, cidade, bairro, complemento);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public Long getId() {
        return null;
    }
}
