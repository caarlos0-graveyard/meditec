package br.net.meditec.server.inject;

import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;

import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

/**
 * @author Carlos A Becker
 */
public class MeditecServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    super.configureServlets();

    install(new PersistenceModule());

    filter("/*").through(PersistFilter.class);

    serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);
  }
}
