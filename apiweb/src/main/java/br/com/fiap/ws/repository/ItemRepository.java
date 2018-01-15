package br.com.fiap.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ws.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
