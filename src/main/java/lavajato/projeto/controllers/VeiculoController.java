package lavajato.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lavajato.projeto.entity.Veiculo;
import lavajato.projeto.repository.VeiculoRepository;
import lavajato.projeto.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscarPorId(id));
    }

 
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Veiculo> inserir(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.inserir(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> excluir(@PathVariable Long id) {
        veiculoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

 
    @GetMapping("/modelo")
    public List<Veiculo> buscarPorModelo(@RequestParam String modelo) {
        return veiculoRepository.findByModeloContainingIgnoreCase(modelo);
    }

    @GetMapping("/placa")
    public List<Veiculo> buscarPorPlaca(@RequestParam String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    @GetMapping("/por-placa-inicial")
    public List<Veiculo> getVeiculoPorPlacaInicial(@RequestParam String placa) {
        return veiculoRepository.findVeiculosPorPlacaInicial(placa);
    }
}
