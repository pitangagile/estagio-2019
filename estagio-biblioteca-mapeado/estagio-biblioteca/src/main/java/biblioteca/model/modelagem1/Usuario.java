package biblioteca.model.modelagem1;

import biblioteca.infraestrutura.IObjectPersistent;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

/* This class could be inherited from the Pessoa class.
   However, it is only being considered that the Escritor class has this inheritance.*/

@Entity
@Table(name = "tb_usuario")
public class Usuario implements IObjectPersistent<Long> {

    @Id
    private String cpf;
    @Size(max = 100,min = 20)
    @Column(name = "usu_cl_nome",nullable = false)
    private String nome;

    @JoinColumn(name = "usu_cl_id")
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Telefone.class)
    private Set<Telefone> telefones;

    @Email
    @Column(name = "email",nullable = false)
    private String email;

    @JoinColumn(name = "usu_cl_endereco")
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Endereco.class)
    private Endereco endereco;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Emprestimo.class)
    @JoinColumn(name = "usu_cl_emprestimo")
    private Emprestimo emprestimo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public Long getId() {
        return null;
    }
}

