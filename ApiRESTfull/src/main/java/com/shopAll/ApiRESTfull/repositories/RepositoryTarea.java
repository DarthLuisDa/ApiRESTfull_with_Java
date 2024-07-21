package com.shopAll.ApiRESTfull.repositories;

import com.shopAll.ApiRESTfull.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;  //JpaRepository: Es una clase proporcionada por Spring Data JPA que ofrece métodos CRUD (Create, Read, Update, Delete) genéricos para interactuar con entidades.
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTarea extends JpaRepository<Tarea,Long> {  //<Long>: Indica que el tipo de dato utilizado para el identificador de la entidad Tarea es Long

}
