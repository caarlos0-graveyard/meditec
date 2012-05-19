package br.net.meditec.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.gwtplatform.mvp.client.DelayedBindRegistry;

import br.net.meditec.client.inject.MeditecGinjector;

/**
 * @author: Carlos A Becker
 */
public class Meditec implements EntryPoint {

  public final MeditecGinjector injector = GWT.create(MeditecGinjector.class);

  public void onModuleLoad() {
    DelayedBindRegistry.bind(injector);
    injector.getPlaceManager().revealDefaultPlace();
  }
}
