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
import br.net.meditec.server.dao.EventoDao;
import br.net.meditec.server.model.Evento;
import br.net.meditec.shared.commands.SalvarEventoAction;
import br.net.meditec.shared.commands.SalvarEventoResult;
import br.net.meditec.shared.dto.EventoDTO;

/**
 * @author: Carlos A Becker
 */
public class SalvarEventoActionHandler
    implements ActionHandler<SalvarEventoAction, SalvarEventoResult> {

  private final EventoDao dao;
  private final AbstractConverter<Evento, EventoDTO> converter;

  @Inject
  public SalvarEventoActionHandler(AbstractConverter<Evento, EventoDTO> converter,
                                   EventoDao dao) {
    this.converter = converter;
    this.dao = dao;
  }

  @Override
  public SalvarEventoResult execute(SalvarEventoAction action, ExecutionContext context)
      throws ActionException {

    try {
      return new SalvarEventoResult(converter.toDTO(dao.save(converter.toBean(action.getEvento()))),
                                    true, Arrays.asList("Evento salvo com sucesso;"));

    } catch (ConstraintViolationException cve) {
      List<String> msgs = new ArrayList<String>();
      for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
        msgs.add(violation.getMessage());
      }
      return new SalvarEventoResult(null, false, msgs);
    } catch (Exception e) {
      e.printStackTrace();
      return new SalvarEventoResult(null, false, Arrays.asList("Erro fatal: " + e.getMessage()));
    }
  }

  @Override
  public Class<SalvarEventoAction> getActionType() {
    return SalvarEventoAction.class;
  }

  @Override
  public void undo(SalvarEventoAction action, SalvarEventoResult result, ExecutionContext context)
      throws ActionException {
  }
}
