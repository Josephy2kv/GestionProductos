package com.gestionproductos.GestionProductos.service;

import com.gestionproductos.GestionProductos.dto.EtiquetaRequestDTO;
import com.gestionproductos.GestionProductos.entity.Etiqueta;
import com.gestionproductos.GestionProductos.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Etiqueta> listar() {
        return etiquetaRepository.findAll();
    }

    public Etiqueta buscarPorId(Integer id) {
        return etiquetaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Etiqueta no encontrada"));
    }

    public Etiqueta guardar(EtiquetaRequestDTO dto) {

        Etiqueta etiqueta = new Etiqueta();

        etiqueta.setNombre(dto.getNombre());

        return etiquetaRepository.save(etiqueta);
    }

    public Etiqueta actualizar(
            Integer id,
            EtiquetaRequestDTO dto) {

        Etiqueta etiqueta = buscarPorId(id);

        etiqueta.setNombre(dto.getNombre());

        return etiquetaRepository.save(etiqueta);
    }

    public void eliminar(Integer id) {
        Etiqueta etiqueta = buscarPorId(id);

        etiquetaRepository.delete(etiqueta);
    }
}