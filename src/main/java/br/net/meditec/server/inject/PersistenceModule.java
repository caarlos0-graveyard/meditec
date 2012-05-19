package br.net.meditec.server.inject;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import br.net.meditec.server.dao.ContatoDao;

/**
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new JpaPersistModule("meditec"));
    bind(ContatoDao.class);
  }
}
