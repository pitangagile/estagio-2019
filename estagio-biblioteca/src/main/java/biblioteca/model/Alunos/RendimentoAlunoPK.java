package biblioteca.model.Alunos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//Classe embarcável para criação de chave composta para a tabela "rendimento_aluno"
@Embeddable
public class RendimentoAlunoPK implements Serializable {

    //chave que mapeia uma atividade
    @Column(name = "atividade_codigo_atividade",nullable = false)
    private long codigoAtividade;

    //chave que mapeia um tipo de usuario
    @Column(name = "usuario_tipo_usuario_codigo",nullable = false)
    private long codigoTipoUsuario;

    //chave que mapeia um usuario
    @Column(name = "usuario_codigo_usuario",nullable = false)
    private long codigoUsuario;

    public long getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(long codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public long getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(long codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RendimentoAlunoPK that = (RendimentoAlunoPK) o;

        if (codigoAtividade != that.codigoAtividade) return false;
        if (codigoTipoUsuario != that.codigoTipoUsuario) return false;
        return codigoUsuario == that.codigoUsuario;
    }

    @Override
    public int hashCode() {
        int result = (int) (codigoAtividade ^ (codigoAtividade >>> 32));
        result = 31 * result + (int) (codigoTipoUsuario ^ (codigoTipoUsuario >>> 32));
        result = 31 * result + (int) (codigoUsuario ^ (codigoUsuario >>> 32));
        return result;
    }
}
