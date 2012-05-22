package br.net.meditec.server.inject;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

import br.net.meditec.server.actionhandler.BuscarContatoActionHandler;
import br.net.meditec.server.actionhandler.ExcluirContatoActionHandler;
import br.net.meditec.server.actionhandler.LoadContatoActionHandler;
import br.net.meditec.server.actionhandler.SalvarContatoActionHandler;
import br.net.meditec.shared.commands.BuscarContatoAction;
import br.net.meditec.shared.commands.ExcluirContatoAction;
import br.net.meditec.shared.commands.LoadContatoAction;
import br.net.meditec.shared.commands.SalvarContatoAction;

/**
 * Modulo com os binds das Actions para seus respectivos ActionHandlers.
 *
 * @author Carlos A Becker
 */
public class MeditecHandlerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {
    bindHandler(SalvarContatoAction.class, SalvarContatoActionHandler.class);
    bindHandler(BuscarContatoAction.class, BuscarContatoActionHandler.class);
    bindHandler(LoadContatoAction.class, LoadContatoActionHandler.class);
    bindHandler(ExcluirContatoAction.class, ExcluirContatoActionHandler.class);
  }

}
