package com.shopAll.ApiRESTfull.services;

import com.shopAll.ApiRESTfull.models.Tarea;

import java.util.List;

//Se implementan los métodos
public interface ServiceTareaI {
    List<Tarea> obtenerTarea();
    Tarea obtenerTareaPorId(Long id);
    Tarea crearTarea(Tarea tarea);
    Tarea borrarTareaPorId(Long id);
    Tarea modificarTareaCompleta(Tarea tarea);
    Tarea modificarTareaPorID(Tarea tarea);
}
