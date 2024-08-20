package org.esfe.Examen20240819.servicios.implementaciones;

import org.esfe.Examen20240819.modelos.ProductoEYCD;
import org.esfe.Examen20240819.repositorios.IProductoRepository;
import org.esfe.Examen20240819.servicios.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService{
 
    @Autowired
    private IProductoRepository ProductoRepository;

    @Override
    public Page<ProductoEYCD> buscarTodosPaginados(Pageable pageable) {
        return ProductoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoEYCD> obtenerTodos() {
        return ProductoRepository.findAll();
    }

    @Override
    public Optional<ProductoEYCD> buscarPorId(Integer id) {
        return ProductoRepository.findById(id);
    }

    @Override
    public ProductoEYCD crearOEditar(ProductoEYCD ProductoEYCD) {
        return ProductoRepository.save(ProductoEYCD);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ProductoRepository.deleteById(id);
    }
}
