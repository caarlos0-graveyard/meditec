package br.net.meditec.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Carlos A Becker
 * @since 10/05/12 21:03
 */
@Entity
public class Contato implements Bean {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;
  private String sobrenome;
  private String numero;
  private String email;

  public Contato() {
  }

  public Contato(String nome, String sobrenome, String numero, String email) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.numero = numero;
    this.email = email;
  }

  public Contato(Long id, String email, String numero, String sobrenome, String nome) {
    this.email = email;
    this.numero = numero;
    this.sobrenome = sobrenome;
    this.nome = nome;
    this.id = id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }


  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Contato contato = (Contato) o;

    if (email != null ? !email.equals(contato.email) : contato.email != null) {
      return false;
    }
    if (id != null ? !id.equals(contato.id) : contato.id != null) {
      return false;
    }
    if (nome != null ? !nome.equals(contato.nome) : contato.nome != null) {
      return false;
    }
    if (numero != null ? !numero.equals(contato.numero) : contato.numero != null) {
      return false;
    }
    if (sobrenome != null ? !sobrenome.equals(contato.sobrenome) : contato.sobrenome != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
    result = 31 * result + (numero != null ? numero.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
