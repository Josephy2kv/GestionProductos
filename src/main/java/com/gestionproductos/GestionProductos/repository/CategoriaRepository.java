package com.gestionproductos.GestionProductos.repository;

import com.gestionproductos.GestionProductos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Integer> {
}