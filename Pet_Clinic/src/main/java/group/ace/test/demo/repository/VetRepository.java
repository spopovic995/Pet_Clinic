package group.ace.test.demo.repository;

import group.ace.test.demo.domain.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
