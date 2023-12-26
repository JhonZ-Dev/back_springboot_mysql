package com.proyecto.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_mantenimientos")
@Data
public class EntidadManteni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mantenimiento;

    private String descripcion;
    private Float costo;
    private String fecha_solicitud;
    private Boolean estado;
    //relacion de muchos a uno con propiedad

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id_propiedad")
    private EntidadPropiedad id_propiedad;
}
