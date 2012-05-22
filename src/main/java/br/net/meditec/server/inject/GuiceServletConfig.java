package br.net.meditec.server.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Configura o injetor do Guice no contexto web.
 *
 * @author Carlos A Becker
 */
public class GuiceServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    // todos os módulos são adicionados aqui.
    return Guice.createInjector(new MeditecServletModule(), new MeditecHandlerModule(), new ConverterModule());
  }
}
