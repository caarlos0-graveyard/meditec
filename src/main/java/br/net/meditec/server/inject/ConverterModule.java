package br.net.meditec.server.inject;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import br.net.meditec.server.converter.ContatoConverter;
import br.net.meditec.server.converter.Converter;
import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author Carlos A Becker
 */
public class ConverterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(new TypeLiteral<Converter<Contato, ContatoDTO>>() {
    }).to(ContatoConverter.class);
  }
}
