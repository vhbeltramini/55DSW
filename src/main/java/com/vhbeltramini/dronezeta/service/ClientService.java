package com.vhbeltramini.dronezeta.service;

import com.vhbeltramini.dronezeta.model.Admin;
import com.vhbeltramini.dronezeta.model.Client;
import com.vhbeltramini.dronezeta.repository.AdminRepository;
import com.vhbeltramini.dronezeta.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientService {
	private ClientRepository repository;

	public ClientService(ClientRepository repository) {
		super();
		this.repository = repository;
	}
	
	@PostMapping("/user/client")
	public ResponseEntity<Admin> create(@Valid @RequestBody Client client){
		Client sevedClient = repository.save(client);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id)")
				.buildAndExpand(sevedClient.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/user/client")
	public List<Client> getAll(){
		return repository.findAll();
	}

	@GetMapping(path="/user/client/{id}")
	public Client get(@PathVariable Long id) throws Exception {
		return repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Client not found for this id :: " + id));
	}

	@DeleteMapping(path="/user/client/{id}")
	public Map<String, Boolean> delete(@PathVariable Long id) throws Exception {
		Client client = repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Client not found for this id :: " + id));

		repository.delete(client);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/user/client/{id}")
	public ResponseEntity<Client> updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Client clientDetails) throws Exception {
		Client client = repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Client not found for this id :: " + id));

		client.setFirstName(clientDetails.getFirstName());
		client.setLastName(clientDetails.getLastName());
		client.setCpf(clientDetails.getCpf());
		client.setEmail(clientDetails.getEmail());
		client.setAddress(clientDetails.getAddress());

		final Client updatedClient = repository.save(client);

		return ResponseEntity.ok(updatedClient);
	}

}
