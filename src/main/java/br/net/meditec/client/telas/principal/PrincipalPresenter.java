package br.net.meditec.client.telas.principal;

import br.net.meditec.client.telas.home.HomePresenter;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import javax.inject.Inject;

/**
 */
public class PrincipalPresenter extends Presenter<PrincipalPresenter.PrincipalView, PrincipalPresenter.PrincipalProxy> {

    private final HomePresenter home;

    @Inject
    public PrincipalPresenter(EventBus eventBus, PrincipalView view, PrincipalProxy proxy, HomePresenter home) {
        super(eventBus, view, proxy);
        this.home = home;
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> CONTEUDO = new GwtEvent.Type<RevealContentHandler<?>>();

    @Override
    protected void onReveal() {
        super.onReveal();
        setInSlot(CONTEUDO, home);
    }

    @ProxyStandard
    public interface PrincipalProxy extends Proxy<PrincipalPresenter> {
    }

    public interface PrincipalView extends View {

    }

}
