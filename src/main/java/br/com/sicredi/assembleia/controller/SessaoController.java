package br.com.sicredi.assembleia.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.dto.EncerraSessaoDTO;
import br.com.sicredi.assembleia.dto.SessaoRequestDTO;
import br.com.sicredi.assembleia.dto.SessaoResponseDTO;
import br.com.sicredi.assembleia.service.SessaoService;

@RestController
public class SessaoController {

  @Value("${sessao.api.url}")
  private String sessaoApiUrl;

  private RestTemplate restTemplate;

  private SessaoService sessaoService;

  public SessaoController(RestTemplate restTemplate, SessaoService sessaoService) {
    this.restTemplate = restTemplate;
    this.sessaoService = sessaoService;
  }

  @PostMapping("/sessoes")
  public SessaoResponseDTO criarSessao(@RequestBody SessaoRequestDTO sessaoDTO) {
    return restTemplate.postForObject(
        sessaoApiUrl + "/sessoes", sessaoDTO, SessaoResponseDTO.class);
  }

  @PostMapping("/sessoes/encerrar")
  public void encerrarSessao(@RequestBody EncerraSessaoDTO encerraSessaoDTO) {
    sessaoService.encerrarSessao(encerraSessaoDTO);
  }
}
