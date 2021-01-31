package br.com.sicredi.assembleia.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.assembleia.dto.ValidaCpfDTO;

@ExtendWith(MockitoExtension.class)
public class ValidaCpfSeviceTest {

  @InjectMocks private ValidaCpfSevice validaCpfSevice;

  @Mock private RestTemplate restTemplate;

  @Test
  public void testPodeVotarTrue() {
    ValidaCpfDTO dto = new ValidaCpfDTO();
    dto.setStatus("ABLE_TO_VOTE");
    Mockito.lenient().when(restTemplate.getForObject(any(String.class), any())).thenReturn(dto);

    Boolean podeVotar = validaCpfSevice.podeVotar("19839091069");
    assertTrue(podeVotar);
  }

  @Test
  public void testPodeVotarFalse() {
    ValidaCpfDTO dto = new ValidaCpfDTO();
    dto.setStatus("UNABLE_TO_VOTE");
    Mockito.lenient().when(restTemplate.getForObject(any(String.class), any())).thenReturn(dto);

    Boolean podeVotar = validaCpfSevice.podeVotar("99999999999");
    assertFalse(podeVotar);
  }
}
