package com.disney.challenge.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "generos")
@ToString
@Getter
@Setter
public class Genero {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;

    @ManyToMany
    private List<Pelicula> peliculas;
}
