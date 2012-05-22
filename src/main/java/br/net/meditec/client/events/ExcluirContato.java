package br.net.meditec.client.events;

import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.dispatch.annotation.In;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Quando disparado, é tratado pela {@link br.net.meditec.client.telas.contato.CadastroContatoPresenter},
 * e irá excluir o registro.
 *
 * @author Carlos A Becker
 */
@GenEvent
public class ExcluirContato {

  @In(1)
  ContatoDTO contato;

}
