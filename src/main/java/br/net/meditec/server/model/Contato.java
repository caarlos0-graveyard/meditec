package br.net.meditec.server.model;

import org.apache.bval.constraints.Email;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Bean de Contato.
 *
 * @author Carlos A Becker
 */
@Entity
public class Contato implements Bean {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "Nome null")
  @Size(min = 6, max = 90, message = "Nome deve ter entre 6 e 90 caracteres.")
  private String nome;

  @Size(min = 3, max = 30, message = "Sobrenome deve ter entre 3 e 30 caracteres.")
  private String sobrenome;

  @NotNull(message = "Numero nao pode ser null.")
  private String numero;

  @Email(message = "Email invalido.")
  private String email;

  @Temporal(value = TemporalType.DATE)
  private Date dataNascimento;

  public Contato() {
  }

  public Contato(String nome, String sobrenome, String numero, String email, Date dataNascimento) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.numero = numero;
    this.email = email;
    this.dataNascimento = (Date) dataNascimento.clone();
  }

  public Contato(Long id, String email, String numero, String sobrenome, String nome,
                 Date dataNascimento) {
    this.email = email;
    this.numero = numero;
    this.sobrenome = sobrenome;
    this.nome = nome;
    this.id = id;
    this.dataNascimento = (Date) dataNascimento.clone();
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

  public String getNome() {
    return nome;
  }

  public Date getDataNascimento() {
    return (Date) dataNascimento.clone();
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = (Date) dataNascimento.clone();
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

    if (dataNascimento != null ? !dataNascimento.equals(contato.dataNascimento)
                               : contato.dataNascimento != null) {
      return false;
    }
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
    result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Contato{" +
           "dataNascimento=" + dataNascimento +
           ", id=" + id +
           ", nome='" + nome + '\'' +
           ", sobrenome='" + sobrenome + '\'' +
           ", numero='" + numero + '\'' +
           ", email='" + email + '\'' +
           '}';
  }
}
