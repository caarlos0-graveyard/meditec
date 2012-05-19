package br.net.meditec.client.telas.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author: Carlos A Becker
 */
public class HomeViewImpl extends ViewImpl implements HomePresenter.HomeView {

  private Widget w;

  public Widget asWidget() {
    return w;
  }

  interface HomeViewImplUiBinder extends UiBinder<HTMLPanel, HomeViewImpl> {

  }

  private static HomeViewImplUiBinder ourUiBinder = GWT.create(HomeViewImplUiBinder.class);

  public HomeViewImpl() {
    w = ourUiBinder.createAndBindUi(this);

  }
}