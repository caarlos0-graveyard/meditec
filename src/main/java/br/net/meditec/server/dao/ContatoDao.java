package br.net.meditec.server.dao;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

import br.net.meditec.server.model.Contato;

/**
 * @author Carlos A Becker
 */
public class ContatoDao extends AbstractDao<Contato> {

  @Inject
  public ContatoDao(Provider<EntityManager> emp) {
    super(emp, Contato.class);
  }
}
