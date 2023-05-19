package com.vhbeltramini.dronezeta.service;

import com.vhbeltramini.dronezeta.model.User;
import com.vhbeltramini.dronezeta.model.User;
import com.vhbeltramini.dronezeta.repository.UserRepository;
import com.vhbeltramini.dronezeta.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserService {
	private UserRepository repository;

	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> create(@Valid @RequestBody User user){
		User sevedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id)")
				.buildAndExpand(sevedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/user")
	public List<User> getAll(){
		return repository.findAll();
	}

	@GetMapping(path="/user/{id}")
	public User get(@PathVariable Long id) throws Exception {
		return repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("User not found for this id :: " + id));
	}

	@GetMapping(path="/user/{email}")
	public User findByEmail(@PathVariable String email) throws Exception {
		return repository.findByEmail(email)
				.orElseThrow(() -> new Exception("User not found for this email :: " + email));
	}

	@DeleteMapping(path="/user/{id}")
	public Map<String, Boolean> delete(@PathVariable Long id) throws Exception {
		User user = repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("User not found for this id :: " + id));

		repository.delete(user);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody User user) throws Exception {

		user.setId(Math.toIntExact(id));

		final User updatedUser = repository.save(user);

		return ResponseEntity.ok(updatedUser);
	}

}
