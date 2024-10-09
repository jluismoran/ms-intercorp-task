package com.intercorp.domain.api;

import com.intercorp.domain.dto.TareaDTO;
import lombok.Data;

import java.util.List;

@Data
public class TareaResponse {

    private List<TareaDTO> listTareas;
    private TareaDTO tarea;
}
