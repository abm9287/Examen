package com.belen.petshop.Belencliente;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping(value="/api/")
public class BelenClienteController {
    @Autowired
    private BelenClienteService belenClienteService;

    // Metodo endpoint
    @PostMapping(value = "cliente")
    public BelenCliente save(@RequestBody BelenCliente entity) {
        return belenClienteService.save(entity);
    }

    // SELECT por id
    @GetMapping(value = "cliente/{id}")
    public BelenCliente findById(@PathVariable("id") Long id) {
        return belenClienteService.findById(id);
    }

    //Actualizacion parcial
    @PutMapping(value="cliente/{id}")
    public ResponseEntity<BelenCliente> actualizarBelenCliente(@PathVariable("id") Long id, @RequestBody BelenCliente entity) {
        return belenClienteService.actualizarBelenCliente(id, entity);
    }
    
}