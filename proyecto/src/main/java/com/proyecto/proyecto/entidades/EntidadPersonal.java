package com.proyecto.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="tbl_personales")
@Data
public class EntidadPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personal;
    private String nombre, puesto, telefono;
    private String email;
    private String fecha_contratacion;
    //relacion de muchos a uno con propiedades

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_propiedad", referencedColumnName = "id_propiedad")
    private EntidadPropiedad id_propiedad;

}
