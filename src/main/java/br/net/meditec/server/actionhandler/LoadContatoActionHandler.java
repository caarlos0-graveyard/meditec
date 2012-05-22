package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

import br.net.meditec.server.converter.AbstractConverter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.LoadContatoAction;
import br.net.meditec.shared.commands.LoadContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Carrega um contato a partir de seu ID.
 *
 * @author Carlos A Becker
 */
public class LoadContatoActionHandler
    implements ActionHandler<LoadContatoAction, LoadContatoResult> {

  private final ContatoDao dao;
  private final AbstractConverter<Contato, ContatoDTO> abstractConverter;

  @Inject
  public LoadContatoActionHandler(AbstractConverter<Contato, ContatoDTO> abstractConverter, ContatoDao dao) {
    this.abstractConverter = abstractConverter;
    this.dao = dao;
  }

  @Override
  public LoadContatoResult execute(LoadContatoAction action, ExecutionContext context)
      throws ActionException {
    return new LoadContatoResult(abstractConverter.toDTO(dao.findByID(action.getId())));
  }

  @Override
  public Class<LoadContatoAction> getActionType() {
    return LoadContatoAction.class;
  }

  @Override
  public void undo(LoadContatoAction action, LoadContatoResult result, ExecutionContext context)
      throws ActionException {
    // sem undos pra voce
  }
}
