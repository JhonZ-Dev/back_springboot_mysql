package com.proyecto.proyecto.servicios;

import com.proyecto.proyecto.repositorio.PersonalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServicio {

    @Autowired
    public PersonalesRepo repo;
    
}
