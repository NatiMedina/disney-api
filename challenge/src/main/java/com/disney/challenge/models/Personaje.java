package com.disney.challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

@ToString
@Getter
@Setter

public class Personaje {

    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private double peso;

    private String historia;

    private List<Pelicula> peliculas;
}