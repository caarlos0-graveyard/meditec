package br.net.meditec.server.inject;

import br.net.meditec.server.dao.ContatoDao;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:13
 */
public class PersistenceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaPersistModule("meditec"));
        bind(ContatoDao.class);
    }
}
