package com.example.ecommerce.Services;


import com.example.ecommerce.Models.Entities.Provincia;
import com.example.ecommerce.Repositories.ProvinciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService extends BaseService<Provincia, Long> {
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        super(provinciaRepository);
    }

}
