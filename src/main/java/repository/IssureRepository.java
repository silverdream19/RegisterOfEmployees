package repository;

import entity.Issure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssureRepository extends JpaRepository<Issure, Long> {
}
