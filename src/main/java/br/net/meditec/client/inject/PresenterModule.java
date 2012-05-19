package br.net.meditec.client.inject;

import br.net.meditec.client.telas.home.HomePresenter;
import br.net.meditec.client.telas.home.HomeViewImpl;
import br.net.meditec.client.telas.principal.PrincipalPresenter;
import br.net.meditec.client.telas.principal.PrincipalViewImpl;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class PresenterModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(MeditecPlaceManager.class));

        bindConstant().annotatedWith(DefaultPlace.class).to(Tokens.home);

        bindPresenter(PrincipalPresenter.class, PrincipalPresenter.PrincipalView.class, PrincipalViewImpl.class, PrincipalPresenter.PrincipalProxy.class);
        bindPresenter(HomePresenter.class, HomePresenter.HomeView.class, HomeViewImpl.class, HomePresenter.HomeProxy.class);
    }

}
