package com.example.ecommerce;

import com.example.ecommerce.Models.Entities.*;
import com.example.ecommerce.Models.Enums.*;
import com.example.ecommerce.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private DireccionRepository direccionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DetalleProductoRepository detalleProductoRepository;
    @Autowired
    private ImagenRepository imagenRepository;
    @Autowired
    private DescuentoRepository descuentoRepository;
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    @Autowired
    private OrdenCompraDetalleRepository ordenCompraDetalleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Verificando y creando datos de ejemplo...");

            // 1. Crear geografía
            if (paisRepository.count() == 0) {
                System.out.println("Creando datos geográficos...");
                crearDatosGeograficos();
            }

            // 2. Crear usuarios
            if (usuarioRepository.count() == 0) {
                System.out.println("Creando usuarios...");
                crearUsuarios();
            }

            // 3. Crear categorías
            if (categoriaRepository.count() == 0) {
                System.out.println("Creando categorías...");
                crearCategorias();
            }

            // 4. Crear imágenes
            if (imagenRepository.count() == 0) {
                System.out.println("Creando imágenes...");
                crearImagenes();
            }

            // 5. Crear productos
            if (productoRepository.count() == 0) {
                System.out.println("Creando productos...");
                crearProductos();
            }

            // 6. Crear detalles de productos
            if (detalleProductoRepository.count() == 0) {
                System.out.println("Creando detalles de productos con precios...");
                crearDetalleProductos();
            }

            // 7. Crear descuentos
            if (descuentoRepository.count() == 0) {
                System.out.println("Creando descuentos...");
                crearDescuentos();
            }

            // 8. Crear órdenes de compra
            if (ordenCompraRepository.count() == 0) {
                System.out.println("Creando órdenes de compra...");
                crearOrdenesCompra();
            }

            System.out.println("Verificación y creación de datos de ejemplo completada.");

        } catch (Exception e) {
            System.err.println("Error al crear datos de ejemplo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void crearDatosGeograficos() {
        // Crear países
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();
        Pais brasil = Pais.builder()
                .nombre("Brasil")
                .build();
        paisRepository.saveAll(Arrays.asList(argentina, brasil));

        // Crear provincias
        Provincia buenosAires = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();
        Provincia cordoba = Provincia.builder()
                .nombre("Córdoba")
                .pais(argentina)
                .build();
        Provincia santaFe = Provincia.builder()
                .nombre("Santa Fe")
                .pais(argentina)
                .build();
        provinciaRepository.saveAll(Arrays.asList(buenosAires, cordoba, santaFe));

        // Crear localidades
        Localidad caba = Localidad.builder()
                .nombre("Ciudad Autónoma de Buenos Aires")
                .provincia(buenosAires)
                .build();
        Localidad laplata = Localidad.builder()
                .nombre("La Plata")
                .provincia(buenosAires)
                .build();
        Localidad marDelPlata = Localidad.builder()
                .nombre("Mar del Plata")
                .provincia(buenosAires)
                .build();
        Localidad cordobaCapital = Localidad.builder()
                .nombre("Córdoba Capital")
                .provincia(cordoba)
                .build();
        Localidad rosario = Localidad.builder()
                .nombre("Rosario")
                .provincia(santaFe)
                .build();
        localidadRepository.saveAll(Arrays.asList(caba, laplata, marDelPlata, cordobaCapital, rosario));

        // Crear direcciones
        Direccion dir1 = Direccion.builder()
                .calle("Av. Corrientes")
                .numero(1234)
                .deptoNro(5)
                .codigoPostal(1043)
                .localidad(caba)
                .build();
        Direccion dir2 = Direccion.builder()
                .calle("Calle 7")
                .numero(456)
                .deptoNro(0)
                .codigoPostal(1900)
                .localidad(laplata)
                .build();
        Direccion dir3 = Direccion.builder()
                .calle("Av. Independencia")
                .numero(789)
                .deptoNro(2)
                .codigoPostal(7600)
                .localidad(marDelPlata)
                .build();
        Direccion dir4 = Direccion.builder()
                .calle("Av. Colón")
                .numero(321)
                .deptoNro(0)
                .codigoPostal(5000)
                .localidad(cordobaCapital)
                .build();
        direccionRepository.saveAll(Arrays.asList(dir1, dir2, dir3, dir4));
    }

    private void crearUsuarios() {
        Usuario admin = Usuario.builder()
                .username("admin")
                .nombre("Juan")
                .apellido("Pérez")
                .password(passwordEncoder.encode("admin123"))
                .rol(Rol.ADMIN)
                .direcciones(new HashSet<>())
                .build();

        Usuario usuario1 = Usuario.builder()
                .username("maria.garcia")
                .nombre("María")
                .apellido("García")
                .password(passwordEncoder.encode("usuario123"))
                .rol(Rol.USUARIO)
                .direcciones(new HashSet<>())
                .build();

        Usuario usuario2 = Usuario.builder()
                .username("carlos.lopez")
                .nombre("Carlos")
                .apellido("López")
                .password(passwordEncoder.encode("usuario456"))
                .rol(Rol.USUARIO)
                .direcciones(new HashSet<>())
                .build();

        Usuario usuario3 = Usuario.builder()
                .username("ana.martinez")
                .nombre("Ana")
                .apellido("Martínez")
                .password(passwordEncoder.encode("usuario789"))
                .rol(Rol.USUARIO)
                .direcciones(new HashSet<>())
                .build();

        usuarioRepository.saveAll(Arrays.asList(admin, usuario1, usuario2, usuario3));
        asignarDireccionesAUsuarios();
    }

    private void asignarDireccionesAUsuarios() {
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            List<Direccion> direcciones = direccionRepository.findAll();

            if (usuarios.size() >= 4 && direcciones.size() >= 4) {
                // Asignar direcciones a usuarios
                usuarios.get(0).getDirecciones().add(direcciones.get(0)); // admin - CABA
                direcciones.get(0).getUsuarios().add(usuarios.get(0));

                usuarios.get(1).getDirecciones().add(direcciones.get(1)); // maria - La Plata
                direcciones.get(1).getUsuarios().add(usuarios.get(1));

                usuarios.get(2).getDirecciones().add(direcciones.get(2)); // carlos - Mar del Plata
                direcciones.get(2).getUsuarios().add(usuarios.get(2));

                usuarios.get(3).getDirecciones().add(direcciones.get(3)); // ana - Córdoba
                direcciones.get(3).getUsuarios().add(usuarios.get(3));

                usuarioRepository.saveAll(usuarios);
                direccionRepository.saveAll(direcciones);
            }
        } catch (Exception e) {
            System.err.println("Error al asignar direcciones: " + e.getMessage());
        }
    }

    private void crearCategorias() {
        // Categorías principales
        Categoria indumentaria = Categoria.builder()
                .nombre("Indumentaria")
                .build();
        Categoria calzado = Categoria.builder()
                .nombre("Calzado")
                .build();
        categoriaRepository.saveAll(Arrays.asList(indumentaria, calzado));

        // Subcategorías de indumentaria
        Categoria remeras = Categoria.builder()
                .nombre("Remeras")
                .categoriaPadre(indumentaria)
                .build();
        Categoria pantalones = Categoria.builder()
                .nombre("Pantalones")
                .categoriaPadre(indumentaria)
                .build();
        Categoria buzos = Categoria.builder()
                .nombre("Buzos")
                .categoriaPadre(indumentaria)
                .build();
        Categoria camperas = Categoria.builder()
                .nombre("Camperas")
                .categoriaPadre(indumentaria)
                .build();

        // Subcategorías de calzado
        Categoria zapatillas = Categoria.builder()
                .nombre("Zapatillas")
                .categoriaPadre(calzado)
                .build();
        Categoria zapatos = Categoria.builder()
                .nombre("Zapatos")
                .categoriaPadre(calzado)
                .build();
        Categoria botas = Categoria.builder()
                .nombre("Botas")
                .categoriaPadre(calzado)
                .build();

        categoriaRepository.saveAll(Arrays.asList(remeras, pantalones, buzos, camperas, zapatillas, zapatos, botas));
    }

    private void crearImagenes() {
        Imagen img1 = Imagen.builder()
                .url("https://example.com/images/remera-basica-blanca.jpg")
                .build();
        Imagen img2 = Imagen.builder()
                .url("https://example.com/images/remera-basica-negra.jpg")
                .build();
        Imagen img3 = Imagen.builder()
                .url("https://example.com/images/zapatillas-deportivas-blancas.jpg")
                .build();
        Imagen img4 = Imagen.builder()
                .url("https://example.com/images/zapatillas-deportivas-negras.jpg")
                .build();
        Imagen img5 = Imagen.builder()
                .url("https://example.com/images/jean-clasico-azul.jpg")
                .build();
        Imagen img6 = Imagen.builder()
                .url("https://example.com/images/buzo-algodon-gris.jpg")
                .build();
        Imagen img7 = Imagen.builder()
                .url("https://example.com/images/campera-invierno-negra.jpg")
                .build();
        Imagen img8 = Imagen.builder()
                .url("https://example.com/images/zapatos-cuero-marron.jpg")
                .build();

        imagenRepository.saveAll(Arrays.asList(img1, img2, img3, img4, img5, img6, img7, img8));
    }

    private void crearProductos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        Categoria remeras = categorias.stream().filter(c -> "Remeras".equals(c.getNombre())).findFirst().orElse(null);
        Categoria zapatillas = categorias.stream().filter(c -> "Zapatillas".equals(c.getNombre())).findFirst().orElse(null);
        Categoria pantalones = categorias.stream().filter(c -> "Pantalones".equals(c.getNombre())).findFirst().orElse(null);
        Categoria buzos = categorias.stream().filter(c -> "Buzos".equals(c.getNombre())).findFirst().orElse(null);
        Categoria camperas = categorias.stream().filter(c -> "Camperas".equals(c.getNombre())).findFirst().orElse(null);
        Categoria zapatos = categorias.stream().filter(c -> "Zapatos".equals(c.getNombre())).findFirst().orElse(null);

        Producto remera = Producto.builder()
                .nombre("Remera Básica")
                .sexo(Sexo.UNISEX)
                .tipoProducto(TipoProducto.INDUMENTARIA)
                .categorias(remeras != null ? new HashSet<>(Arrays.asList(remeras)) : new HashSet<>())
                .build();

        Producto zapatilla = Producto.builder()
                .nombre("Zapatillas Deportivas")
                .sexo(Sexo.UNISEX)
                .tipoProducto(TipoProducto.CALZADO)
                .categorias(zapatillas != null ? new HashSet<>(Arrays.asList(zapatillas)) : new HashSet<>())
                .build();

        Producto jean = Producto.builder()
                .nombre("Jean Clásico")
                .sexo(Sexo.UNISEX)
                .tipoProducto(TipoProducto.INDUMENTARIA)
                .categorias(pantalones != null ? new HashSet<>(Arrays.asList(pantalones)) : new HashSet<>())
                .build();

        Producto buzo = Producto.builder()
                .nombre("Buzo de Algodón")
                .sexo(Sexo.UNISEX)
                .tipoProducto(TipoProducto.INDUMENTARIA)
                .categorias(buzos != null ? new HashSet<>(Arrays.asList(buzos)) : new HashSet<>())
                .build();

        Producto campera = Producto.builder()
                .nombre("Campera de Invierno")
                .sexo(Sexo.UNISEX)
                .tipoProducto(TipoProducto.INDUMENTARIA)
                .categorias(camperas != null ? new HashSet<>(Arrays.asList(camperas)) : new HashSet<>())
                .build();

        Producto zapato = Producto.builder()
                .nombre("Zapatos de Cuero")
                .sexo(Sexo.HOMBRE)
                .tipoProducto(TipoProducto.CALZADO)
                .categorias(zapatos != null ? new HashSet<>(Arrays.asList(zapatos)) : new HashSet<>())
                .build();

        productoRepository.saveAll(Arrays.asList(remera, zapatilla, jean, buzo, campera, zapato));
    }

    private void crearDetalleProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<Imagen> imagenes = imagenRepository.findAll();

        if (productos.isEmpty()) return;

        // Detalles para Remera Básica
        Producto remera = productos.stream().filter(p -> "Remera Básica".equals(p.getNombre())).findFirst().orElse(null);
        if (remera != null) {
            Precio precio1 = Precio.builder()
                    .precioCompra(800.0)
                    .precioVenta(1500.0)
                    .build();

            DetalleProducto detalleRemera1 = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.M)
                    .color(Color.BLANCO)
                    .marca("Básica")
                    .stock(50)
                    .precio(precio1)
                    .producto(remera)
                    .imagenes(imagenes.subList(0, 1))
                    .build();

            DetalleProducto detalleRemera2 = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.L)
                    .color(Color.NEGRO)
                    .marca("Básica")
                    .stock(30)
                    .precio(precio1)
                    .producto(remera)
                    .imagenes(imagenes.subList(1, 2))
                    .build();

            detalleProductoRepository.saveAll(Arrays.asList(detalleRemera1, detalleRemera2));
        }

        // Detalles para Zapatillas Deportivas
        Producto zapatilla = productos.stream().filter(p -> "Zapatillas Deportivas".equals(p.getNombre())).findFirst().orElse(null);
        if (zapatilla != null) {
            Precio precio2 = Precio.builder()
                    .precioCompra(2500.0)
                    .precioVenta(4500.0)
                    .build();
            DetalleProducto detalleZapatilla1 = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.TALLE_42)
                    .color(Color.BLANCO)
                    .marca("SportMax")
                    .stock(25)
                    .precio(precio2)
                    .producto(zapatilla)
                    .imagenes(imagenes.subList(2, 3))
                    .build();

            DetalleProducto detalleZapatilla2 = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.TALLE_41)
                    .color(Color.NEGRO)
                    .marca("SportMax")
                    .stock(20)
                    .precio(precio2)
                    .producto(zapatilla)
                    .imagenes(imagenes.subList(3, 4))
                    .build();

            detalleProductoRepository.saveAll(Arrays.asList(detalleZapatilla1, detalleZapatilla2));
        }

        // Detalles para Jean Clásico
        Producto jean = productos.stream().filter(p -> "Jean Clásico".equals(p.getNombre())).findFirst().orElse(null);
        if (jean != null) {
            Precio precio3 = Precio.builder()
                    .precioCompra(1200.0)
                    .precioVenta(2200.0)
                    .build();
            DetalleProducto detalleJean = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.L)
                    .color(Color.AZUL)
                    .marca("Denim Co.")
                    .stock(40)
                    .precio(precio3)
                    .producto(jean)
                    .imagenes(imagenes.subList(4, 5))
                    .build();

            detalleProductoRepository.save(detalleJean);
        }

        // Detalles para Buzo de Algodón
        Producto buzo = productos.stream().filter(p -> "Buzo de Algodón".equals(p.getNombre())).findFirst().orElse(null);
        if (buzo != null) {
            Precio precio4 = Precio.builder()
                    .precioCompra(1800.0)
                    .precioVenta(3200.0)
                    .build();
            DetalleProducto detalleBuzo = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.XL)
                    .color(Color.GRIS)
                    .marca("Comfort")
                    .stock(35)
                    .precio(precio4)
                    .producto(buzo)
                    .imagenes(imagenes.subList(5, 6))
                    .build();

            detalleProductoRepository.save(detalleBuzo);
        }

        // Detalles para Campera de Invierno
        Producto campera = productos.stream().filter(p -> "Campera de Invierno".equals(p.getNombre())).findFirst().orElse(null);
        if (campera != null) {
            Precio precio5 = Precio.builder()
                    .precioCompra(3000.0)
                    .precioVenta(5500.0)
                    .build();

            DetalleProducto detalleCampera = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.L)
                    .color(Color.NEGRO)
                    .marca("WinterWear")
                    .stock(15)
                    .precio(precio5)
                    .producto(campera)
                    .imagenes(imagenes.subList(6, 7))
                    .build();

            detalleProductoRepository.save(detalleCampera);
        }

        // Detalles para Zapatos de Cuero
        Producto zapato = productos.stream().filter(p -> "Zapatos de Cuero".equals(p.getNombre())).findFirst().orElse(null);
        if (zapato != null) {
            Precio precio6 = Precio.builder()
                    .precioCompra(4000.0)
                    .precioVenta(7200.0)
                    .build();
            DetalleProducto detalleZapato = DetalleProducto.builder()
                    .estado(true)
                    .talle(Talle.TALLE_43)
                    .color(Color.MARRON)
                    .marca("Leather Plus")
                    .stock(18)
                    .precio(precio6)
                    .producto(zapato)
                    .imagenes(imagenes.subList(7, 8))
                    .build();

            detalleProductoRepository.save(detalleZapato);
        }
    }

    private void crearDescuentos() {
        List<DetalleProducto> detalleProductos = detalleProductoRepository.findAll();

        if (detalleProductos.size() >= 3) {
            Descuento descuentoTemporada = Descuento.builder()
                    .porcentaje(20.0)
                    .fechaInicio(LocalDateTime.now().minusDays(10))
                    .fechaFinal(LocalDateTime.now().plusDays(20))
                    .precios(Arrays.asList(
                            detalleProductos.get(0).getPrecio(),
                            detalleProductos.get(2).getPrecio()
                    ))
                    .build();

            Descuento descuentoLiquidacion = Descuento.builder()
                    .porcentaje(35.0)
                    .fechaInicio(LocalDateTime.now().minusDays(5))
                    .fechaFinal(LocalDateTime.now().plusDays(15))
                    .precios(detalleProductos.size() > 4 ?
                            Arrays.asList(detalleProductos.get(4).getPrecio()) :
                            Arrays.asList(detalleProductos.get(0).getPrecio()))
                    .build();

            Descuento descuentoBlackFriday = Descuento.builder()
                    .porcentaje(15.0)
                    .fechaInicio(LocalDateTime.now().plusDays(30))
                    .fechaFinal(LocalDateTime.now().plusDays(35))
                    .precios(Arrays.asList(detalleProductos.get(1).getPrecio()))
                    .build();

            descuentoRepository.saveAll(Arrays.asList(descuentoTemporada, descuentoLiquidacion, descuentoBlackFriday));
        }
    }


    private void crearOrdenesCompra() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Direccion> direcciones = direccionRepository.findAll();
        List<DetalleProducto> detalleProductos = detalleProductoRepository.findAll();

        if (usuarios.size() >= 2 && direcciones.size() >= 2 && detalleProductos.size() >= 3) {
            // Orden de compra 1 - María García
            OrdenCompra orden1 = OrdenCompra.builder()
                    .total(5200.0f) // 2 remeras (3000) + 1 jean (2200)
                    .fechaDeCompra(LocalDateTime.now().minusDays(5))
                    .direccion(direcciones.get(1)) // La Plata
                    .build();
            ordenCompraRepository.save(orden1);

            // Detalles de la orden 1
            OrdenCompraDetalle detalle1_1 = OrdenCompraDetalle.builder()
                    .cantidad(2)
                    .subtotal(3000.0) // 2 * 1500 (precio de venta remera)
                    .ordenCompra(orden1)
                    .detalleProducto(detalleProductos.get(0)) // Remera blanca M
                    .build();

            OrdenCompraDetalle detalle1_2 = OrdenCompraDetalle.builder()
                    .cantidad(1)
                    .subtotal(2200.0) // 1 * 2200 (precio de venta jean)
                    .ordenCompra(orden1)
                    .detalleProducto(detalleProductos.get(2)) // Jean azul L
                    .build();

            ordenCompraDetalleRepository.saveAll(Arrays.asList(detalle1_1, detalle1_2));

            // Orden de compra 2 - Carlos López
            OrdenCompra orden2 = OrdenCompra.builder()
                    .total(10000.0f) // 1 zapatilla (4500) + 1 campera (5500)
                    .fechaDeCompra(LocalDateTime.now().minusDays(2))
                    .direccion(direcciones.get(2)) // Mar del Plata
                    .build();
            ordenCompraRepository.save(orden2);

            // Detalles de la orden 2
            OrdenCompraDetalle detalle2_1 = OrdenCompraDetalle.builder()
                    .cantidad(1)
                    .subtotal(4500.0) // 1 * 4500 (precio de venta zapatilla)
                    .ordenCompra(orden2)
                    .detalleProducto(detalleProductos.get(1)) // Zapatilla negra 41
                    .build();

            OrdenCompraDetalle detalle2_2 = OrdenCompraDetalle.builder()
                    .cantidad(1)
                    .subtotal(5500.0) // 1 * 5500 (precio de venta campera)
                    .ordenCompra(orden2)
                    .detalleProducto(detalleProductos.size() > 4 ? detalleProductos.get(4) : detalleProductos.get(1))
                    .build();

            ordenCompraDetalleRepository.saveAll(Arrays.asList(detalle2_1, detalle2_2));

            // Orden de compra 3 - Ana Martínez
            OrdenCompra orden3 = OrdenCompra.builder()
                    .total(3200.0f) // 1 buzo (3200)
                    .fechaDeCompra(LocalDateTime.now().minusHours(12))
                    .direccion(direcciones.get(3)) // Córdoba
                    .build();
            ordenCompraRepository.save(orden3);

            // Detalle de la orden 3
            OrdenCompraDetalle detalle3_1 = OrdenCompraDetalle.builder()
                    .cantidad(1)
                    .subtotal(3200.0) // 1 * 3200 (precio de venta buzo)
                    .ordenCompra(orden3)
                    .detalleProducto(detalleProductos.size() > 3 ? detalleProductos.get(3) : detalleProductos.get(0))
                    .build();

            ordenCompraDetalleRepository.save(detalle3_1);
        }
    }
}