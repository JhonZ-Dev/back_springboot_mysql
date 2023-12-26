package com.proyecto.proyecto.controladores;

import com.proyecto.proyecto.entidades.EntidadPropiedad;
import com.proyecto.proyecto.servicios.PropiedadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/propiedades")
public class PropiedadControladores {

    @Autowired
    public PropiedadesServicio servicio;

    //metodo para guardar
    @PostMapping("/guardar/propiedad")
    public EntidadPropiedad guardarPropiedades(@RequestBody EntidadPropiedad propiedad){
        return servicio.guardar(propiedad);
    }

    @PutMapping("/editar/propiedad/{id_propiedad}")
    public ResponseEntity<EntidadPropiedad> guardarPropiedades(@RequestBody EntidadPropiedad propiedad,
                                             @PathVariable Long id_propiedad)
    {
        Optional<EntidadPropiedad> entidadPropiedad = servicio.encontrarById(id_propiedad);

        if(entidadPropiedad.isPresent()){
            //actualziar la entidad
            EntidadPropiedad entidadExiste = entidadPropiedad.get();
            entidadExiste.setNombre(propiedad.getNombre());
            entidadExiste.setDireccion(propiedad.getDireccion());
            entidadExiste.setCiudad(propiedad.getCiudad());
            entidadExiste.setEstado(propiedad.getEstado());
            entidadExiste.setCod_postal(propiedad.getCod_postal());
            // Llama al método guardar para realizar la actualización
            EntidadPropiedad entidadActualizada = servicio.guardar(entidadExiste);
            //retorna la entidad actualiza
            return ResponseEntity.ok(entidadActualizada);

        }else {
            return ResponseEntity.notFound().build();
        }

    }

    //traerTodos
    @GetMapping("/traer/propiedades")
    public List<EntidadPropiedad> obtenerTodos(){
        return servicio.listar();
    }
}
