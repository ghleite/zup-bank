package br.com.zupbank.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupbank.dto.ClientDTO;
import br.com.zupbank.model.Client;
import br.com.zupbank.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<ClientDTO> list() {

		List<Client> clients = clientRepository.findAll();
		return ClientDTO.convert(clients);
	}

	@PostMapping
	public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientDTO clientDto,  UriComponentsBuilder uriBuilder) {
		
		Client client = clientDto.convertObject();
		clientRepository.save(client);		
		URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getClientId()).toUri();
		return ResponseEntity.created(uri).body(new ClientDTO(client));
	}

}
