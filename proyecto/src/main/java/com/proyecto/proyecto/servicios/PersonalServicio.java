package com.proyecto.proyecto.servicios;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import com.proyecto.proyecto.entidades.EntidadPropiedad;
import com.proyecto.proyecto.repositorio.PersonalesRepo;
import com.proyecto.proyecto.repositorio.PropiedadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public EntidadPersonal editar(EntidadPersonal personal, Long id_personal) {
        // Validar si existe el ID
        EntidadPersonal personalExistente = buscarPorId(id_personal);

        if (personalExistente != null) {
            // Actualizar los campos del personal existente
            personalExistente.setNombre(personal.getNombre());
            personalExistente.setPuesto(personal.getPuesto());
            personalExistente.setTelefono(personal.getTelefono());
            personalExistente.setEmail(personal.getEmail());
            personalExistente.setFecha_contratacion(personal.getFecha_contratacion());

            // Guardar y devolver el personal actualizado
            return repo.save(personalExistente);
        } else {
            throw new RuntimeException("No se encontró el personal con ID: " + id_personal);
        }
    }


    //buscar por id
    public EntidadPersonal buscarPorId(Long id_personal){
        EntidadPersonal personal = this.repo.findById(id_personal).orElse(null);
        return personal;
    }

    //listar
    public List<EntidadPersonal> listarTodos(){
        return repo.findAll();
    }

    //elimina
    public void eliminar(Long id_personal){
        repo.deleteById(id_personal);
    }


}
