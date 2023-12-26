package com.proyecto.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_entidades")
@Data
public class EntidadResidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_residentes;
    private String nombre,telefono, email;
    private String fecha_ingreso;

    //relacion de muchos a uno con unidades;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    private EntidadUnidades id_unidad;
}
