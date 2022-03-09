package com.disney.challenge.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Genero {

    private Long id;

    private String nombre;

    private String imagen;

    private List<Pelicula> peliculas;
}
