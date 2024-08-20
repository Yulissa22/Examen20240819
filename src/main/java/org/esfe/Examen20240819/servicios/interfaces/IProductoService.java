package org.esfe.Examen20240819.servicios.interfaces;
import org.esfe.Examen20240819.modelos.ProductoEYCD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface IProductoService {

    Page<ProductoEYCD> buscarTodosPaginados(Pageable pageable);

    List<ProductoEYCD> obtenerTodos();

    Optional<ProductoEYCD> buscarPorId(Integer id);

    ProductoEYCD crearOEditar(ProductoEYCD productoEYCD);

    void eliminarPorId(Integer id);
}
