package br.net.meditec.client.telas.contato;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;

import com.github.gwtbootstrap.client.ui.Form;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import java.util.Date;

import javax.inject.Inject;

import br.net.meditec.client.inject.Tokens;
import br.net.meditec.client.telas.ClickEnterUpHandler;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.shared.commands.SalvarContatoAction;
import br.net.meditec.shared.commands.SalvarContatoResult;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class CadastroContatoPresenter extends
                                      Presenter<CadastroContatoPresenter.CadastroContatoView, CadastroContatoPresenter.CadastroContatoProxy> {

  private ContatoDTO contato = new ContatoDTO();
  private final DispatchAsync dispatcher;

  @Inject
  public CadastroContatoPresenter(EventBus eventBus, CadastroContatoView view,
                                  CadastroContatoProxy proxy, DispatchAsync dispatcher) {
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
    getView().addSubmitHandler(new Form.SubmitHandler() {
      public void onSubmit(Form.SubmitEvent event) {
        salvar();
      }
    });
    getView().addSalvarHandler(new ClickEnterUpHandler() {
      @Override
      public void doSalvar() {
        salvar();
      }
    });
    getView().addCancelarHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        Window.alert("MAOEEE");
      }
    });
  }

  private void salvar() {
    Window.alert("MA SALVANDO!!!");
    populaContato();
    dispatcher.execute(new SalvarContatoAction(contato), new AsyncCallback<SalvarContatoResult>() {
      @Override
      public void onFailure(Throwable caught) {
        Window.alert("MA DEU ERRO :/ ::  " + caught.getMessage());
      }

      @Override
      public void onSuccess(SalvarContatoResult result) {
        for (String msg : result.getMensagem()) {
          Window.alert(msg);
        }
      }
    });
  }

  private void populaContato() {
    CadastroContatoView v = getView();
    contato.setNome(v.nome().getValue());
    contato.setSobrenome(v.sobrenome().getValue());
    contato.setEmail(v.email().getValue());
    contato.setNumero(v.numero().getValue());
    contato.setDataNascimento(v.dataNascimento().getValue());
  }

  public interface CadastroContatoView extends View {

    void addSubmitHandler(Form.SubmitHandler handler);

    void addSalvarHandler(ClickEnterUpHandler handler);

    void addCancelarHandler(ClickHandler handler);

    HasValue<String> nome();

    HasValue<String> sobrenome();

    HasValue<String> email();

    HasValue<String> numero();

    HasValue<Date> dataNascimento();
  }

  @ProxyCodeSplit
  @NameToken(Tokens.cadastroContato)
  public interface CadastroContatoProxy extends ProxyPlace<CadastroContatoPresenter> {

  }
}
