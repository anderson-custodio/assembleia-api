package br.com.sicredi.assembleia.dto;

public class EncerraSessaoDTO {

  private Long sessaoId;
  private Long pautaId;

  public Long getSessaoId() {
    return sessaoId;
  }

  public void setSessaoId(Long sessaoId) {
    this.sessaoId = sessaoId;
  }

  public Long getPautaId() {
    return pautaId;
  }

  public void setPautaId(Long pautaId) {
    this.pautaId = pautaId;
  }
}
