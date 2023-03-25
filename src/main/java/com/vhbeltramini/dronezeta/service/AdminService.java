package com.vhbeltramini.dronezeta.service;

import com.vhbeltramini.dronezeta.model.Admin;
import com.vhbeltramini.dronezeta.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminService {
	private AdminRepository repository;

	public AdminService(AdminRepository repository) {
		super();
		this.repository = repository;
	}
	
	@PostMapping("/user/admin")
	public ResponseEntity<Admin> create(@Valid @RequestBody Admin admin){
		Admin sevedAdmin = repository.save(admin);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id)")
				.buildAndExpand(sevedAdmin.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/user/admin")
	public List<Admin> getAll(){
		return repository.findAll();
	}

	@GetMapping(path="/user/admin/{id}")
	public Admin get(@PathVariable Long id) throws Exception {
		return repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Admin not found for this id :: " + id));
	}

	@DeleteMapping(path="/user/admin/{id}")
	public Map<String, Boolean> delete(@PathVariable Long id) throws Exception {
		Admin admin = repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Admin not found for this id :: " + id));

		repository.delete(admin);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/user/admin/{id}")
	public ResponseEntity<Admin> updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Admin adminDetails) throws Exception {
		Admin admin = repository.findById(Math.toIntExact(id))
				.orElseThrow(() -> new Exception("Admin not found for this id :: " + id));

		admin.setFirstName(adminDetails.getFirstName());
		admin.setLastName(adminDetails.getLastName());
		admin.setCpf(adminDetails.getCpf());
		admin.setEmail(adminDetails.getEmail());
		admin.setAddress(adminDetails.getAddress());

		final Admin updatedAdmin = repository.save(admin);

		return ResponseEntity.ok(updatedAdmin);
	}

}
