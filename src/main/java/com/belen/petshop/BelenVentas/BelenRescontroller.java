package com.belen.petshop.BelenVentas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/")
public class BelenRescontroller 
{
    //Inyección de dependencias
    @Autowired
    private BelenVentasService belenVentasService;

    //Guarda 
    @PostMapping(value="ventas")
    public BelenVentas save(@RequestBody BelenVentas entity)
    {
        return belenVentasService.save(entity); 
    }

    //SELECT por id
    @GetMapping(value="ventas/{id}")
    public BelenVentas findById(@PathVariable("id") Long id)
    {
        return belenVentasService.findById(id);
    }

    //RETORNA TODOS
    @GetMapping(value="ventas")
    public List<BelenVentas> findAll()
    {
        return belenVentasService.findAll();
    }

    //ELIMINAR
    @DeleteMapping(value="ventas/{id}")
    public void deleteById(Long id)
    {
        belenVentasService.deleteById(id);
    }

    //ACTUALIZAR POR CAMPOS
    @PutMapping(value="ventas/{id}")
    public ResponseEntity<BelenVentas> updateVentas(@PathVariable("id") Long id, @RequestBody BelenVentas entity)
    {
        return belenVentasService.updateVentas(id, entity);
    }
}