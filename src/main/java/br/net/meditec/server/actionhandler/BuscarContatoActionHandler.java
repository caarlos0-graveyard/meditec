package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

import br.net.meditec.server.converter.Converter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.BuscarContatoAction;
import br.net.meditec.shared.commands.BuscarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class BuscarContatoActionHandler
    implements ActionHandler<BuscarContatoAction, BuscarContatoResult> {

  private final ContatoDao dao;
  private final Converter<Contato, ContatoDTO> converter;

  @Inject
  public BuscarContatoActionHandler(Converter<Contato, ContatoDTO> converter, ContatoDao dao) {
    this.converter = converter;
    this.dao = dao;
  }

  @Override
  public BuscarContatoResult execute(BuscarContatoAction action, ExecutionContext context)
      throws ActionException {
    return new BuscarContatoResult(converter.toDTOList(dao.findAll()));
  }

  @Override
  public Class<BuscarContatoAction> getActionType() {
    return BuscarContatoAction.class;
  }

  @Override
  public void undo(BuscarContatoAction action, BuscarContatoResult result, ExecutionContext context)
      throws ActionException {
    // ma sai pra lá.
  }
}
