package com.example.ecommerce.Services;


import com.example.ecommerce.Dto.CategoriaMenuDTO;
import com.example.ecommerce.Dto.SubcategoriaDTO;
import com.example.ecommerce.Models.Entities.Categoria;
import com.example.ecommerce.Models.Enums.Sexo;
import com.example.ecommerce.Repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService extends BaseService<Categoria, Long> {

    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Transactional
    public List<Categoria> listarSubcategorias(Long idPadre) {
        return categoriaRepository.findByCategoriaPadreId(idPadre);
    }

    @Transactional
    public List<Categoria> listarCategoriasRaiz() {
        return categoriaRepository.findByCategoriaPadreIsNull();
    }

    public List<CategoriaMenuDTO> obtenerMenuPorSexo(Sexo sexo) {
        List<Categoria> categoriasPadre = categoriaRepository.findByCategoriaPadreIsNull();
        List<CategoriaMenuDTO> resultado = new ArrayList<>();

        for (Categoria padre : categoriasPadre) {
            List<SubcategoriaDTO> subcategoriasConSexo = padre.getSubcategorias().stream()
                    .filter(sub -> sub.getProductos().stream().anyMatch(p -> p.getSexo() == sexo))
                    .map(sub -> new SubcategoriaDTO(sub.getId(), sub.getNombre()))
                    .collect(Collectors.toList());

            if (!subcategoriasConSexo.isEmpty()) {
                resultado.add(new CategoriaMenuDTO(padre.getNombre(), subcategoriasConSexo));
            }
        }

        return resultado;
    }

}
