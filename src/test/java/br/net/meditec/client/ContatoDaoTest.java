package br.net.meditec.client;

import com.google.inject.Injector;

import org.junit.Test;

import java.util.Date;

import br.net.meditec.server.dao.ContatoDao;
import br.net.meditec.server.model.Contato;

import static org.junit.Assert.assertNotNull;

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
    Contato contato = new Contato("Chuckkkkkk", "Norrissss", "9903-4343", "gmail@chucknorris.com",
                                  new Date());
    dao.save(contato);
    assertNotNull(contato.getId());
  }
}
