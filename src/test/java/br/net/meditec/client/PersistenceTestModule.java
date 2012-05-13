package br.net.meditec.client;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistService;

import br.net.meditec.server.inject.PersistenceModule;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:45
 */
public class PersistenceTestModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new PersistenceModule());
    PersistenceInitializer initializer = new PersistenceInitializer();
    requestInjection(initializer);
    initializer.init();

  }
}
