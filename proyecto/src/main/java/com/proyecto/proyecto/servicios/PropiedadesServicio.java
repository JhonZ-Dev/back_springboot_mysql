package com.proyecto.proyecto.servicios;

import com.proyecto.proyecto.entidades.EntidadPropiedad;
import com.proyecto.proyecto.repositorio.PropiedadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadesServicio {

    @Autowired
    public PropiedadesRepo repo;

    //metodo para guardar
    public EntidadPropiedad guardar(EntidadPropiedad propiedad) {
        try {
            // Si la entidad tiene un ID asignado, se considera una actualización
            if (propiedad.getId_propiedad() != null) {
                // Puedes agregar aquí validaciones adicionales si es necesario
                return repo.save(propiedad);
            } else {
                // Si la entidad no tiene un ID asignado, se considera una creación
                // Puedes agregar aquí validaciones adicionales si es necesario
                return repo.save(propiedad);
            }
        } catch (DataIntegrityViolationException e) {
            // Manejar excepciones de violación de integridad (por ejemplo, duplicados)
            // Puedes personalizar este manejo según tus necesidades
            throw new RuntimeException("Error de integridad al guardar la entidad", e);
        }
    }

    //metodo para listar
    public List<EntidadPropiedad> listar(){
        return repo.findAll();
    }

    //metodo para eliminar
    public void eliminar(Long id_propiedad){
        repo.deleteById(id_propiedad);
    }
    //metodo para obtener por Id
    public Optional<EntidadPropiedad> encontrarById(Long id_propiedad){
        return repo.findById(id_propiedad);
    }


}
