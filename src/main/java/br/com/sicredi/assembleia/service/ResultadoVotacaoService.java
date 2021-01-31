package br.com.sicredi.assembleia.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.dto.ResultadoDTO;
import br.com.sicredi.assembleia.repository.VotoRepository;

@Service
public class ResultadoVotacaoService {

  @Value("${fila.resultado.rabbit}")
  private String filaResultado;

  private final RabbitTemplate rabbitTemplate;

  private VotoRepository votoRepository;

  public ResultadoVotacaoService(RabbitTemplate rabbitTemplate, VotoRepository votoRepository) {
    this.rabbitTemplate = rabbitTemplate;
    this.votoRepository = votoRepository;
  }

  public void enviarResultadoDaVotacao(ResultadoDTO dto) {
    rabbitTemplate.convertAndSend("", filaResultado, dto);
  }

  public Long totalVotosSim(Long sessaoId) {
    return votoRepository.countByVotoTrueAndSessaoId(sessaoId);
  }

  public Long totalVotosNao(Long sessaoId) {
    return votoRepository.countByVotoFalseAndSessaoId(sessaoId);
  }
}
