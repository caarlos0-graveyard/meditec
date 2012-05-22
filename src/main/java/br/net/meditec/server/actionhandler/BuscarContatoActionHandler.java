package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

import br.net.meditec.server.converter.AbstractConverter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.BuscarContatoAction;
import br.net.meditec.shared.commands.BuscarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Busca contatos em todos os campos a partir do parametro.
 *
 * @author Carlos A Becker
 */
public class BuscarContatoActionHandler
    implements ActionHandler<BuscarContatoAction, BuscarContatoResult> {

  private final ContatoDao dao;
  private final AbstractConverter<Contato, ContatoDTO> abstractConverter;

  @Inject
  public BuscarContatoActionHandler(AbstractConverter<Contato, ContatoDTO> abstractConverter, ContatoDao dao) {
    this.abstractConverter = abstractConverter;
    this.dao = dao;
  }

  @Override
  public BuscarContatoResult execute(BuscarContatoAction action, ExecutionContext context)
      throws ActionException {
    return new BuscarContatoResult(abstractConverter.toDTOList(dao.find(action.getParam())));
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
