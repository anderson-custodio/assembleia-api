package br.com.sicredi.assembleia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.domain.Voto;
import br.com.sicredi.assembleia.dto.VotoRequestDTO;
import br.com.sicredi.assembleia.service.PautaService;
import br.com.sicredi.assembleia.service.ValidaCpfSevice;
import br.com.sicredi.assembleia.service.VotoService;

@RestController
public class VotoController {

  private final VotoService votoService;
  private final ValidaCpfSevice validaCpfSevice;
  private final PautaService pautaService;

  public VotoController(
      VotoService votoService, ValidaCpfSevice validaCpfSevice, PautaService pautaService) {
    this.votoService = votoService;
    this.validaCpfSevice = validaCpfSevice;
    this.pautaService = pautaService;
  }

  @PostMapping("/votos")
  public ResponseEntity<Voto> criarVoto(@RequestBody VotoRequestDTO votoDTO) {

    if (!validaCpfSevice.podeVotar(votoDTO.getCpf())) {
      return ResponseEntity.notFound().build();
    }

    if (!pautaService.pautaEstaAbertaParaVotacao(votoDTO.getPautaId())) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(votoService.criarVoto(votoDTO));
  }
}
