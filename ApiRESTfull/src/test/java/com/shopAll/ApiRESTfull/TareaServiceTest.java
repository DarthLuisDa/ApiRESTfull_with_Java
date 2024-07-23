package com.shopAll.ApiRESTfull;

import com.shopAll.ApiRESTfull.exceptions.InvalidTareaDataException;
import com.shopAll.ApiRESTfull.exceptions.TareaNotFoundException;
import com.shopAll.ApiRESTfull.models.Tarea;
import com.shopAll.ApiRESTfull.repositories.RepositoryTarea;
import com.shopAll.ApiRESTfull.services.ServiceTarea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

public class TareaServiceTest {

    @Mock
    private RepositoryTarea repositoryTarea;

    @InjectMocks
    private ServiceTarea serviceTarea;

    Tarea tarea;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        tarea = new Tarea();
        tarea.setId(1L);
        tarea.setTitulo("Acomodar mercancía");
    }
        //Búsqueda completa de la lista
        @Test
        void testGetTarea(){
            when(repositoryTarea.findAll()).thenReturn(List.of(tarea,tarea));
            List<Tarea> listaTareaActual = serviceTarea.obtenerTarea();
            assertEquals(2,listaTareaActual.size());
        }

        //Búsqueda por Id
        @Test
        void testGetTareaById(){
            when(repositoryTarea.findById(1L)).thenReturn(Optional.ofNullable(tarea));
            Tarea tareaActual = serviceTarea.obtenerTareaPorId(1L);
            assertEquals(tarea,tareaActual);
        }

        //Registro exitoso de una Tarea
        @Test
        void testCreateTarea(){
            when(repositoryTarea.save(tarea)).thenReturn(tarea);
            Tarea tareaActual = serviceTarea.crearTarea(tarea);
            assertEquals(tarea,tareaActual);
        }

        //Modificación de una Tarea
        @Test
        void testModifyTarea(){
            when(repositoryTarea.save(tarea)).thenReturn(tarea);
            when(repositoryTarea.findById(1L)).thenReturn(Optional.ofNullable(tarea));
            tarea.setTitulo("Leo");
            Tarea tareaActualModificada = serviceTarea.modificarTareaPorID(1L, tarea);
            assertEquals("Leo",tareaActualModificada.getTitulo());
        }

        //Tarea modificada no encontrada
        @Test
        void testModifyTarea_whenTareaNotFound(){
            when(repositoryTarea.findById(1L)).thenReturn(Optional.ofNullable(null));
            Tarea tareaActualModificada = serviceTarea.modificarTareaPorID(1L, tarea);
            assertNull(tareaActualModificada);
        }

        //Eliminación de una Tarea
        @Test
        void testDeleteTarea(){
            willDoNothing().given(repositoryTarea).deleteById(1L);
            serviceTarea.borrarTareaPorId(1L);
            verify(repositoryTarea, times(1)).deleteById(1L);
        }

        //Tarea eliminada no encontrada
        @Test
        void testDeleteTarea_whenTareaNotFound(){
            when(repositoryTarea.findById(1L)).thenReturn(Optional.ofNullable(null));
            Tarea tareaActualEliminada = serviceTarea.borrarTareaPorId(1L);
            assertNull(tareaActualEliminada);
        }

    }
