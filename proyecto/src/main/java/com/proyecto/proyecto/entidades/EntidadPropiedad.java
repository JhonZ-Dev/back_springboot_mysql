package com.proyecto.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tlb_entidades")
@Data
public class EntidadPropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_propiedad;
    private String nombre;
    private String direccion;
    private String ciudad;
    private Boolean estado;
    private String cod_postal;

    //relacionar de uno a muchos con Personl

}
