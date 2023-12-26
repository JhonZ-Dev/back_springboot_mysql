package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.entidades.EntidadPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface PropiedadesRepo extends JpaRepository<EntidadPropiedad, Long> {
}
