package br.net.meditec.client.telas.contato;

import com.google.web.bindery.event.shared.EventBus;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import javax.inject.Inject;

import br.net.meditec.client.inject.Tokens;
import br.net.meditec.client.telas.principal.PrincipalPresenter;

/**
 * @author: Carlos A Becker
 */
public class CadastroContatoPresenter extends
                                      Presenter<CadastroContatoPresenter.CadastroContatoView, CadastroContatoPresenter.CadastroContatoProxy> {

  @Inject
  public CadastroContatoPresenter(EventBus eventBus, CadastroContatoView view,
                                  CadastroContatoProxy proxy) {
    super(eventBus, view, proxy);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, PrincipalPresenter.CONTEUDO, this);
  }

  public interface CadastroContatoView extends View {

  }

  @ProxyCodeSplit
  @NameToken(Tokens.cadastroContato)
  public interface CadastroContatoProxy extends ProxyPlace<CadastroContatoPresenter> {

  }
}
