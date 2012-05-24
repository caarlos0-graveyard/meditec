package br.net.meditec.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: Carlos A Becker
 */
@Entity
public class Evento implements Bean {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;

  public Evento() {

  }

  public Evento(String nome) {
    this.nome = nome;
  }

  public Evento(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Evento evento = (Evento) o;

    if (id != null ? !id.equals(evento.id) : evento.id != null) {
      return false;
    }
    if (nome != null ? !nome.equals(evento.nome) : evento.nome != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    return result;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
