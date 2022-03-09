package com.disney.challenge.dao;

import com.disney.challenge.models.Personaje;

import java.util.List;

public interface PersonajeDao {

    List<Personaje> getPersonajes();

    Personaje crearPersonaje(Personaje personaje);

    void eliminarPersonaje(String nombre);

    Personaje modificarPersonaje(String nombre);
}
