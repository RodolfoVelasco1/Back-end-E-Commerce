package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.Producto;
import com.example.ecommerce.Models.Enums.Color;
import com.example.ecommerce.Models.Enums.Sexo;
import com.example.ecommerce.Models.Enums.Talle;
import com.example.ecommerce.Models.Enums.TipoProducto;
import com.example.ecommerce.Repositories.ProductoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService extends BaseService<Producto,Long>{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository){
        super(productoRepository);
    }
    public List<Producto> filtrarProductos(
            String descripcion,
            Sexo sexo,
            TipoProducto tipoProducto,
            List<Long> categoriaIds,
            Color color,
            Talle talle,
            String marca,
            Double precioMin,
            Double precioMax
    ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
        Root<Producto> producto = cq.from(Producto.class);

        Join<Object, Object> detalle = producto.join("detalleProductos", JoinType.LEFT);
        Join<Object, Object> precio = detalle.join("precio", JoinType.LEFT);
        Join<Object, Object> categorias = producto.join("categorias", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (descripcion != null && !descripcion.isEmpty()) {
            predicates.add(cb.like(cb.lower(producto.get("descripcion")), "%" + descripcion.toLowerCase() + "%"));
        }

        if (sexo != null) {
            predicates.add(cb.equal(producto.get("sexo"), sexo));
        }

        if (tipoProducto != null) {
            predicates.add(cb.equal(producto.get("tipoProducto"), tipoProducto));
        }

        if (categoriaIds != null && !categoriaIds.isEmpty()) {
            predicates.add(categorias.get("id").in(categoriaIds));
        }

        if (color != null) {
            predicates.add(cb.equal(detalle.get("color"), color));
        }

        if (talle != null) {
            predicates.add(cb.equal(detalle.get("talle"), talle));
        }

        if (marca != null && !marca.isEmpty()) {
            predicates.add(cb.equal(detalle.get("marca"), marca));
        }

        if (precioMin != null) {
            predicates.add(cb.greaterThanOrEqualTo(precio.get("precioVenta"), precioMin));
        }

        if (precioMax != null) {
            predicates.add(cb.lessThanOrEqualTo(precio.get("precioVenta"), precioMax));
        }

        cq.select(producto).distinct(true).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
