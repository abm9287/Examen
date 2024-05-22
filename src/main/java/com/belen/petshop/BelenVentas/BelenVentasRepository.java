package com.belen.petshop.BelenVentas;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BelenVentasRepository extends CrudRepository<BelenVentas, Long> 
{
    List<BelenVentas> findAll();
}
