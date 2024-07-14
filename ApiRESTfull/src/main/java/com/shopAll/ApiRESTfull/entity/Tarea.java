package com.shopAll.ApiRESTfull.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tarea")
    Long id;
    @Column(name = "Nombre_Tarea")
    String nombre_tarea;
    @Column(name = "Descripcion")
    String descripcion;
    @Column(name = "Estado")
    String estado;

    public Tarea(Long id, String nombre_tarea, String descripcion, String estado) {
        this.id = id;
        this.nombre_tarea = nombre_tarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea() {
    }

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
