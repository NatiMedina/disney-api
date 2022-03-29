package com.disney.challenge.dao;

import com.disney.challenge.models.Personaje;
import org.hibernate.criterion.MatchMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonajeDaoImp implements PersonajeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Personaje getPersonaje(Long id) {
        return entityManager.find(Personaje.class, id);
    }

    @Override
    @Transactional
    public List<Personaje> getPersonajes(String name, Integer age, Long movieId) {
        if((name == null || name.isEmpty()) && age == null && movieId == null ){
           return entityManager.createQuery("From Personaje")
                    .getResultList();
        }

        String query = "FROM Personaje where LOWER(nombre) like LOWER(:name)";

        return entityManager.createQuery(query).setParameter("name",  MatchMode.ANYWHERE.toMatchString(name)).getResultList();
    }

    @Override
    public Personaje crearPersonaje(Personaje personaje) {
        if (personaje != null) {
            entityManager.persist(personaje);
        }
        return personaje;
    }

    @Override
    public void eliminarPersonaje(Long id) {
        Personaje personaje = entityManager.find(Personaje.class, id);
        if (personaje != null) {
            entityManager.remove(personaje);
        }
    }

    @Override
    public Personaje modificarPersonaje(Long id, Personaje personaje) {
        Personaje oldPersonaje = entityManager.find(Personaje.class, id);
        if (oldPersonaje != null && personaje != null) {
            if (personaje.getImagen() != null) {
                oldPersonaje.setImagen(personaje.getImagen());
            }
            if (personaje.getNombre() != null) {
                oldPersonaje.setNombre(personaje.getNombre());
            }
            oldPersonaje.setEdad(personaje.getEdad());
            oldPersonaje.setPeso(personaje.getPeso());

            if (personaje.getHistoria() != null) {
                oldPersonaje.setHistoria(personaje.getHistoria());
            }
            if (personaje.getPeliculas() != null) {
                oldPersonaje.setPeliculas(personaje.getPeliculas());
            }

        }
        return oldPersonaje;
    }

    @Override
    public List<Personaje> getPersonajePorNombre(String nombrep) {
        String query = "FROM Personaje where nombre = nombrep";
        return entityManager.createQuery(query).getResultList();


    }
}
