package com.disney.challenge.dao;

import com.disney.challenge.models.Personaje;

import org.hibernate.criterion.MatchMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /*public List<Personaje> getPersonajes(String name, Integer age, Long movieId) {
        if((name == null || name.isEmpty()) && age == null && movieId == null ){
           return entityManager.createQuery("From Personaje")
                    .getResultList();
        }

        String query = "FROM Personaje where LOWER(nombre) like LOWER(:name)";

        return entityManager.createQuery(query).setParameter("name",  MatchMode.ANYWHERE.toMatchString(name)).getResultList();
    }*/
    public List<Personaje> getPersonajes(String name, Integer age, Long movieId) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        List<String> whereClause = new ArrayList<String>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select p from Personaje p ");

        if (!name.isEmpty()){
            whereClause.add(" p.nombre =:name ");
            parameterMap.put("name", name);
        }
        if (age != null){
            whereClause.add(" p.edad =:age ");
            parameterMap.put("age", age);
        }

        queryBuilder.append(" where " + String.join( " and ", whereClause));
        Query jpaQuery = entityManager.createQuery(queryBuilder.toString());

        for (String key : parameterMap.keySet()){
            jpaQuery.setParameter(key, parameterMap.get(key));
        }

        return jpaQuery.getResultList();

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

}
