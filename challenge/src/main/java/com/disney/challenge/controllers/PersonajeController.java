package com.disney.challenge.controllers;

import com.disney.challenge.dao.PersonajeDao;
import com.disney.challenge.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonajeController {

    @Autowired
    public PersonajeDao personajeDao;

    @RequestMapping(value = "/character", method = RequestMethod.POST)
    public Personaje createPersonaje(@RequestBody Personaje personaje) {
        return personajeDao.crearPersonaje(personaje);
    }

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public Map<String, String> getPersonajes(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) Long movies) {
        List<Personaje> personajes = personajeDao.getPersonajes(name, age, movies);
        Map<String, String> nombreImagen = new HashMap<>();
        for (Personaje p : personajes) {
            nombreImagen.put(p.getNombre(), p.getImagen());
        }
        return nombreImagen;
    }

    @RequestMapping(value = "character/{id}", method = RequestMethod.GET)
    public Personaje getPersonaje(@PathVariable Long id) {
        return personajeDao.getPersonaje(id);
    }

    @RequestMapping(value = "character/{id}", method = RequestMethod.DELETE)
    public void eliminarPersonaje(@PathVariable Long id) {
        if (id != null) {
            personajeDao.eliminarPersonaje(id);
        }
    }

    @RequestMapping(value = "character/{id}", method = RequestMethod.PATCH)
    public Personaje modificarPersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
        return personajeDao.modificarPersonaje(id, personaje);
    }
}
