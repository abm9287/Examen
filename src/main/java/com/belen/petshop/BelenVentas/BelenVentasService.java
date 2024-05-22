package com.belen.petshop.BelenVentas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BelenVentasService {
    @Autowired
    private BelenVentasRepository belenVentasRepository;

    // Venta
    public BelenVentas save(BelenVentas entity) {
        return belenVentasRepository.save(entity);
    }

    // Selecciona por id
    public BelenVentas findById(Long id) {
        return belenVentasRepository.findById(id).orElse(null);
    }

    // SELECCIONA TODOS LOS DATOS
    public List<BelenVentas> findAll() {
        return belenVentasRepository.findAll();
    }

    // ELIMINAR
    public void deleteById(Long id) {
        belenVentasRepository.deleteById(id);
    }

    // ACTUALIZAR PARCIALMENTE
    public ResponseEntity<BelenVentas> updateVentas(Long id, BelenVentas entityActualizado) {
        try {
            BelenVentas ventaExistente = findById(id);

            if (ventaExistente == null) {
                return ResponseEntity.notFound().build();
            }

            if (entityActualizado.getFechaVenta() != null) {
                ventaExistente.setFechaVenta(entityActualizado.getFechaVenta());
            }

            if (entityActualizado.getTotal() != null) {
                ventaExistente.setTotal(entityActualizado.getTotal());
            }

            if (entityActualizado.getDescripcion() != null) {
                ventaExistente.setDescripcion(entityActualizado.getDescripcion());
            }

            //GUARDA los cambios
            BelenVentas ventasGuardado = save(ventaExistente);
            return ResponseEntity.ok(ventasGuardado);


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
