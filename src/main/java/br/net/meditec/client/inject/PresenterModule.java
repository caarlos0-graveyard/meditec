package br.net.meditec.client.inject;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

import br.net.meditec.client.telas.contato.CadastroContatoPresenter;
import br.net.meditec.client.telas.contato.CadastroContatoViewImpl;
import br.net.meditec.client.telas.contato.ListaContatosPresenter;
import br.net.meditec.client.telas.contato.ListaContatosViewImpl;
import br.net.meditec.client.telas.home.HomePresenter;
import br.net.meditec.client.telas.home.HomeViewImpl;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.client.telas.principal.PrincipalViewImpl;

/**
 * GINModule com o binding de todas as presenters da aplicação.
 *
 * @author Carlos A Becker
 */
public class PresenterModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new DefaultModule(MeditecPlaceManager.class));

    bindConstant().annotatedWith(DefaultPlace.class).to(Tokens.home);

    bindPresenter(PrincipalPresenter.class, PrincipalPresenter.PrincipalView.class,
                  PrincipalViewImpl.class, PrincipalPresenter.PrincipalProxy.class);

    bindPresenter(HomePresenter.class, HomePresenter.HomeView.class, HomeViewImpl.class,
                  HomePresenter.HomeProxy.class);

    bindPresenter(CadastroContatoPresenter.class,
                  CadastroContatoPresenter.CadastroContatoView.class,
                  CadastroContatoViewImpl.class,
                  CadastroContatoPresenter.CadastroContatoProxy.class);

    bindPresenter(ListaContatosPresenter.class, ListaContatosPresenter.ListaContatosView.class,
                  ListaContatosViewImpl.class, ListaContatosPresenter.ListaContatosProxy.class);
  }

}
