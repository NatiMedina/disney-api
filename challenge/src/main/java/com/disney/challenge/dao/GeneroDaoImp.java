package com.disney.challenge.dao;

import com.disney.challenge.models.Genero;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class GeneroDaoImp implements GeneroDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Genero> getGeneros() {
        String query = "FROM generos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Genero crearGenero(Genero genero) {
        if(genero != null){
            entityManager.persist(genero);
        }
        return genero;
    }

    @Override
    public void eliminarGenero(Long id) {
        Genero genero = entityManager.find(Genero.class, id){
            if (genero != null) {
                entityManager.remove(genero);
            }
        }
    }

    @Override
    public Genero modificarGenero(Long id, Genero genero) {
        Genero oldGenero = entityManager.find(Genero.class, id);
        if (oldGenero != null && genero != null) {
            if (genero.getNombre() != null) {
                oldGenero.setNombre(genero.getNombre());
            }
            if (genero.getImagen() != null) {
                oldGenero.setImagen(genero.getImagen());
            }
            if (genero.getPeliculas() != null) {
                oldGenero.setPeliculas(genero.getPeliculas());
            }
        }
        return oldGenero;
    }
}
