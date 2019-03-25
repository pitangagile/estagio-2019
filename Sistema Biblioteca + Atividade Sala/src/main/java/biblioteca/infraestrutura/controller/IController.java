package biblioteca.infraestrutura.controller;

import biblioteca.infraestrutura.IObjectPersistent;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IController<T extends  IObjectPersistent<C>,C> {

    public T insert(T model);

    public Boolean delete(T model);

    public T update(T model);

    public T findOne(Long id);

    public List<T> findAll();

    public List<T> findAllPaginating(PagingAndSortingRepository pagingAndSortingRepository);

}
