package br.net.meditec.server.inject;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

import br.net.meditec.server.*;
import br.net.meditec.shared.commands.*;

/**
 * @author: Carlos A Becker
 */
public class MeditecHandlerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {
    bindHandler(SalvarContatoAction.class, SalvarContatoActionHandler.class);
  }

}
