package br.net.meditec.server.dao;

import br.net.meditec.server.model.Contato;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:11
 */
public class ContatoDao extends AbstractDao<Contato> {

    @Inject
    public ContatoDao(Provider<EntityManager> emp) {
        super(emp, Contato.class);
    }
}
