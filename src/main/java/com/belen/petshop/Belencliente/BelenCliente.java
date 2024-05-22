package com.belen.petshop.Belencliente;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class BelenCliente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)//Clave primaria se autogenera automáticamente
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;  
}
