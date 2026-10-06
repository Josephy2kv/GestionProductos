package com.gestionproductos.GestionProductos.repository;

import com.gestionproductos.GestionProductos.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository
        extends JpaRepository<Etiqueta, Integer> {
}