package org.esfe.Examen20240819.repositorios;

import org.esfe.Examen20240819.modelos.ProductoEYCD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoEYCD, Integer>{
    
}
