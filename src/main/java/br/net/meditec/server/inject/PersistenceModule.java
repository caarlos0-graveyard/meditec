package br.net.meditec.server.inject;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import br.net.meditec.server.dao.ContatoDao;

/**
 * Módulo de persistência da aplicação.
 *
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractModule {

  @Override
  protected void configure() {
    // instalo o JPA, usando Guice-perist.
    install(new JpaPersistModule("meditec"));

    // dou bind nos daos.
    bind(ContatoDao.class);
  }
}
