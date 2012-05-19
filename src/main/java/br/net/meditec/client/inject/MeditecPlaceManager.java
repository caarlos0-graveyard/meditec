package br.net.meditec.client.inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: carlos
 * Date: 18/05/12
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class MeditecPlaceManager extends PlaceManagerImpl {

    private final PlaceRequest defaultPlaceRequest;

    @Inject
    public MeditecPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, @DefaultPlace String defaultNameToken) {
        super(eventBus, tokenFormatter);
        this.defaultPlaceRequest = new PlaceRequest(defaultNameToken);
    }


    public void revealDefaultPlace() {
        revealPlace(defaultPlaceRequest);
    }
}
