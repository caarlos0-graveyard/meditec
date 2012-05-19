package br.net.meditec.client.inject;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import br.net.meditec.client.telas.home.HomePresenter;
import br.net.meditec.client.telas.principal.PrincipalPresenter;


/**
 * @author: Carlos A Becker
 */
@GinModules({DispatchAsyncModule.class, PresenterModule.class})
public interface MeditecGinjector extends Ginjector {

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  DispatchAsync getDispatcher();

  Provider<PrincipalPresenter> getPrincipalPresenter();

  AsyncProvider<HomePresenter> getHomePresenter();


}
