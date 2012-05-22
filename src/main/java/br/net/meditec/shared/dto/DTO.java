package br.net.meditec.shared.dto;

import java.io.Serializable;

/**
 * Interface que define um DTO.
 *
 * @author Carlos A Becker
 */
public interface DTO extends Serializable {

  void setId(Long id);

  Long getId();
}
