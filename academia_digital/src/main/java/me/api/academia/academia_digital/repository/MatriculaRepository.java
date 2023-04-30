package me.api.academia.academia_digital.repository;

import me.api.academia.academia_digital.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
}
