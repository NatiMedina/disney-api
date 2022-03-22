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
        private Integer calificacion;
        @ManyToMany
        @JoinTable(
                name = "pelicula_personaje",
                joinColumns = @JoinColumn(name = "pelicula_id"),
                inverseJoinColumns = @JoinColumn(name = "personaje_id")
        )
        private List<Personaje> personajes;
}
