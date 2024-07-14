package com.shopAll.ApiRESTfull.service;

import com.shopAll.ApiRESTfull.entity.Tarea;
import com.shopAll.ApiRESTfull.repository.RepositoryTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTarea implements ServiceTareaI {
    @Autowired
    RepositoryTarea repositoryTarea;

    @Override
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
