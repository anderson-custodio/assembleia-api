package br.com.sicredi.assembleia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.repository.PautaRepository;

@RestController
public class PautaController {

	private final PautaRepository pautaRepository;

	public PautaController(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}

	@GetMapping("/pautas")
	public List<Pauta> all() {
		return pautaRepository.findAll();
	}

	@PostMapping("/pautas")
	public Pauta newPauta(@RequestBody Pauta pauta) {
		return pautaRepository.save(pauta);
	}
}
