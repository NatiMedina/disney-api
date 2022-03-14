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
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        @Column(name = "imagen")
        private String imagen;
        @Column(name = "titulo")
        private String titulo;
        @Column(name = "creacion")
        private Date creacion;
        @Column(name = "calificacion")
        private int calificacion;
        @ManyToMany
        private List<Personaje> personajes;
}
