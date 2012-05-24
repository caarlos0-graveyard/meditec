package br.net.meditec.server.dao;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

import br.net.meditec.server.model.Evento;

/**
 * @author: Carlos A Becker
 */
public class EventoDao extends AbstractDao<Evento> {

  @Inject
  public EventoDao(Provider<EntityManager> emp) {
    super(emp, Evento.class);
  }
}
