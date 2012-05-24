package br.net.meditec.client.telas.eventos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import javax.inject.Inject;

import br.net.meditec.client.events.ClearMsgsEvent;
import br.net.meditec.client.events.ShowMsgEvent;
import br.net.meditec.client.inject.Tokens;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.shared.commands.SalvarEventoAction;
import br.net.meditec.shared.commands.SalvarEventoResult;
import br.net.meditec.shared.dto.EventoDTO;

/**
 * @author: Carlos A Becker
 */
public class CadastroEventoPresenter
    extends Presenter<CadastroEventoPresenter.CadastroEventoView,
    CadastroEventoPresenter.CadastroEventoProxy> {

  private EventoDTO evento = new EventoDTO();

  private final DispatchAsync dipatacher;

  @Inject
  public CadastroEventoPresenter(EventBus eventBus, CadastroEventoView view,
                                 CadastroEventoProxy proxy, DispatchAsync dipatacher) {
    super(eventBus, view, proxy);
    this.dipatacher = dipatacher;
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
    ClearMsgsEvent.fire(this);
    popularEvento();
    dipatacher.execute(new SalvarEventoAction(evento), new AsyncCallback<SalvarEventoResult>() {
      @Override
      public void onFailure(Throwable caught) {
        ShowMsgEvent.fire(CadastroEventoPresenter.this, "Erro: " + caught.getLocalizedMessage(),
                          AlertType.ERROR);
      }

      @Override
      public void onSuccess(SalvarEventoResult result) {
        for (String msg : result.getMsg()) {
          ShowMsgEvent.fire(CadastroEventoPresenter.this, msg,
                            result.isOk() ? AlertType.SUCCESS : AlertType.ERROR);
        }
        evento = result.getEvento();
      }
    });
  }

  private void popularTela() {
    if (evento == null) {
      evento = new EventoDTO();
    }
    getView().nome().setValue(evento.getNome());
  }

  private void popularEvento() {
    evento.setNome(getView().nome().getValue());
  }


  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(this, PrincipalPresenter.CONTEUDO, this);
  }

  public interface CadastroEventoView extends View {

    HasValue<String> nome();

    void addSalvarHandler(ClickHandler handler);
  }

  @NameToken(Tokens.cadastroEvento)
  @ProxyCodeSplit
  public interface CadastroEventoProxy
      extends ProxyPlace<CadastroEventoPresenter> {

  }

}
