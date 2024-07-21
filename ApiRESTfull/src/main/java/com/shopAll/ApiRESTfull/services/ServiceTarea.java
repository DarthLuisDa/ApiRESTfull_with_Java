package com.shopAll.ApiRESTfull.services;

import com.shopAll.ApiRESTfull.models.Tarea;
import com.shopAll.ApiRESTfull.repositories.RepositoryTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTarea implements ServiceTareaI {
    @Autowired                           //Indica a SpringFramework que debe inyectar una instancia
    RepositoryTarea repositoryTarea;      //de la interfaz RepositoryTarea

    @Override                                 //Sobrescritura de los métodos implementados en la Interface
    public List<Tarea> obtenerTarea() {
        return repositoryTarea.findAll();
    }

    @Override
    public Tarea obtenerTareaPorId(Long id) {
        return repositoryTarea.findById(id).orElse(null);
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return repositoryTarea.save(tarea);
    }

    @Override
    public Tarea borrarTareaPorId(Long id) {
        repositoryTarea.deleteById(id);
        return null;
    }

    @Override
    public Tarea modificarTareaCompleta(Tarea tarea) {
        return repositoryTarea.save(tarea);
    }

    @Override
    public Tarea modificarTareaPorID(Tarea tarea){
        return repositoryTarea.save(tarea);
    }
}
