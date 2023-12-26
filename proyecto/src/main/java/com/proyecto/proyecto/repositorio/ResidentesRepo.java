package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadResidentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentesRepo extends JpaRepository<EntidadResidentes, Long> {
}
