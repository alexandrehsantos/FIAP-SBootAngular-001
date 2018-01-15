package br.com.fiap.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ws.model.Item;
import br.com.fiap.ws.model.Lista;
import br.com.fiap.ws.service.ItemService;
import br.com.fiap.ws.service.ListaService;

@RestController
public class ListaController {
	@Autowired
	ListaService listaService;

	@Autowired
	ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/listas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Lista>> buscarTodosClientes() {

		Collection<Lista> buscarTodos = listaService.buscarTodos();

		return new ResponseEntity<Collection<Lista>>(buscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/listas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lista> cadastrarCliente(@RequestBody Lista lista) {

		itemService.salvar(lista.getItens());

		Lista clienteCadastrado = listaService.cadastrar(lista);

		return new ResponseEntity<Lista>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/listas/{id}")
	public ResponseEntity<Lista> excluirCliente(@PathVariable Long id) {

		Lista clienteEncontrado = listaService.buscarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			listaService.excluir(clienteEncontrado);
		}

		return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/listas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lista> alterarCliente(@RequestBody Lista lista) {
		
		itemService.salvar(lista.getItens());
		
		Lista clienteAlterado = listaService.alterar(lista);

		return new ResponseEntity<Lista>(clienteAlterado, HttpStatus.OK);
	}

}
