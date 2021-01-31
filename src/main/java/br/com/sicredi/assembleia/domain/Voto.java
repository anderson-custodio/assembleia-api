package br.com.sicredi.assembleia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints =
        @UniqueConstraint(
            name = "uc_sessao_cpf",
            columnNames = {"sessao_id", "cpf"}))
public class Voto {

  @Id @GeneratedValue private Long id;

  @Column(nullable = false, name = "sessao_id")
  private Long sessaoId;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private Boolean voto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSessaoId() {
    return sessaoId;
  }

  public void setSessaoId(Long sessaoId) {
    this.sessaoId = sessaoId;
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
