package br.net.meditec.shared.commands;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import java.util.List;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
@GenDispatch(isSecure = false)
public class SalvarContato {

  @In(1)
  ContatoDTO contato;

  @Out(1)
  boolean ok;

  @Out(2)
  List<String> mensagem;

}
