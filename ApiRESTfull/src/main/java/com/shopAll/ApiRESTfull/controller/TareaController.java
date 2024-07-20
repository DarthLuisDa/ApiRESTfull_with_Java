package com.shopAll.ApiRESTfull.controller;

import com.shopAll.ApiRESTfull.entity.Tarea;
import com.shopAll.ApiRESTfull.service.ServiceTarea;
import com.shopAll.ApiRESTfull.service.ServiceTareaI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                    //Esplicar a SpringFramework que TareaController es un controlador
@RequestMapping("/gestor_de_tareas_db")     //Ruta base para solicitudes HTTP, realizar operaciones en recursos REST
public class TareaController {    //Se implementa la clase Controlador Tarea
    @Autowired                    //Indica a SpringFramework que debe inyectar una instancia
    ServiceTareaI serviceTarea;    //de la interfaz ServiceTareaI

    //Métodos GETTERS y SETTERS

    @GetMapping("/tareas")                      //Obtener la lista completa
    public List<Tarea> obtenerTarea() {         //Se implementa el llamado al service
        return serviceTarea.obtenerTarea();     //Retorna el service tarea con su método
    }

    @GetMapping("/tarea/{id}")                                 //Obtener una tarea
    public Tarea obtenerTareaPorId(@PathVariable Long id) {    //Se implementa el llamado al service  //Path para borrar
        return serviceTarea.obtenerTareaPorId(id);             //Retorna el service tarea con su método
    }

    @PostMapping("/tarea")                                    //Añadir una tarea
    public Tarea crearTarea(@RequestBody Tarea tarea) {       //Se implementa el llamado al service   //Request para modificar
        return serviceTarea.crearTarea(tarea);                //Retorna el service tarea con su método
    }

    @DeleteMapping("/tarea/{id}")                             //Eliminar una tarea
    public Tarea borrarTarea(@PathVariable Long id) {         //Se implementa el llamado al service   //Path para borrar
        return serviceTarea.borrarTareaPorId(id);             //Retorna el service tarea con su método
    }

    //Tanto el Patch como el Put se usan para modificar, en este ejercicio use el PATCH para modificar la Tarea,
    //y el PUT para modificar con ID.

    @PatchMapping("/tarea")                                        //Modificar una tarea
    public Tarea modificarTarea(@RequestBody Tarea tarea) {        //Se implementa el llamado al service   //Request para modificar
        return serviceTarea.modificarTareaCompleta(tarea);          //Retorna el service tarea con su método
    }

    @PutMapping("/tarea/{id}")                                      //Modificar una tarea con ID
    public Tarea modificarTareaPorID(@RequestBody Tarea tarea) {     //Se implementa el llamado al service   //Request para modificar
        return serviceTarea.modificarTareaPorID(tarea);               //Retorna el service tarea con su método
    }
}
