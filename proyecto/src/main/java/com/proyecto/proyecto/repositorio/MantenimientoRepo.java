package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadManteni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepo extends JpaRepository<EntidadManteni, Long> {
}
