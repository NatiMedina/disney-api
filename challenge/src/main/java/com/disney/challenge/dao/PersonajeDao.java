package com.disney.challenge.dao;

import com.disney.challenge.models.Personaje;

import java.util.List;

public interface PersonajeDao {

    Personaje getPersonaje(Long id);

    List<Personaje> getPersonajes(String name, Integer age, Long movieId);

    Personaje crearPersonaje(Personaje personaje);

    void eliminarPersonaje(Long id);

    Personaje modificarPersonaje(Long id, Personaje personaje);
}
