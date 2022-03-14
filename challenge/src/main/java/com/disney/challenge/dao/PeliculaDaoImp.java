package com.disney.challenge.dao;

import com.disney.challenge.models.Pelicula;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PeliculaDaoImp implements PeliculaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Pelicula> getPeliculas() {
        String query = "FROM Peliculas";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        entityManager.persist(pelicula);
        return pelicula;
    }

    @Override
    public void eliminarPelicula(Long id) {
        Pelicula pelicula = entityManager.find(Pelicula.class, id);
        if(pelicula != null){
            entityManager.remove(pelicula);
        }
    }

    @Override
    public Pelicula modificarPelicula(Long id, Pelicula pelicula) {
        Pelicula oldPelicula = entityManager.find(Pelicula.class, id);
        if(oldPelicula != null && pelicula != null){

            if(pelicula.getImagen() != null){
                oldPelicula.setImagen(pelicula.getImagen());
            }
            if(pelicula.getTitulo() != null){
                oldPelicula.setTitulo(pelicula.getTitulo());
            }
            if(pelicula.getCreacion() != null){
                oldPelicula.setCreacion(pelicula.getCreacion());
            }
            oldPelicula.setCalificacion(pelicula.getCalificacion());
            if(pelicula.getPersonajes() != null){
                oldPelicula.setPersonajes(pelicula.getPersonajes());
            }
        }
        return oldPelicula;
    }
}
