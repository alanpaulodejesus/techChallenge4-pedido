package br.com.fiap.techChallenge4.infraestructure.config.db.repository;

import br.com.fiap.techChallenge4.infraestructure.config.db.schema.PedidoSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoSchema, Long> {
    Optional<PedidoSchema> findById(Long id);
}
