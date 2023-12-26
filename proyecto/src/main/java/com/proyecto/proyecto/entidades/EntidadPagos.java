package com.proyecto.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_pagos")
@Data
public class EntidadPagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagos;

    private Float monto;
    private String fecha_pago;
    private String metodo_pago;
    private Boolean estado_pago;

    //relacion de muchos a uno con Residentes
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_residentes",referencedColumnName = "id_residentes")
    private EntidadResidentes id_residentes;
}
