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
    
}
