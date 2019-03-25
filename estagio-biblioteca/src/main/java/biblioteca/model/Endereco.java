package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbendereco")
public class Endereco implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "end_cl_usuario")
    private Usuario usuario;

    @Size(max = 100, min = 5)
    @Column(name = "end_cl_logradouro")
    private String logradouro;

    @Size(max = 100, min = 5)
    @Column(name = "end_cl_bairro")
    private String bairro;

    @Size(max = 100, min = 5)
    @Column(name = "end_cl_cidade")
    private String cidade;

    @Size(max = 100, min = 5)
    @Column(name = "end_cl_estado")
    private String estado;

    @Size(max = 8, min = 8)
    @Column(name = "end_cl_cep", nullable = false)
    private String cep;

    @Size(max = 100, min = 5)
    @Column(name = "end_cl_complemento")
    private String complemento;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
