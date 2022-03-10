package com.disney.challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "personajes")
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