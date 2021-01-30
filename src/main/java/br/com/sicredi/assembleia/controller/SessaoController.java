package br.com.sicredi.assembleia.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.dto.SessaoRequestDTO;
import br.com.sicredi.assembleia.dto.SessaoResponseDTO;

@RestController
public class SessaoController {

	@Value("${sessao.api.url}")
	private String sessaoApiUrl;

	private RestTemplate restTemplate;

	public SessaoController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping("/sessoes")
	public SessaoResponseDTO criarSessao(@RequestBody SessaoRequestDTO sessaoDTO) {
		return restTemplate.postForObject(sessaoApiUrl + "/sessoes", sessaoDTO, SessaoResponseDTO.class);
	}
}
