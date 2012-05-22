package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

import br.net.meditec.server.converter.Converter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.LoadContatoAction;
import br.net.meditec.shared.commands.LoadContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class LoadContatoActionHandler
    implements ActionHandler<LoadContatoAction, LoadContatoResult> {

  private final ContatoDao dao;
  private final Converter<Contato, ContatoDTO> converter;

  @Inject
  public LoadContatoActionHandler(Converter<Contato, ContatoDTO> converter, ContatoDao dao) {
    this.converter = converter;
    this.dao = dao;
  }

  @Override
  public LoadContatoResult execute(LoadContatoAction action, ExecutionContext context)
      throws ActionException {
    return new LoadContatoResult(converter.toDTO(dao.findByID(action.getId())));
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
