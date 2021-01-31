package br.com.sicredi.assembleia.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sicredi.assembleia.domain.Pauta;
import br.com.sicredi.assembleia.repository.PautaRepository;

@ExtendWith(MockitoExtension.class)
public class PautaServiceTest {

  @InjectMocks private PautaService pautaService;

  @Mock private PautaRepository pautaRepository;

  @BeforeEach
  void init() {
    Pauta pauta1 = new Pauta();
    pauta1.setAtiva(true);

    Mockito.lenient().when(pautaRepository.findById(-1L)).thenReturn(Optional.of(pauta1));

    Pauta pauta2 = new Pauta();
    pauta2.setAtiva(false);

    Mockito.lenient().when(pautaRepository.findById(-2L)).thenReturn(Optional.of(pauta2));
  }

  @Test
  void testPautaEstaAbertaParaVotacaoTrue() {
    Boolean estaAberta = pautaService.pautaEstaAbertaParaVotacao(-1L);
    assertTrue(estaAberta);
  }

  @Test
  void testPautaEstaAbertaParaVotacaoFalse() {
    Boolean estaAberta = pautaService.pautaEstaAbertaParaVotacao(-2L);
    assertFalse(estaAberta);
  }
}
