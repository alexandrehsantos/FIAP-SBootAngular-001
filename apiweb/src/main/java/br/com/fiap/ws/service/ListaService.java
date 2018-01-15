package br.com.fiap.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ws.model.Lista;
import br.com.fiap.ws.repository.ListaRepository;

@Service
public class ListaService {

	@Autowired
	ListaRepository clienteRepository;


	public Lista cadastrar(Lista lista) {
		return clienteRepository.save(lista);
	}

	public Collection<Lista> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void excluir(Lista lista) {
		clienteRepository.delete(lista);
	}

	public Lista alterar(Lista lista) {
		return this.cadastrar(lista);
	}

	public Lista buscarPorId(Long id) {
		return clienteRepository.findOne(id);
	}

}
