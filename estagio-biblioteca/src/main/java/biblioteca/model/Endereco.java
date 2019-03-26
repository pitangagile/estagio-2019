package biblioteca.model;

import biblioteca.infraestrutura.IObjectPersistent;
import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50,min = 10, message = "Logradouro com tamanho inválido")
    @Column(name = "end_cl_logradouro",nullable = false)
    private String logradouro;

    @Size(max = 50,min = 10, message = "Bairro com tamanho inválido")
    @Column(name = "end_cl_bairro",nullable = false)
    private String bairro;

    @Size(max = 50,min = 10, message = "Cidade com tamanho inválido")
    @Column(name = "end_cl_cidade", nullable = false)
    private String cidade;

    @Size(max = 50,min = 10,message = "Estado com tamanho inválido")
    @Column(name = "end_cl_estado", nullable = false)
    private String estado;

    @Size(max = 30, min = 8 ,message = "CEP com tamanho inválido")
    @Column(name = "end_cl_cep", nullable = false)
    private String cep;

    @Size(min = 2,max = 10,message = "Complemento inválido")
    @Column(name = "end_cl_complemento", nullable = false)
    private String complemento;

    @OneToOne
    @JoinColumn(name = "end_cl_usuario") // usado qnd o relacionamento é onemany,manyone,manymany etc.
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id == endereco.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
