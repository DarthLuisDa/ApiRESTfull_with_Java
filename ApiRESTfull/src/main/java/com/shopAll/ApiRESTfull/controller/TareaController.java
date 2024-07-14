package com.shopAll.ApiRESTfull.controller;

import com.shopAll.ApiRESTfull.entity.Tarea;
import com.shopAll.ApiRESTfull.service.ServiceTarea;
import com.shopAll.ApiRESTfull.service.ServiceTareaI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestor_de_tareas_db")
public class TareaController {
    @Autowired
    ServiceTareaI serviceTarea;



    @GetMapping("/tareas")
    public List<Tarea> obtenerTarea() {
        return serviceTarea.obtenerTarea();
    }

    @GetMapping("/tarea/{id}")
    public Tarea obtenerTareaPorId(@PathVariable Long id) {
        return serviceTarea.obtenerTareaPorId(id);        //Path para borrar
    }

    @PostMapping("/tarea")
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return serviceTarea.crearTarea(tarea);            //Request para modificar
    }

    @DeleteMapping("/tarea/{id}")
    public Tarea borrarTarea(@PathVariable Long id) {
        return serviceTarea.borrarTareaPorId(id);
    }

    @PatchMapping("/tarea")
    public Tarea modificarTarea(@RequestBody Tarea tarea) {
        return serviceTarea.modificarTareaCompleta(tarea);
    }

    @PutMapping("/tarea/{id}")
    public Tarea modificarTareaPorID(@RequestBody Tarea tarea) {
        return serviceTarea.modificarTareaPorID(tarea);
    }

}