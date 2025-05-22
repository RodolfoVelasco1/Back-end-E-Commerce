package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.Imagen;
import com.example.ecommerce.Repositories.ImagenRepository;
import org.springframework.stereotype.Service;

@Service
public class ImagenService extends BaseService<Imagen,Long> {
    public ImagenService(ImagenRepository imagenRepository){
        super(imagenRepository);
    }

}