package com.disney.challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personajes")
@ToString
@Getter
@Setter
public class Personaje {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "historia")
    private String historia;
    @ManyToMany(mappedBy = "personajes")
    private List<Pelicula> peliculas;
}