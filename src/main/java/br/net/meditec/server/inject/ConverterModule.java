package br.net.meditec.server.inject;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import br.net.meditec.server.converter.AbstractConverter;
import br.net.meditec.server.converter.ContatoConverter;
import br.net.meditec.server.converter.EventoConverter;
import br.net.meditec.server.model.Contato;
import br.net.meditec.server.model.Evento;
import br.net.meditec.shared.dto.ContatoDTO;
import br.net.meditec.shared.dto.EventoDTO;

/**
 * Modulo com os binds dos converters.
 *
 * @author Carlos A Becker
 */
public class ConverterModule extends AbstractModule {

  @Override
  protected void configure() {

    /*
     * usando type literal, posso injetar o converter direto, sem utilizar sua classe específica :)
     */
    bind(new TypeLiteral<AbstractConverter<Contato, ContatoDTO>>() {
    }).to(ContatoConverter.class);

    bind(new TypeLiteral<AbstractConverter<Evento, EventoDTO>>() {
    }).to(EventoConverter.class);
  }
}
