package br.com.sicredi.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicredi.assembleia.domain.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
  Long countByVotoTrueAndSessaoId(Long sessaoId);

  Long countByVotoFalseAndSessaoId(Long sessaoId);
}
