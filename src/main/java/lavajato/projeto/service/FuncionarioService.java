package lavajato.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lavajato.projeto.entity.Funcionario;
import lavajato.projeto.exception.ResourceNotFoundExcpetion;
import lavajato.projeto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario buscarPorId(Long id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcpetion("Funcionario com ID " + id + " não encontrado."));
	}

	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	public Funcionario inserir(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {
		Funcionario funcionario = buscarPorId(id);
		funcionario.setNome(funcionarioAtualizado.getNome());
		funcionario.setCargo(funcionarioAtualizado.getCargo());
		funcionario.setSalario(funcionarioAtualizado.getSalario());
		return funcionarioRepository.save(funcionario);
	}

	public void excluir(Long id) {
		Funcionario funcionario = buscarPorId(id);
		funcionarioRepository.delete(funcionario);
	}
}