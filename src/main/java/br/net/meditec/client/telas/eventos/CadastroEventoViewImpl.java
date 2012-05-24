package br.net.meditec.client.telas.eventos;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author: Carlos A Becker
 */
public class CadastroEventoViewImpl extends ViewImpl
  implements CadastroEventoPresenter.CadastroEventoView {

  private Widget w;

  @UiField
  TextBox nome;

  @UiField
  Button salvar;

  public CadastroEventoViewImpl() {
    w = ourUiBinder.createAndBindUi(this);
  }

  @Override
  public HasValue<String> nome() {
    return nome;
  }

  @Override
  public void addSalvarHandler(ClickHandler handler) {
    salvar.addClickHandler(handler);
  }

  @Override
  public Widget asWidget() {
    return w;
  }

  interface CadastroEventoViewImplUiBinder
      extends UiBinder<HTMLPanel, CadastroEventoViewImpl> {
  }

  private static
  CadastroEventoViewImplUiBinder
      ourUiBinder =
      GWT.create(CadastroEventoViewImplUiBinder.class);
}