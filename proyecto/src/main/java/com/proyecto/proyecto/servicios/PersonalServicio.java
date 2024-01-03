package com.proyecto.proyecto.servicios;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import com.proyecto.proyecto.entidades.EntidadPropiedad;
import com.proyecto.proyecto.repositorio.PersonalesRepo;
import com.proyecto.proyecto.repositorio.PropiedadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalServicio {

    @Autowired
    public PersonalesRepo repo;
    @Autowired
    public PropiedadesRepo propiedadesRepo;

    public EntidadPersonal guardar(EntidadPersonal personal, Long id_propiedad){

        //obteer la propiedad por su id
        Optional<EntidadPropiedad> propiedadOptional = propiedadesRepo.findById(id_propiedad);
        //verificar si la propiedad existe
        if(propiedadOptional.isPresent()){
            EntidadPropiedad propiedad = propiedadOptional.get();
            //asignar la propiedad al personal
            personal.setId_propiedad(propiedad);
            return repo.save(personal);
        }else{
            throw new RuntimeException("No se encontró la propiedad con ID: " + id_propiedad);
        }
    }
}
