package br.net.meditec.shared.commands;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import java.util.List;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author Carlos A Becker
 */
@GenDispatch(isSecure = false)
public class BuscarContato {
  @In(1)
  String param;

  @Out(1)
  List<ContatoDTO> contatos;
}
