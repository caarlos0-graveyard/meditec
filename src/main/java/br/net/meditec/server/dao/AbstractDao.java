package br.net.meditec.server.dao;

import com.google.inject.persist.Transactional;

import java.util.List;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.net.meditec.server.model.Bean;

/**
 * @author Carlos A Becker
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
    if (t != null && t.getId() != null) {
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
