package br.com.sicredi.assembleia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.repository.PautaRepository;

@Service
public class PautaService {

  private PautaRepository pautaRepository;

  public PautaService(PautaRepository pautaRepository) {
    this.pautaRepository = pautaRepository;
  }

  public Boolean pautaEstaAbertaParaVotacao(Long pautaId) {
    Optional<Pauta> pauta = pautaRepository.findById(pautaId);
    return pauta.isPresent() && pauta.get().getAtiva();
  }

  public Pauta criarPauta(Pauta pauta) {
    return pautaRepository.save(pauta);
  }

  public List<Pauta> pautas() {
    return pautaRepository.findAll();
  }

  public Optional<Pauta> buscarPauta(Long pautaId) {
    return pautaRepository.findById(pautaId);
  }

  public Pauta atualizarStatus(Pauta pauta, Boolean ativa) {
    pauta.setAtiva(ativa);
    return pautaRepository.save(pauta);
  }
}
