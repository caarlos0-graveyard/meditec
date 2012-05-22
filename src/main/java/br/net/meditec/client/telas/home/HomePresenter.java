package br.net.meditec.client.telas.home;

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
 * @author Carlos A Becker
 */
public class HomePresenter extends Presenter<HomePresenter.HomeView, HomePresenter.HomeProxy> {

  @Inject
  public HomePresenter(EventBus eventBus, HomeProxy view, HomeView proxy) {
    super(eventBus, proxy, view);
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, PrincipalPresenter.CONTEUDO, this);
  }

  @NameToken(Tokens.home)
  @ProxyCodeSplit
  public interface HomeProxy extends ProxyPlace<HomePresenter> {

  }

  public interface HomeView extends View {

  }
}
