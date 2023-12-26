package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadesRepo extends JpaRepository<EntidadPropiedad, Long> {
}
