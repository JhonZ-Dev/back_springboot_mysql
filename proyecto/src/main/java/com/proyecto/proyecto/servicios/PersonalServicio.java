package com.proyecto.proyecto.servicios;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import com.proyecto.proyecto.entidades.EntidadPropiedad;
import com.proyecto.proyecto.repositorio.PersonalesRepo;
import com.proyecto.proyecto.repositorio.PropiedadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.LongFunction;

@Service
public class PersonalServicio {

    @Autowired
    public PersonalesRepo repo;
    @Autowired
    public PropiedadesRepo propiedadesRepo;

    public EntidadPersonal guardar(EntidadPersonal personal, Long id_propiedad) {
        // Obtener la propiedad por su ID
        Optional<EntidadPropiedad> propiedadOptional = propiedadesRepo.findById(id_propiedad);

        // Verificar si la propiedad existe
        if (propiedadOptional.isPresent()) {
            EntidadPropiedad propiedad = propiedadOptional.get();
            // Asignar la propiedad al personal
            personal.setId_propiedad(propiedad);
            // Guardar el personal y propagar los cambios a la propiedad
            EntidadPersonal entidadPersonalGuardado = repo.save(personal);
            return entidadPersonalGuardado;
        } else {
            throw new RuntimeException("No se encontró la propiedad con ID: " + id_propiedad);
        }
    }


    //editar
    public EntidadPersonal editar(EntidadPersonal personal, Long id_personal){

    }

    //buscar por id
    public EntidadPersonal buscarPorId(Long id_personal){
        EntidadPersonal personal = this.repo.findById(id_personal).orElse(null);
        return personal;
    }


}
