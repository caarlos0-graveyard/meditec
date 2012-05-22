package br.net.meditec.server.dao;

import com.google.inject.persist.Transactional;

import java.util.List;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.net.meditec.server.model.Bean;

/**
 * Dao abstrato.
 *
 * @author Carlos A Becker
 */
public abstract class AbstractDao<T extends Bean> {

  private final Provider<EntityManager> emp;
  private final Class<T> clazz;

  /**
   * Implemente este construtor na sua classe específica sem receber o parametro clazz.
   * O Guice não consegue injetar Class de objetos, então você terá de fazê-lo manualmente.
   *
   * @param emp
   * @param clazz
   */
  public AbstractDao(Provider<EntityManager> emp, Class<T> clazz) {
    this.clazz = clazz;
    this.emp = emp;
  }

  /**
   * Pega a instancia do entity manager.
   *
   * @return instance de EM.
   */
  protected final EntityManager em() {
    return emp.get();
  }

  /**
   * Salva o objeto no banco.
   * Trata internamente o Persist/Update.
   *
   * @param t objeto a ser salvo.
   * @return objeto atualizado.
   */
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

  /**
   * Carrega um objeto do banco a partir de seu ID.
   *
   * @param id id do objeto
   * @return objeto carregado.
   */
  @Transactional
  public T findByID(Long id) {
    return em().find(clazz, id);
  }

  /**
   * Apaga um registro do banco.
   *
   * @param t Objeto a ser excluido.
   */
  @Transactional
  public void remove(T t) {
    em().remove(t.getId() != null ? em().merge(t) : t);
  }

  /**
   * Retorna uma lista com todos os objetos do tipo T do banco.
   *
   * @return
   */
  @Transactional
  public List<T> findAll() {
    TypedQuery<T> query = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
    return query.getResultList();
  }
}
