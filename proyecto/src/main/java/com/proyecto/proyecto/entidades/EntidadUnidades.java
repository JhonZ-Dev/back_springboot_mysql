package com.proyecto.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_unidades")
@Data
public class EntidadUnidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_unidad;
    private String num_unidad;
    private Float metros_cuadrados;
    private String num_habitaciones;

    //relacoin de muchos a uno con propiedades

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id_propiedad")
    private EntidadPropiedad id_propiedad;
}
