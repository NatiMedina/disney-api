package com.disney.challenge.controllers;

import com.disney.challenge.dao.PersonajeDao;
import com.disney.challenge.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeDao personajeDao;

    @RequestMapping(value = "/character", method = RequestMethod.POST)
    public Personaje createPersonaje(@RequestBody Personaje personaje){
        return personajeDao.crearPersonaje(personaje);
    }
    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public List<List<String>> getPersonajes(){
        return personajeDao.getPersonajes();
    }
}
