package com.belen.petshop.BelenVentas;

import java.time.LocalDate;

import com.belen.petshop.Belencliente.BelenCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data

public class BelenVentas 
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaVenta;
    private Double total;
    private String descripcion;

    @ManyToOne 
    private BelenCliente belenCliente;

}
