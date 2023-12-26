package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadUnidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadesRepo extends JpaRepository<EntidadUnidades, Long> {
}
