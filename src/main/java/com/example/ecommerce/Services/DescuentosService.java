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



    public Optional<Descuento> obtenerPorIdDescuento(Long idDescuento) throws Exception {
        try {

            return descuentoRepository.findById(idDescuento);
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el descuento por ID de descuento: " + e.getMessage());
        }
    }


}
