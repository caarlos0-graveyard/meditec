package br.net.meditec.client.telas.principal;

import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Created with IntelliJ IDEA.
 * User: carlos
 * Date: 17/05/12
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class PrincipalViewImpl extends ViewImpl implements PrincipalPresenter.PrincipalView {

    private Widget w;

    @UiField
    FluidContainer sections;

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

    interface PrincipalViewImplUiBinder extends UiBinder<HTMLPanel, PrincipalViewImpl> {
    }

    private static PrincipalViewImplUiBinder ourUiBinder = GWT.create(PrincipalViewImplUiBinder.class);
}