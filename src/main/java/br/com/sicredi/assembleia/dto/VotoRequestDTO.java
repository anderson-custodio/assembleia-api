package br.com.sicredi.assembleia.dto;

public class VotoRequestDTO {

  private Long pautaId;
  private String cpf;
  private Boolean voto;

  public Long getPautaId() {
    return pautaId;
  }

  public void setPautaId(Long pautaId) {
    this.pautaId = pautaId;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Boolean getVoto() {
    return voto;
  }

  public void setVoto(Boolean voto) {
    this.voto = voto;
  }
}
