package com.intercorp.service.api;

import com.intercorp.domain.api.TareaRequest;
import com.intercorp.domain.api.TareaResponse;
import com.intercorp.domain.dto.TareaDTO;

public interface ITaskService {

    TareaResponse getTareas();
    void eliminarTarea(Long idTarea);
    TareaResponse guardarTarea(TareaDTO tareaDTO);
    TareaResponse actualizarTarea(Integer idTarea, TareaDTO tareaDTO);

}
