package br.net.meditec.client.telas.principal;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;

import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import javax.inject.Inject;

import br.net.meditec.client.events.ClearMsgsEvent;
import br.net.meditec.client.events.ShowMsgEvent;
import br.net.meditec.client.telas.home.HomePresenter;

/**
 * @author: Carlos A Becker
 */
public class PrincipalPresenter
    extends Presenter<PrincipalPresenter.PrincipalView, PrincipalPresenter.PrincipalProxy>
    implements ShowMsgEvent.ShowMsgHandler, ClearMsgsEvent.ClearMsgsHandler {

  private final HomePresenter home;

  @Inject
  public PrincipalPresenter(EventBus eventBus, PrincipalView view, PrincipalProxy proxy,
                            HomePresenter home) {
    super(eventBus, view, proxy);
    this.home = home;
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  @ContentSlot
  public static final
  GwtEvent.Type<RevealContentHandler<?>>
      CONTEUDO =
      new GwtEvent.Type<RevealContentHandler<?>>();

  @Override
  protected void onReveal() {
    super.onReveal();
    setInSlot(CONTEUDO, home);
  }

  @ProxyEvent
  @Override
  public void onClearMsgs(ClearMsgsEvent event) {
    getView().onClearMsgs(event);
  }

  @ProxyEvent
  @Override
  public void onShowMsg(ShowMsgEvent event) {
    getView().onShowMsg(event);
  }


  @ProxyStandard
  public interface PrincipalProxy extends Proxy<PrincipalPresenter> {

  }

  public interface PrincipalView extends View, ClearMsgsEvent.ClearMsgsHandler,
                                         ShowMsgEvent.ShowMsgHandler {

  }

}
