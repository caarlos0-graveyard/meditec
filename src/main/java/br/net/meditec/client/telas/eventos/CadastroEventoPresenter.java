package br.net.meditec.client.telas.eventos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasValue;
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
public class CadastroEventoPresenter
    extends Presenter<CadastroEventoPresenter.CadastroEventoView,
      CadastroEventoPresenter.CadastroEventoProxy> {

  @Inject
  public CadastroEventoPresenter(EventBus eventBus, CadastroEventoView view,
                                 CadastroEventoProxy proxy) {
    super(eventBus, view, proxy);
  }

  @Override
  protected void onBind() {
    super.onBind();
    getView().addSalvarHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        doSalvar();

      }
    });
  }

  private void doSalvar() {
    String nome = getView().nome().getValue();

  }


  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, PrincipalPresenter.CONTEUDO, this);
  }

  public interface CadastroEventoView extends View{
    HasValue<String> nome();
    void  addSalvarHandler(ClickHandler handler);
  }

  @NameToken(Tokens.cadastroEvento)
  @ProxyCodeSplit
  public interface CadastroEventoProxy
      extends ProxyPlace<CadastroEventoPresenter>{

  }

}
