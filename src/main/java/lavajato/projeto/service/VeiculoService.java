package lavajato.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lavajato.projeto.entity.Veiculo;
import lavajato.projeto.exception.ResourceNotFoundExcpetion;
import lavajato.projeto.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public Veiculo buscarPorId(Long id) {
		return veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcpetion("Veiculo com ID " + id + " não encontrado."));
	}

	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	public Veiculo inserir(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public void excluir(Long id) {
		Veiculo veiculo = buscarPorId(id);
		veiculoRepository.delete(veiculo);
	}
}
