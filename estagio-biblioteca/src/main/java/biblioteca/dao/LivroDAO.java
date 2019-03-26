package biblioteca.dao;

import biblioteca.infraestrutura.dao.AbstractDao;
import biblioteca.infraestrutura.dao.AbstractLibraryDao;
import biblioteca.infraestrutura.dao.IDao;
import biblioteca.model.biblioteca.Livro;
import org.springframework.stereotype.Component;


@Component(value="livroDao")
public class LivroDAO extends AbstractLibraryDao<Livro, Long> implements IDao<Livro, Long> {

    AbstractDao<Livro, Long> dao;

    public AbstractDao<Livro, Long> getDao() {
        return dao;
    }
    public void setDao(AbstractDao<Livro, Long> dao) {
        this.dao = dao;
    }

}
