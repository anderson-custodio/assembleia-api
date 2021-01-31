package br.com.sicredi.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicredi.assembleia.domain.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {}
