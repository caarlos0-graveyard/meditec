package br.net.meditec.server.model;

import java.io.Serializable;

/**
 * @author Carlos A Becker
 * @since 10/05/12 20:54
 */
public interface Bean extends Serializable {

  void setId(Long id);

  Long getId();
}
