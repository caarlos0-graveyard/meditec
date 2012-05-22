package br.net.meditec.client.events;

import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.dispatch.annotation.In;

import br.net.meditec.shared.dto.ContatoDTO;

/**
 * Envia o contato atual para a {@link br.net.meditec.client.telas.contato.CadastroContatoPresenter},
 * carregando-o nos campos, permitindo assim a edição do registro.
 *
 * @author Carlos A Becker
 */
@GenEvent
public class EditarContato {
  @In(1)
  ContatoDTO contato;
}
