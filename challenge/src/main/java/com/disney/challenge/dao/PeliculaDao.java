package com.disney.challenge.dao;

import com.disney.challenge.models.Pelicula;

import java.util.List;

public interface PeliculaDao {

    List<Pelicula> getPeliculas();

    Pelicula crearPelicula(Pelicula pelicula);

    void eliminarPelicula(Long id);

    Pelicula modificarPelicula(Long id, Pelicula pelicula);
}
