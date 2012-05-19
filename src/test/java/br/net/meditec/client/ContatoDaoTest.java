package br.net.meditec.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nnsoft.guice.junice.JUniceRunner;
import org.nnsoft.guice.junice.annotation.GuiceModules;
import static org.junit.Assert.*;

import javax.inject.Inject;

import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.inject.PersistenceModule;
import br.net.meditec.server.model.Contato;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:29
 */
//@RunWith(JUniceRunner.class)
//@GuiceModules(modules = PersistenceTestModule.class)
public class ContatoDaoTest {

//  @Inject
  Injector i = PersistenceTestModule.getInjector();

  private ContatoDao dao = i.getInstance(ContatoDao.class);

  @Test
  public void testSave() throws Exception {
    Contato contato = new Contato("Carlos Alexandro", "Becker", "9903-4343", "caarlos0@gmail.com");
    dao.save(contato);
    assertNotNull(contato.getId());
  }
}
