package br.com.sicredi.assembleia.dto;

public class ResultadoDTO {

  private Long pautaId;
  private Long sessaoId;
  private String descricaoPauta;
  private Long votosSim;
  private Long votosNao;

  public Long getPautaId() {
    return pautaId;
  }

  public void setPautaId(Long pautaId) {
    this.pautaId = pautaId;
  }

  public Long getSessaoId() {
    return sessaoId;
  }

  public void setSessaoId(Long sessaoId) {
    this.sessaoId = sessaoId;
  }

  public String getDescricaoPauta() {
    return descricaoPauta;
  }

  public void setDescricaoPauta(String descricaoPauta) {
    this.descricaoPauta = descricaoPauta;
  }

  public Long getVotosSim() {
    return votosSim;
  }

  public void setVotosSim(Long votosSim) {
    this.votosSim = votosSim;
  }

  public Long getVotosNao() {
    return votosNao;
  }

  public void setVotosNao(Long votosNao) {
    this.votosNao = votosNao;
  }
}
