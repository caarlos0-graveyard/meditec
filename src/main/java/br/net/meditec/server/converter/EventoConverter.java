package br.net.meditec.server.converter;

import br.net.meditec.server.model.Evento;
import br.net.meditec.shared.dto.EventoDTO;

/**
 * @author: Carlos A Becker
 */
public class EventoConverter extends AbstractConverter<Evento, EventoDTO> {

  @Override
  public Evento toBean(EventoDTO dto) {
    return new Evento(dto.getId(), dto.getNome());
  }

  @Override
  public EventoDTO toDTO(Evento bean) {
    return new EventoDTO(bean.getId(), bean.getNome());
  }
}
