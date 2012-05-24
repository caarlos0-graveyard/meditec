package br.net.meditec.shared.dto;

/**
 * @author: Carlos A Becker
 */
public class EventoDTO implements DTO {

  private Long id;
  private String nome;


  public EventoDTO() {
  }

  public EventoDTO(String nome) {
    this.nome = nome;
  }

  public EventoDTO(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    EventoDTO eventoDTO = (EventoDTO) o;

    if (id != null ? !id.equals(eventoDTO.id) : eventoDTO.id != null) {
      return false;
    }
    if (nome != null ? !nome.equals(eventoDTO.nome) : eventoDTO.nome != null) {
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

  @Override
  public String toString() {
    return "EventoDTO{" +
           "id=" + id +
           ", nome='" + nome + '\'' +
           '}';
  }
}
