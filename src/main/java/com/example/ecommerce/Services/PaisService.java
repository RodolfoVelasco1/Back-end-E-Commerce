package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.Pais;
import com.example.ecommerce.Repositories.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends BaseService<Pais, Long>{
    public PaisService(PaisRepository paisRepository){
        super(paisRepository);
    }
}
