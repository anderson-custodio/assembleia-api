package br.com.sicredi.assembleia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.dto.ValidaCpfDTO;

@Service
public class ValidaCpfSevice {

  @Value("${validacpf.api.url}")
  private String validaCpfApiUrl;

  private RestTemplate restTemplate;

  public ValidaCpfSevice(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Boolean podeVotar(String cpf) {
    String url = validaCpfApiUrl + "/" + cpf;
    ValidaCpfDTO response = restTemplate.getForObject(url, ValidaCpfDTO.class);
    return "ABLE_TO_VOTE".equals(response.getStatus());
  }
}
