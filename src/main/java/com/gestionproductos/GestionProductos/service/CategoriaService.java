package com.gestionproductos.GestionProductos.service;

import com.gestionproductos.GestionProductos.dto.CategoriaRequestDTO;
import com.gestionproductos.GestionProductos.entity.Categoria;
import com.gestionproductos.GestionProductos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));
    }

    public Categoria guardar(CategoriaRequestDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNombre(dto.getNombre());
        categoria.setActiva(dto.isActiva());

        return categoriaRepository.save(categoria);
    }

    public Categoria actualizar(
            Integer id,
            CategoriaRequestDTO dto) {

        Categoria categoria = buscarPorId(id);

        categoria.setNombre(dto.getNombre());
        categoria.setActiva(dto.isActiva());

        return categoriaRepository.save(categoria);
    }

    public void eliminar(Integer id) {
        Categoria categoria = buscarPorId(id);

        categoriaRepository.delete(categoria);
    }
}