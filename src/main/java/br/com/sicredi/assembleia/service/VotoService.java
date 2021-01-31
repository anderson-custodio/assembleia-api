package br.com.sicredi.assembleia.service;

import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.domain.Voto;
import br.com.sicredi.assembleia.dto.SessaoResponseDTO;
import br.com.sicredi.assembleia.dto.VotoRequestDTO;
import br.com.sicredi.assembleia.repository.VotoRepository;

@Service
public class VotoService {

  private final VotoRepository votoRepository;

  private final SessaoService sessaoService;

  public VotoService(VotoRepository votoRepository, SessaoService sessaoService) {
    this.votoRepository = votoRepository;
    this.sessaoService = sessaoService;
  }

  public Voto criarVoto(VotoRequestDTO dto) {
    SessaoResponseDTO sessao = sessaoService.buscarSessao(dto.getPautaId());

    Voto voto = new Voto();
    voto.setCpf(dto.getCpf());
    voto.setSessaoId(sessao.getId());
    voto.setVoto(dto.getVoto());

    return votoRepository.save(voto);
  }
}
