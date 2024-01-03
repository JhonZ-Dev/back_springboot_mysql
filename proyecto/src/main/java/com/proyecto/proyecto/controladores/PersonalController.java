package com.proyecto.proyecto.controladores;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import com.proyecto.proyecto.servicios.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personal/proyecto")
public class PersonalController {

    @Autowired
    public PersonalServicio servicio;

    @PostMapping("/guardar/{id_propiedad}")
    public EntidadPersonal guardarEntidad (
            @RequestBody EntidadPersonal entidadPersonal,
            @PathVariable Long id_propiedad){
        return servicio.guardar(entidadPersonal, id_propiedad);
    }

    //actualizar
    @PutMapping("/editar/{id_personal}")
    public EntidadPersonal editar( @RequestBody EntidadPersonal entidadPersonal,
                                   @PathVariable Long id_personal){
        return servicio.editar(entidadPersonal, id_personal);
    }

    //listar
    @GetMapping("/traer/todos")
    public List<EntidadPersonal> listar(){
        return servicio.listarTodos();
    }

    @GetMapping("/traerPorId/{id_personal}")
    public EntidadPersonal encontrarPorId(Long id_personal){
        return servicio.buscarPorId(id_personal);
    }

    @DeleteMapping("/eliminar/{id_personal}")
    public ResponseEntity<Map<String, Boolean>> eliminarPersonal(@PathVariable Long id_personal){
        EntidadPersonal personal = servicio.buscarPorId(id_personal);
        if(personal == null){
            // Si no se encuentra el personal con el ID proporcionado, devolver un ResponseEntity con un mensaje
            Map<String, Boolean> response = new HashMap<>();
            response.put("Personal no encontrado con ID: " + id_personal, false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        //se encontró el personal, así que vamos a eliminar
        servicio.eliminar(id_personal);
        // Devolver una respuesta exitosa
        Map<String, Boolean> response = new HashMap<>();
        response.put("Personal eliminado con éxito con ID: " + id_personal, true);
        return new ResponseEntity<>(response, HttpStatus.OK);




    }


}
