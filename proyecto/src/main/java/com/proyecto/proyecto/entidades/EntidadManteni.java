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

    pr
}
