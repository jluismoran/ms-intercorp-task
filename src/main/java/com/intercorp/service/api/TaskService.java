package com.intercorp.service.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.domain.api.TareaRequest;
import com.intercorp.domain.api.TareaResponse;
import com.intercorp.domain.dto.TareaDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@Qualifier("PedidoService")
public class TaskService implements ITaskService {

    private static final Logger logger = LogManager.getLogger(TaskService.class);

    private List<TareaDTO> listTareas = new ArrayList<>();

    @Override
    public TareaResponse getTareas() {
        logger.info("Start - getTareas");
        List<TareaDTO> listTareaDTO = new ArrayList<>();
        listTareaDTO.addAll(getListaTareasJSON());
        TareaResponse tareaResponse = new TareaResponse();
        tareaResponse.setListTareas(listTareaDTO);
        logger.info("End - getTareas");
        return tareaResponse;
    }

    private List<TareaDTO> getListaTareasJSON() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("tasks.json").getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<TareaDTO>>() {});
        }catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void eliminarTarea(Long idTarea) {
        logger.info("Se elimina tarea: "+idTarea);
    }

    @Override
    public TareaResponse guardarTarea(TareaDTO tareaDTO) {
        logger.info("Start - guardarTarea: "+tareaDTO.getDescripcionTarea());
        TareaResponse tareaResponse = new TareaResponse();
        tareaResponse.setTarea(tareaDTO);
        logger.info("End - guardarTarea");
        return tareaResponse;
    }

    public TareaResponse actualizarTarea(Integer idTarea, TareaDTO tareaDTO) {
        logger.info("Start - actualizarTarea: "+tareaDTO.getIdTarea()+"-"+tareaDTO.getDescripcionTarea());
        TareaResponse tareaResponse = new TareaResponse();
        tareaResponse.setTarea(tareaDTO);
        logger.info("End - actualizarTarea");
        return tareaResponse;
    }
}
