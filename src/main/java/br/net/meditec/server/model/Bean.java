package br.net.meditec.server.model;

import java.io.Serializable;

/**
 * Interface que define um Bean.
 *
 * @author Carlos A Becker
 */
public interface Bean extends Serializable {

  void setId(Long id);

  Long getId();
}
