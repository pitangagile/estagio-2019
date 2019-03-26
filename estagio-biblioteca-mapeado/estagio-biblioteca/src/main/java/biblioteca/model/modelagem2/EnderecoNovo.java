package biblioteca.model.modelagem2;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.modelagem2.UsuarioNovo;
import com.google.common.base.Objects;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_endereco")
public class EnderecoNovo implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "endereco")
    private UsuarioNovo usuarioNovo;

    @Size(min = 50, max = 150)
    @Column(name = "end_cl_logradouro")
    private String logradouro;

    @Size(min = 50, max = 100)
    @Column(name = "end_cl_bairro")
    private String bairro;

    @Size(min = 50, max = 100)
    @Column(name = "end_cl_cidade")
    private String cidade;

    @Size(min = 30, max = 80)
    @Column(name = "end_cl_estado")
    private String estado;

    @Size(min = 10, max = 10)
    @Column(name = "end_cl_cep")
    private String cep;

    @Size(min = 3, max = 5)
    @Column(name = "end_cl_complemento")
    private String complemento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoNovo endereco = (EnderecoNovo) o;
        return Objects.equal(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioNovo getUsuario() {
        return usuarioNovo;
    }

    public void setUsuario(UsuarioNovo usuario) {
        this.usuarioNovo = usuario;
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