package br.com.fiap.ws.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ws.model.Item;
import br.com.fiap.ws.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public Item salvar(Item item) {
		return itemRepository.save(item);
	}

	public List<Item> salvar(List<Item> item) {
		return itemRepository.save(item);
	}

	public Collection<Item> buscarTodos() {
		return itemRepository.findAll();
	}

	public void excluir(Item item) {
		itemRepository.delete(item);
	}

	public Item alterar(Item item) {
		return this.salvar(item);
	}

	public Item buscarPorId(Long id) {
		return itemRepository.findOne(id);
	}

}
