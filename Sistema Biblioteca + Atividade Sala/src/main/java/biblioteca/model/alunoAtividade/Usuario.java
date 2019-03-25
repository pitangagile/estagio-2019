package biblioteca.model.alunoAtividade;

import biblioteca.model.Acervo;
import biblioteca.model.Livro;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_UsuarioNovo")
public class Usuario {

  //Transformando a Chave primaria composta em ID da tabela
  @EmbeddedId
  private UsuarioTipoPK usuarioTipoPK;

  private Integer tipo_user;
  private String nome;
  private String endereço;
  private String data_nasci;
  private String login;
  private String senha;

  public Integer getTipo_user() {
    return tipo_user;
  }

  public void setTipo_user(Integer tipo_user) {
    this.tipo_user = tipo_user;
  }

  public String getVarchar() {
    return nome;
  }

  public void setVarchar(String nome) {
    this.nome = nome;
  }

  public String getEndereço() {
    return endereço;
  }

  public void setEndereço(String endereço) {
    this.endereço = endereço;
  }

  public String getData_nasci() {
    return data_nasci;
  }

  public void setData_nasci(String data_nasci) {
    this.data_nasci = data_nasci;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
