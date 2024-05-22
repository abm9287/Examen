package com.belen.petshop.Belencliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PutMapping;

@Service
public class BelenClienteService {
    // Inyección de dependencias
    @Autowired
    private BelenClienteRepository belenClienteRepository;

    // Guarda
    public BelenCliente save(BelenCliente belenCliente) {
        return belenClienteRepository.save(belenCliente);
    }

    // SELECT id
    public BelenCliente findById(Long id) {
        return belenClienteRepository.findById(id).orElse(null);
    }

    // DELETE
    public void deleteById(Long id) {
        belenClienteRepository.deleteById(id);
    }

    // SELECT todos
    
    // public List<BelenCliente> findAll() {
    //     return belenClienteRepository.findAll();
    // }

    // UPDATE
    @PutMapping("path/{id}")
    public ResponseEntity<BelenCliente> actualizarBelenCliente(Long id, BelenCliente entityActualizado) {
        try {
            // Verifico si el id de BelenCliente existe
            BelenCliente clienteExistente = findById(id);

            if (clienteExistente == null) {
                return ResponseEntity.notFound().build();
            }

            // Si existe voy a actualiza los campos existentes
            if (entityActualizado.getNombre() != null) {
                clienteExistente.setNombre(entityActualizado.getNombre());
            }

            if (entityActualizado.getApellido() != null) {
                clienteExistente.setApellido(entityActualizado.getApellido());
            }

            if (entityActualizado.getEdad() != null) {
                clienteExistente.setEdad(entityActualizado.getEdad());
            }

            if (entityActualizado.getFechaNacimiento() != null) {
                clienteExistente.setFechaNacimiento(entityActualizado.getFechaNacimiento());
            }

            // Guardar los cambios
            BelenCliente clienteGuardado = save(clienteExistente);

            // Retornar el cliente actualizado
            return ResponseEntity.ok(clienteGuardado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
