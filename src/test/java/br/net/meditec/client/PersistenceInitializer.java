package br.net.meditec.client;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:48
 */
public class PersistenceInitializer {

  @Inject
  private PersistService service;

  public void init() {
    if(service == null)
    {
      System.out.println("FUUU");
      return;
    }
    service.start();
  }
}
