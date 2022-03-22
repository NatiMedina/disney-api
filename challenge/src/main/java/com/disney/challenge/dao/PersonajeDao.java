package com.disney.challenge.dao;

import com.disney.challenge.models.Personaje;

import java.util.List;

public interface PersonajeDao {

    Personaje getPersonaje(Long id);

    List<Personaje> getPersonajes();

    Personaje crearPersonaje(Personaje personaje);

    void eliminarPersonaje(Long id);

    Personaje modificarPersonaje(Long id, Personaje personaje);
}
