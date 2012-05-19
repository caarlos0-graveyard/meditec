package br.net.meditec.server.converter;

import br.net.meditec.server.model.Contato;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class ContatoConverter extends Converter<Contato, ContatoDTO> {

  @Override
  public Contato toBean(ContatoDTO dto) {
    return new Contato(dto.getId(), dto.getEmail(), dto.getNumero(), dto.getSobrenome(),
                       dto.getNome());

  }

  @Override
  public ContatoDTO toDTO(Contato bean) {
    return new ContatoDTO(bean.getId(), bean.getEmail(), bean.getNumero(), bean.getSobrenome(),
                          bean.getNome());
  }
}
