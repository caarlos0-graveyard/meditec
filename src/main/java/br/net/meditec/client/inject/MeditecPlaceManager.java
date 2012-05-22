package br.net.meditec.client.inject;

import com.google.web.bindery.event.shared.EventBus;

import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

import javax.inject.Inject;

/**
 * PlaceManager personalizado, com o tratamento para a @DefaultPlace.
 *
 * @author Carlos A Becker
 */
public class MeditecPlaceManager extends PlaceManagerImpl {

  private final PlaceRequest defaultPlaceRequest;

  @Inject
  public MeditecPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter,
                             @DefaultPlace String defaultNameToken) {
    super(eventBus, tokenFormatter);
    this.defaultPlaceRequest = new PlaceRequest(defaultNameToken);
  }

  public void revealDefaultPlace() {
    revealPlace(defaultPlaceRequest);
  }
}
