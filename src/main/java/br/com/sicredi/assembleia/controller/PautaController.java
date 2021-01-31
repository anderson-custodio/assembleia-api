package br.com.sicredi.assembleia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.dto.PautaAtivaDTO;
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

  @PatchMapping("/pautas/{id}")
  public ResponseEntity<Pauta> atualizarStatus(
      @PathVariable Long id, @RequestBody PautaAtivaDTO dto) {

    Optional<Pauta> pauta = pautaService.buscarPauta(id);
    if (!pauta.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(pautaService.atualizarStatus(pauta.get(), dto.getAtiva()));
  }
}
