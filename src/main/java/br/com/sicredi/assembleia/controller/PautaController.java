package br.com.sicredi.assembleia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.service.PautaService;

@RestController
public class PautaController {

  private final PautaService pautaService;

  public PautaController(PautaService pautaService) {
    this.pautaService = pautaService;
  }

  @GetMapping("/pautas")
  public List<Pauta> pautas() {
    return pautaService.pautas();
  }

  @PostMapping("/pautas")
  public Pauta criarPauta(@RequestBody Pauta pauta) {
    return pautaService.criarPauta(pauta);
  }
}
