package br.com.sicredi.assembleia.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sicredi.assembleia.domain.Voto;
import br.com.sicredi.assembleia.dto.SessaoResponseDTO;
import br.com.sicredi.assembleia.dto.VotoRequestDTO;
import br.com.sicredi.assembleia.repository.VotoRepository;

@ExtendWith(MockitoExtension.class)
public class VotoServiceTest {

	@InjectMocks
	private VotoService votoService;

	@Mock
	private VotoRepository votoRepository;

	@Mock
	private SessaoService sessaoService;

	@BeforeEach
	public void init() {
		buscarSessaoMock();
		salvarVotoMock();
	}

	@Test
	void testNovoVoto() {
		VotoRequestDTO dto = new VotoRequestDTO();
		dto.setCpf("19839091069");
		dto.setPautaId(-1L);
		dto.setVoto(true);

		Voto voto = votoService.criarVoto(dto);

		assertNotNull(voto);
		verify(votoRepository, times(1)).save(voto);
	}

	private void salvarVotoMock() {
		Mockito.lenient().when(votoRepository.save(any(Voto.class))).then(AdditionalAnswers.returnsFirstArg());
	}

	private void buscarSessaoMock() {
		SessaoResponseDTO dto = new SessaoResponseDTO();
		dto.setId(-1L);

		Mockito.lenient().when(sessaoService.buscarSessao(-1L)).thenReturn(dto);
	}

}
