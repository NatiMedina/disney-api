package com.disney.challenge.dao;

import com.disney.challenge.models.Genero;

import java.util.List;

public interface GeneroDao {

    List<Genero> getGeneros();

    Genero crearGenero(Genero genero);

    void eliminarGenero(Long id);

    Genero modificarGenero(Long id, Genero genero);

}
