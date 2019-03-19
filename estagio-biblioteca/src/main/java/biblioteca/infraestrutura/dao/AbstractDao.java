package biblioteca.infraestrutura.dao;

import biblioteca.infraestrutura.IObjectPersistent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractDao<T extends IObjectPersistent<C>,C> implements IDao<T,C> {

    private Class objectClass;
    public SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.objectClass = type.getClass();
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(T model) {
        this.getSession().persist(model);
    }

    @Override
    public Boolean delete(T model) {
        return null;
    }

    @Override
    public T update(T model) {
        return null;
    }

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {

        NativeQuery query = this.getSession().createSQLQuery("select * from tblivro");

        return query.list();
    }

    @Override
    public List<T> findAllPaginating(PagingAndSortingRepository pagingAndSortingRepository) {
        return null;
    }

    @Override
    public Class<T> getObjectClass() {
        return objectClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
