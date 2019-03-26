package biblioteca.infraestrutura.dao;

import biblioteca.infraestrutura.IObjectPersistent;
import biblioteca.model.Livro;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

        String ano = "1992";

        NativeQuery query = this.getSession().createSQLQuery("select * from tb_livro l where l.LIV_CL_ANOLANCAMENTO = :anolancamento");
        query.setParameter("anolancamento",ano);
        //Query query = this.getSession().createQuery("from Livro");

        //Criteria criteria = this.getSession().createCriteria(this.objectClass);
        //criteria.add(Restrictions.eq("anoLancamento",ano));

        //results.getOrderList(); tava sendo usado no criteria

        return query.list();
        //return criteria.list();
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
