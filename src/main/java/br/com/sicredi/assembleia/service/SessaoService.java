package br.com.sicredi.assembleia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.dto.EncerraSessaoDTO;
import br.com.sicredi.assembleia.dto.ResultadoDTO;
import br.com.sicredi.assembleia.dto.SessaoResponseDTO;

@Service
public class SessaoService {

  @Value("${sessao.api.url}")
  private String sessaoApiUrl;

  private RestTemplate restTemplate;

  private PautaService pautaService;

  private ResultadoVotacaoService resultadoVotacaoService;

  public SessaoService(
      RestTemplate restTemplate,
      PautaService pautaService,
      ResultadoVotacaoService resultadoVotacaoService) {

    this.restTemplate = restTemplate;
    this.pautaService = pautaService;
    this.resultadoVotacaoService = resultadoVotacaoService;
  }

  public SessaoResponseDTO buscarSessao(Long pautaId) {
    String url = sessaoApiUrl + "/sessoes/pautas/" + pautaId;
    return restTemplate.getForObject(url, SessaoResponseDTO.class);
  }

  public void encerrarSessao(EncerraSessaoDTO encerraSessaoDTO) {
    Optional<Pauta> pauta = pautaService.desativarPauta(encerraSessaoDTO.getPautaId());

    if (pauta.isPresent()) {
      ResultadoDTO resultado = criarResultadoDTO(encerraSessaoDTO, pauta);
      resultadoVotacaoService.enviarResultadoDaVotacao(resultado);
    }
  }

  private ResultadoDTO criarResultadoDTO(EncerraSessaoDTO encerraSessaoDTO, Optional<Pauta> pauta) {
    ResultadoDTO resultado = new ResultadoDTO();
    resultado.setPautaId(encerraSessaoDTO.getPautaId());
    resultado.setDescricaoPauta(pauta.get().getDescricao());
    resultado.setSessaoId(encerraSessaoDTO.getSessaoId());

    Long votosNao = resultadoVotacaoService.totalVotosNao(encerraSessaoDTO.getSessaoId());
    resultado.setVotosNao(votosNao);

    Long votosSim = resultadoVotacaoService.totalVotosSim(encerraSessaoDTO.getSessaoId());
    resultado.setVotosSim(votosSim);

    return resultado;
  }
}
