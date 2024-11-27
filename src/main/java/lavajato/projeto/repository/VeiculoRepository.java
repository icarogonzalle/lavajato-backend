package lavajato.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lavajato.projeto.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByModeloContainingIgnoreCase(String modelo);

	List<Veiculo> findByPlaca(String placa);
	
	@Query("SELECT v FROM Veiculo v WHERE v.placa LIKE :placa%")
	List<Veiculo> findVeiculosPorPlacaInicial(@Param("placa") String placa);

}
