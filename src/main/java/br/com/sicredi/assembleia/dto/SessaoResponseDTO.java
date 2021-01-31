package br.com.sicredi.assembleia.dto;

import java.time.LocalDateTime;

public class SessaoResponseDTO {
  private Long id;
  private Long pautaId;
  private LocalDateTime inicio;
  private LocalDateTime fim;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPautaId() {
    return pautaId;
  }

  public void setPautaId(Long pautaId) {
    this.pautaId = pautaId;
  }

  public LocalDateTime getInicio() {
    return inicio;
  }

  public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
  }

  public LocalDateTime getFim() {
    return fim;
  }

  public void setFim(LocalDateTime fim) {
    this.fim = fim;
  }
}
