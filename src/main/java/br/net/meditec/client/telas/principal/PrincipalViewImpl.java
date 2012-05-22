package br.net.meditec.client.telas.principal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import com.github.gwtbootstrap.client.ui.Alert;
import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.gwtplatform.mvp.client.ViewImpl;

import br.net.meditec.client.events.ClearMsgsEvent;
import br.net.meditec.client.events.ShowMsgEvent;

/**
 * @author: Carlos A Becker
 */
public class PrincipalViewImpl extends ViewImpl implements PrincipalPresenter.PrincipalView {

  private Widget w;

  @UiField
  FluidContainer sections;

  @UiField
  FluidContainer msgs;

  public PrincipalViewImpl() {
    w = ourUiBinder.createAndBindUi(this);
  }

  public Widget asWidget() {
    return w;
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    if (slot == PrincipalPresenter.CONTEUDO) {
      sections.clear();
      sections.add(content);
    } else {
      super.setInSlot(slot, content);
    }
  }

  @Override
  public void onClearMsgs(ClearMsgsEvent event) {
    msgs.clear();
  }

  @Override
  public void onShowMsg(ShowMsgEvent event) {
    Alert a = new Alert();
    switch (event.getAlertType()) {
      case ERROR:
        a.setHeading("Erro!");
        a.setType(event.getAlertType());
        break;

      case INFO:
        a.setHeading("Informação:");
        a.setType(event.getAlertType());
        break;

      case WARNING:
        a.setHeading("Atenção!");
        a.setType(event.getAlertType());
        break;

      case SUCCESS:
        a.setHeading("Sucesso!");
        a.setType(event.getAlertType());
        break;

      default:
        a.setHeading("");
        break;
    }

    a.setText(event.getMsg());
    msgs.add(a);
  }

  interface PrincipalViewImplUiBinder extends UiBinder<HTMLPanel, PrincipalViewImpl> {

  }

  private static
  PrincipalViewImplUiBinder
      ourUiBinder =
      GWT.create(PrincipalViewImplUiBinder.class);
}