package br.net.meditec.shared.commands;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;

import java.util.List;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Excluir Contatos
 *
 * @author Carlos A Becker
 */
@GenDispatch(isSecure = false)
public class ExcluirContato {

  @In(1)
  ContatoDTO contato;

  @Out(1)
  List<String> mensagens;

  @Out(2)
  boolean ok;

}
