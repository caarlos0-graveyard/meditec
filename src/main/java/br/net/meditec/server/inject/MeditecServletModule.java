package br.net.meditec.server.inject;

import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;

import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

/**
 * Configura o servlet do Guice.
 *
 * @author Carlos A Becker
 */
public class MeditecServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    super.configureServlets();

    // instalo o modulo de persistencia nesse modulo.
    install(new PersistenceModule());

    // configuro para filtrar tudo pelo PersistFilter do quice-persist.
    // assim tenho um "session-per-request".
    filter("/*").through(PersistFilter.class);

    // Sirvo o que for Action com o Service do Dispatch.
    serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);
  }
}
