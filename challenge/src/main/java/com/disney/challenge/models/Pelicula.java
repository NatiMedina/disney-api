package com.disney.challenge.models;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "peliculas")
@ToString
@Getter
@Setter

public class Pelicula {

    private Long id;

    private String imagen;

    private String titulo;

    private Date creacion;

    private int calificacion;

    private List<Personaje> personajes;
}
