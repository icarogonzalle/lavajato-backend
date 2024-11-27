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

import lavajato.projeto.entity.Funcionario;
import lavajato.projeto.repository.FuncionarioRepository;
import lavajato.projeto.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(funcionarioService.buscarPorId(id));
	}

	@GetMapping
	public List<Funcionario> listarFuncionarios() {
		return funcionarioService.listarTodos();
	}

	@PostMapping
	public ResponseEntity<Funcionario> inserir(@RequestBody Funcionario funcionario) {
		Funcionario novoFuncionario = funcionarioService.inserir(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return ResponseEntity.ok(funcionarioService.atualizar(id, funcionario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> excluir(@PathVariable Long id) {
		funcionarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/cargo")
	public List<Funcionario> buscarPorCargo(@RequestParam String cargo) {
		return funcionarioRepository.findByCargo(cargo);
	}

	@GetMapping("/nome")
	public List<Funcionario> buscarPorNome(@RequestParam String nome) {
		return funcionarioRepository.findByNome(nome);
	}

	@GetMapping("/por-salario")
	public List<Funcionario> getFuncionariosPorSalario(@RequestParam Double salario) {
		return funcionarioRepository.findFuncionariosPorSalario(salario);
	}

}
