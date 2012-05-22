package br.net.meditec.client.events;

import com.gwtplatform.dispatch.annotation.GenEvent;

/**
 * Quando disparado, é tratado pela {@link br.net.meditec.client.telas.contato.ListaContatosPresenter},
 * e busca a lista atualizada do banco, utilizando como parametro a busca anterior.
 *
 * @author Carlos A Becker
 */
@GenEvent
public class AtualizarListaDeContatos {

}
