package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.Descuento;
import com.example.ecommerce.Repositories.DescuentoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DescuentosService extends BaseService<Descuento, Long> {

    private final DescuentoRepository descuentoRepository;

    public DescuentosService(DescuentoRepository descuentoRepository) {
        super(descuentoRepository);
        this.descuentoRepository = descuentoRepository;
    }


    // Método para obtener descuento por ID
    public Optional<Descuento> obtenerPorIdDescuento(Long idDescuento) throws Exception {
        try {
            // Uso del método findById que ahora es el método estándar
            return descuentoRepository.findById(idDescuento);
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el descuento por ID de descuento: " + e.getMessage());
        }
    }


}
