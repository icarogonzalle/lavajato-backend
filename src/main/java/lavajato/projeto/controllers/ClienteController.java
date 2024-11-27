package lavajato.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lavajato.projeto.entity.Cliente;
import lavajato.projeto.repository.ClienteRepository;
import lavajato.projeto.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarTodos();
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		Cliente novoCliente = clienteService.inserir(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.atualizar(id, cliente));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nome")
	public List<Cliente> buscarPorNome(@RequestParam String nome) {
		return clienteRepository.findByNomeContainingIgnoreCase(nome);

	}

	@GetMapping("/telefone")
	public List<Cliente> buscarPorTelefone(@RequestParam String telefone) {
		return clienteRepository.findByTelefone(telefone);
	}
	
}
