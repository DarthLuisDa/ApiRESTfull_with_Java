package com.shopAll.ApiRESTfull.service;

import com.shopAll.ApiRESTfull.entity.Tarea;

import java.util.List;
import java.util.Optional;

public interface ServiceTareaI {
    List<Tarea> obtenerTarea();
    Tarea obtenerTareaPorId(Long id);
    Tarea crearTarea(Tarea tarea);
    Tarea borrarTareaPorId(Long id);
    Tarea modificarTareaCompleta(Tarea tarea);
    Tarea modificarTareaPorID(Tarea tarea);
}
