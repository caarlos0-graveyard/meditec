package br.net.meditec.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

import br.net.meditec.server.inject.PersistenceModule;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:45
 */
public class PersistenceTestModule {

    private static Injector injector;

    public static Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new PersistenceModule());
            PersistService service = injector.getInstance(PersistService.class);
            service.start();
        }
        return injector;
    }

}
