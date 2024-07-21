package com.shopAll.ApiRESTfull.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity                   //se usa para indicarle a la apalicacion que Tarea es una entidad
@Table (name = "Tareas")   //se usa para indicar la tabla a usar de la base de datos
public class Tarea {       //Se implementa la clase Tarea
    @Id                    //Indicar la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Esta anotación indica que el valor del campo id se generará automáticamente por la base de datos.
    // La estrategia GenerationType.IDENTITY indica que la base de datos utilizará un valor auto-incrementable para el campo id.

    @Column(name = "ID_Tarea")  //Se implementa para alinear las columnas de las tablas en las bases de datos
    private Long id;
    @Column(name = "Nombre_Tarea")
    @NotNull(message = "Nombre Tarea Nulo")
    @NotEmpty(message = "Nombre Vacio")
    private String nombre_tarea;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private String estado;

    //Constructor con los cuatro parámetros

    public Tarea(Long id, String nombre_tarea, String descripcion, String estado) {
        this.id = id;
        this.nombre_tarea = nombre_tarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    //Constructor vacío

    public Tarea() {
    }

    //Métodos GETTERS y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return nombre_tarea;
    }

    public void setTitulo(String titulo) {
        this.nombre_tarea = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //TO STRING de la clase Tareas
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre_tarea='" + nombre_tarea + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
