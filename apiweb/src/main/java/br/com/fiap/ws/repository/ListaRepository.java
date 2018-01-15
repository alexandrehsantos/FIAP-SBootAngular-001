package br.com.fiap.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ws.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{

}
