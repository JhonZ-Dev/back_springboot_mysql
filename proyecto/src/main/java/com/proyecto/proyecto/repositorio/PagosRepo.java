package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepo extends JpaRepository<EntidadPagos, Long> {
}
