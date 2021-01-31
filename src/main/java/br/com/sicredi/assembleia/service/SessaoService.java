package br.com.sicredi.assembleia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.dto.SessaoResponseDTO;

@Service
public class SessaoService {

  @Value("${sessao.api.url}")
  private String sessaoApiUrl;

  private RestTemplate restTemplate;

  public SessaoService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public SessaoResponseDTO buscarSessao(Long pautaId) {
    String url = sessaoApiUrl + "/sessoes/pautas/" + pautaId;
    return restTemplate.getForObject(url, SessaoResponseDTO.class);
  }
}
