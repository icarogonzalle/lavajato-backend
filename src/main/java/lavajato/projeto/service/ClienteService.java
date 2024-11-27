package lavajato.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lavajato.projeto.entity.Cliente;
import lavajato.projeto.exception.ResourceNotFoundExcpetion;
import lavajato.projeto.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcpetion("Cliente com ID " + id + " não encontrado."));
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente inserir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente atualizar(Long id, Cliente clienteAtualizado) {
		Cliente cliente = buscarPorId(id);
		cliente.setNome(clienteAtualizado.getNome());
		cliente.setTelefone(clienteAtualizado.getTelefone());
		return clienteRepository.save(cliente);
	}

	public void excluir(Long id) {
		Cliente cliente = buscarPorId(id);
		clienteRepository.delete(cliente);
	}
}
