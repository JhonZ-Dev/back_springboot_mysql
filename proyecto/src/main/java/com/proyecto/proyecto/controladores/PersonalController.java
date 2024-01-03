package com.proyecto.proyecto.controladores;

import com.proyecto.proyecto.entidades.EntidadPersonal;
import com.proyecto.proyecto.servicios.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
