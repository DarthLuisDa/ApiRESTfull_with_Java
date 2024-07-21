package com.shopAll.ApiRESTfull.controllers;

import com.shopAll.ApiRESTfull.exceptions.InvalidTareaDataException;
import com.shopAll.ApiRESTfull.models.Tarea;
import com.shopAll.ApiRESTfull.exceptions.TareaNotFoundException;
import com.shopAll.ApiRESTfull.services.ServiceTareaI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.DoubleStream.concat;

@RestController                              //Explicar a SpringFramework que TareaController es un controlador
@RequestMapping("/gestor_de_tareas_db")      //Ruta base para solicitudes HTTP, realizar operaciones en recursos REST
public class TareaController {               //Se implementa la clase Controlador Tarea

    @Autowired                       //Indica a SpringFramework que debe inyectar una instancia
    ServiceTareaI serviceTarea;      //de la interfaz ServiceTareaI

    //Métodos GETTERS y SETTERS

    @GetMapping("/tareas")                      //Obtener la lista completa
    public List<Tarea> obtenerTarea() {         //Se implementa el llamado al service
        return serviceTarea.obtenerTarea();     //Retorna el service tarea con su método
    }


    @GetMapping("/tarea/{id}")                                   //Obtener una tarea

    //Código GET sin manejo de excepciones
    // public Tarea obtenerTareaPorId(@PathVariable Long id) {    //Se implementa el llamado al service  //Path para borrar
    //     return serviceTarea.obtenerTareaPorId(id);             //Retorna el service tarea con su método
    //  }

    //Con manejo de excepciones
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) throws TareaNotFoundException{
        Tarea tarea;
        tarea = serviceTarea.obtenerTareaPorId(id);
        if (tarea == null) {
           throw new TareaNotFoundException("Tarea"+" "+ id +" "+"no encontrada","err-12", HttpStatus.NOT_FOUND);
       }
       return ResponseEntity.ok(tarea);
    }


    @PostMapping("/tarea")                                      //Añadir una tarea

    //Código POST sin manejo de excepciones
    //public Tarea crearTarea(@RequestBody Tarea tarea) {       //Se implementa el llamado al service   //Request para modificar
    //    return serviceTarea.crearTarea(tarea);                //Retorna el service tarea con su método
    //}

    //Con manejo de excepciones
    public ResponseEntity<Tarea> crearTarea(@Valid @RequestBody Tarea tarea, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidTareaDataException("Nombre Tarea obligatorio", "err-13", HttpStatus.NOT_FOUND, bindingResult);
        }
        Tarea tareaCreada = serviceTarea.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaCreada);
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

    // public Tarea modificarTareaPorID(@RequestBody Tarea tarea) {     //Se implementa el llamado al service   //Request para modificar
   //     return serviceTarea.modificarTareaPorID(tarea);               //Retorna el service tarea con su método
   // }
    public ResponseEntity<Tarea> modificarTareaPorID(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea estudianteModificado = serviceTarea.modificarTareaPorID(id,tarea);
        if(estudianteModificado==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(estudianteModificado);
    }

}
