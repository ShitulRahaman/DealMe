package exibition.repository;

import exibition.domain.CustomLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomLogRepositiry extends JpaRepository<CustomLog, Integer> {
}
