package biblioteca.infraestrutura.controller;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.infraestrutura.dao.AbstractDao;
import biblioteca.infraestrutura.dao.AbstractLibraryDao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("abstractController")
@Transactional()
public abstract class AbstractController<T extends IObjectPersistent<C>, C> implements IController<T, C> {


    AbstractLibraryDao<T,C> dao;

    @Override
    @Transactional
    public T insert(T model) {
        this.getDao().insert(model);
        return model;
    }

    @Override
    @Transactional
    public Boolean delete(T model) {
        return null;
    }

    @Override
    @Transactional
    public T update(T model) {
        return null;
    }


    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return this.getDao().findAll();
    }

    @Override
    public List<T> findAllPaginating(PagingAndSortingRepository pagingAndSortingRepository) {
        return null;
    }

    public AbstractLibraryDao<T, C> getDao() {
        return dao;
    }

    public void setDao(AbstractLibraryDao<T, C> dao) {
        this.dao = dao;
    }
}
