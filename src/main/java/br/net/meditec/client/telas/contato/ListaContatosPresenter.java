package br.net.meditec.client.telas.contato;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import java.util.List;

import br.net.meditec.client.events.ShowMsgEvent;
import br.net.meditec.client.inject.Tokens;
import br.net.meditec.client.telas.ClickEnterUpHandler;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.shared.commands.BuscarContatoAction;
import br.net.meditec.shared.commands.BuscarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class ListaContatosPresenter extends
                                    Presenter<ListaContatosPresenter.ListaContatosView, ListaContatosPresenter.ListaContatosProxy> {

  private final DispatchAsync dispatcher;

  @Inject
  public ListaContatosPresenter(EventBus eventBus, ListaContatosView view,
                                ListaContatosProxy proxy, DispatchAsync dispatcher) {
    super(eventBus, view, proxy);
    this.dispatcher = dispatcher;
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, PrincipalPresenter.CONTEUDO, this);
  }

  @Override
  protected void onBind() {
    super.onBind();
    getView().addBuscarHandler(new ClickEnterUpHandler() {
      @Override
      public void doSalvar() {
        dispatcher.execute(
            new BuscarContatoAction(getView().campo().getValue()),
            new AsyncCallback<BuscarContatoResult>() {
              @Override
              public void onFailure(Throwable caught) {
                ShowMsgEvent.fire(ListaContatosPresenter.this,
                                  "Erro: " + caught.getLocalizedMessage(),
                                  AlertType.ERROR);
              }

              @Override
              public void onSuccess(BuscarContatoResult result) {
                getView().setContatos(result.getContatos());
              }
            });
      }
    });
  }

  public interface ListaContatosView extends View {

    void setContatos(List<ContatoDTO> contatos);

    HasValue<String> campo();

    void addBuscarHandler(ClickEnterUpHandler handler);
  }

  @NameToken(Tokens.consultaContato)
  @ProxyCodeSplit
  public interface ListaContatosProxy extends ProxyPlace<ListaContatosPresenter> {

  }

}
