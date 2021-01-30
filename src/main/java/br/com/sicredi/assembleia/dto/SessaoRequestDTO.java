package br.com.sicredi.assembleia.dto;

public class SessaoRequestDTO {

	private Long pautaId;
	private Integer tempoEmMinutos = 1;

	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public Integer getTempoEmMinutos() {
		return tempoEmMinutos;
	}

	public void setTempoEmMinutos(Integer tempoEmMinutos) {
		this.tempoEmMinutos = tempoEmMinutos;
	}

}
