package br.net.meditec.shared.commands;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Carregar contatos pelo ID.
 *
 * @author Carlos A Becker
 */
@GenDispatch(isSecure = false)
public class LoadContato {
  @In(1)
  Long id;

  @Out(1)
  ContatoDTO contato;
}
