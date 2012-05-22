package br.net.meditec.client.telas.contato;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import java.util.List;

import br.net.meditec.client.events.AtualizarListaDeContatosEvent;
import br.net.meditec.client.events.EditarContatoEvent;
import br.net.meditec.client.events.ExcluirContatoEvent;
import br.net.meditec.client.events.ShowMsgEvent;
import br.net.meditec.client.inject.Tokens;
import br.net.meditec.client.telas.ClickEnterUpHandler;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.shared.commands.BuscarContatoAction;
import br.net.meditec.shared.commands.BuscarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author Carlos A Becker
 */
public class ListaContatosPresenter extends
                                    Presenter<ListaContatosPresenter.ListaContatosView, ListaContatosPresenter.ListaContatosProxy>
    implements AtualizarListaDeContatosEvent.AtualizarListaDeContatosHandler {

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

    // adiciona os handler no "onEnter" do campo de busca, e no click do botão.
    getView().addBuscarHandler(new ClickEnterUpHandler() {
      @Override
      public void doAction() {
        doPesquisar();
      }
    });

    // adiciona o Handler no botão de editar.
    getView().addEditarHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        // evento é tratado na presenter de cadastro de contatos
        EditarContatoEvent.fire(ListaContatosPresenter.this, getView().getContatoSelecionado());
      }
    });

    // adiciona o handler no botão excluir.
    getView().addExcluirHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        // evento é tratado na presenter de cadastro de contatos
        ExcluirContatoEvent.fire(ListaContatosPresenter.this, getView().getContatoSelecionado());
      }
    });
  }

  private void doPesquisar() {
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

  @ProxyEvent
  @Override
  public void onAtualizarListaDeContatos(AtualizarListaDeContatosEvent event) {
    doPesquisar();
  }

  public interface ListaContatosView extends View {

    void setContatos(List<ContatoDTO> contatos);

    HasValue<String> campo();

    void addBuscarHandler(ClickEnterUpHandler handler);

    ContatoDTO getContatoSelecionado();

    void addEditarHandler(ClickHandler handler);

    void addExcluirHandler(ClickHandler handler);
  }

  @NameToken(Tokens.consultaContato)
  @ProxyCodeSplit
  public interface ListaContatosProxy extends ProxyPlace<ListaContatosPresenter> {

  }

}
