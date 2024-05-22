package com.belen.petshop.Belencliente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BelenClienteRepository extends CrudRepository<BelenCliente, Long> 
{
    //List<BelenCliente> findByNombre(Long id, String nombre);
    List<BelenCliente> ffindAll();
}
