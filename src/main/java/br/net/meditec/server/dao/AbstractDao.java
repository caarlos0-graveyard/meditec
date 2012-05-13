package br.net.meditec.server.dao;

import br.net.meditec.server.model.Bean;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Carlos A Becker
 * @since  10/05/12 20:50
 */
public class AbstractDao<T extends Bean> {

    private final Provider<EntityManager> emp;
    private final Class<T> clazz;

    public AbstractDao(Provider<EntityManager> emp, Class<T> clazz) {
        this.clazz = clazz;
        this.emp = emp;
    }

    protected final EntityManager em() {
        return emp.get();
    }

    @Transactional
    public T save(T t) {
        if(t != null && t.getId() != null) {
            t = em().merge(t);
            em().flush();
            return t;
        }
        em().persist(t);
        return t;
    }

    @Transactional
    public T findByID(Long id) {
        return em().find(clazz, id);
    }

    @Transactional
    public void remove(T t) {
        em().remove(t);
    }

    @Transactional
    public List<T> findAll() {
        TypedQuery<T> query = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
        return query.getResultList();
    }
}
