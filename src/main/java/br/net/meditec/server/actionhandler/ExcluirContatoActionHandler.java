package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import java.util.Arrays;

import javax.inject.Inject;

import br.net.meditec.server.converter.Converter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.ExcluirContatoAction;
import br.net.meditec.shared.commands.ExcluirContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author Carlos A Becker
 */
public class ExcluirContatoActionHandler
    implements ActionHandler<ExcluirContatoAction, ExcluirContatoResult> {

  private final ContatoDao dao;
  private final Converter<Contato, ContatoDTO> converter;

  @Inject
  public ExcluirContatoActionHandler(Converter<Contato, ContatoDTO> converter, ContatoDao dao) {
    this.converter = converter;
    this.dao = dao;
  }

  @Override
  public ExcluirContatoResult execute(ExcluirContatoAction action, ExecutionContext context)
      throws ActionException {

    try {
      dao.remove(converter.toBean(action.getContato()));
    } catch (Exception e) {
      e.printStackTrace();
      return new ExcluirContatoResult(
          Arrays.asList(
              "Ocorreu um erro ao excluir o contato " + action.getContato().getNome() + ": " + e
                  .getLocalizedMessage()), false);
    }

    return new ExcluirContatoResult(
        Arrays.asList("Contato " + action.getContato().getNome() + " excluido com sucesso."), true);
  }

  @Override
  public Class<ExcluirContatoAction> getActionType() {
    return ExcluirContatoAction.class;
  }

  @Override
  public void undo(ExcluirContatoAction action, ExcluirContatoResult result,
                   ExecutionContext context) throws ActionException {
    // ma sai pra lá
  }
}
