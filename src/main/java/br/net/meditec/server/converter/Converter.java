package br.net.meditec.server.converter;

import java.util.ArrayList;
import java.util.List;

import br.net.meditec.server.model.Bean;
import br.net.meditec.shared.dto.DTO;

/**
 * @author: Carlos A Becker
 */
public abstract class Converter<B extends Bean, D extends DTO> {

  public abstract B toBean(D dto);

  public abstract D toDTO(B bean);

  public List<DTO> toDTOList(List<B> beans) {
    List<DTO> dtos = new ArrayList<DTO>();
    for (B bean : beans) {
      dtos.add(toDTO(bean));
    }
    return dtos;
  }

  public List<B> toBeanList(List<D> dtos) {
    List<B> beans = new ArrayList<B>();
    for (D dto : dtos) {
      beans.add(toBean(dto));
    }
    return beans;
  }

}
