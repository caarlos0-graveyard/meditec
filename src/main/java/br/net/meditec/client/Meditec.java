package br.net.meditec.client;

import br.net.meditec.client.inject.MeditecGinjector;
import br.net.meditec.client.telas.principal.PrincipalViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Meditec implements EntryPoint {
    public final MeditecGinjector injector = GWT.create(MeditecGinjector.class);

    public void onModuleLoad() {
        DelayedBindRegistry.bind(injector);
        injector.getPlaceManager().revealDefaultPlace();
    }
}
