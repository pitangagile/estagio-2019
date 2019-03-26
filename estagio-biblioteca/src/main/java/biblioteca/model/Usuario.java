package biblioteca.model;


import biblioteca.infraestrutura.IObjectPersistent;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {

    @Size(max = 11,min = 11)
    @Column(name = "usu_cl_cpf", nullable = false,length = 11)
    private String cpf;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = Telefone.class, mappedBy = "usuario") //um usuario poderá ter vários telefones.
    private Set<Telefone> telefone;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY, targetEntity = Endereco.class, mappedBy = "usuario")
    private Endereco endereco;

    @OneToOne
    private Emprestimo emprestimo;

    @Override
    public Long getId() {
        return null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<Telefone> telefone) {
        this.telefone = telefone;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

}
