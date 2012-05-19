package br.net.meditec.shared.dto;

import java.util.Date;

/**
 * @author: Carlos A Becker
 */
public class ContatoDTO implements DTO {

  private Long id;
  private String nome;
  private String sobrenome;
  private String numero;
  private String email;
  private Date dataNascimento;

  public ContatoDTO() {
  }

  public ContatoDTO(String nome, String sobrenome, String numero, String email,
                    Date dataNascimento) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.numero = numero;
    this.email = email;
    this.dataNascimento = dataNascimento;
  }

  public ContatoDTO(Long id, String email, String numero, String sobrenome, String nome,
                    Date dataNascimento) {
    this.email = email;
    this.numero = numero;
    this.sobrenome = sobrenome;
    this.nome = nome;
    this.id = id;
    this.dataNascimento = dataNascimento;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ContatoDTO that = (ContatoDTO) o;

    if (dataNascimento != null ? !dataNascimento.equals(that.dataNascimento)
                               : that.dataNascimento != null) {
      return false;
    }
    if (email != null ? !email.equals(that.email) : that.email != null) {
      return false;
    }
    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (nome != null ? !nome.equals(that.nome) : that.nome != null) {
      return false;
    }
    if (numero != null ? !numero.equals(that.numero) : that.numero != null) {
      return false;
    }
    if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) {
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
    result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContatoDTO{" +
           "dataNascimento=" + dataNascimento +
           ", id=" + id +
           ", nome='" + nome + '\'' +
           ", sobrenome='" + sobrenome + '\'' +
           ", numero='" + numero + '\'' +
           ", email='" + email + '\'' +
           '}';
  }
}
