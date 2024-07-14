package com.shopAll.ApiRESTfull.repository;

import com.shopAll.ApiRESTfull.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTarea extends JpaRepository<Tarea,Long> {

}
