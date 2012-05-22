package br.net.meditec.server.actionhandler;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import br.net.meditec.server.converter.AbstractConverter;
import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.commands.SalvarContatoAction;
import br.net.meditec.shared.commands.SalvarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Salva o contato no banco, e retorna sua versão atualizada.
 *
 * @author Carlos A Becker
 */
public class SalvarContatoActionHandler
    implements ActionHandler<SalvarContatoAction, SalvarContatoResult> {

  private final AbstractConverter<Contato, ContatoDTO> abstractConverter;
  private final ContatoDao dao;

  @Inject
  public SalvarContatoActionHandler(AbstractConverter<Contato, ContatoDTO> abstractConverter, ContatoDao dao) {
    this.abstractConverter = abstractConverter;
    this.dao = dao;
  }

  public SalvarContatoResult execute(SalvarContatoAction action, ExecutionContext context)
      throws ActionException {

    Contato contato;
    try {
      contato = dao.save(abstractConverter.toBean(action.getContato()));
    } catch (ConstraintViolationException cve) {
      List<String> msgs = new ArrayList<String>();
      for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
        msgs.add(violation.getMessage());
      }
      return new SalvarContatoResult(false, msgs, null);
    } catch (Exception e) {
      e.printStackTrace();
      return new SalvarContatoResult(false, Arrays.asList("Erro fatal: " + e.getMessage()), null);
    }

    return new SalvarContatoResult(true, Arrays.asList("Salvo com sucesso!"),
                                   abstractConverter.toDTO(contato));
  }

  public Class<SalvarContatoAction> getActionType() {
    return SalvarContatoAction.class;
  }

  public void undo(SalvarContatoAction action, SalvarContatoResult result, ExecutionContext context)
      throws ActionException {
    // maoe, sem undo pra vc flw bjundas
  }
}
