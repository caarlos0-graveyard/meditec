package br.net.meditec.shared.commands;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import java.util.List;

import br.net.meditec.shared.dto.EventoDTO;

/**
 * @author: Carlos A Becker
 */
@GenDispatch(isSecure = false)
public class SalvarEvento {

  @In(1)
  @Out(1)
  EventoDTO evento;

  @Out(2)
  boolean ok;

  @Out(3)
  List<String> msg;


}
