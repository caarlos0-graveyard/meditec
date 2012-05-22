package br.net.meditec.server.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.net.meditec.server.model.Contato;

/**
 * @author Carlos A Becker
 */
public class ContatoDao extends AbstractDao<Contato> {

  @Inject
  public ContatoDao(Provider<EntityManager> emp) {
    super(emp, Contato.class);
  }

  public List<Contato> find(String param) {

    TypedQuery<Contato> q = em().createQuery("SELECT c FROM Contato c "
                                             + "WHERE c.nome like :q"
                                             + " OR c.sobrenome like :q"
                                             + " OR c.email like :q"
                                             + " OR c.numero like :q"
                                             + " order by c.id asc ", Contato.class);
    q.setParameter("q", "%" + param + "%");
    return q.getResultList();
  }
}
