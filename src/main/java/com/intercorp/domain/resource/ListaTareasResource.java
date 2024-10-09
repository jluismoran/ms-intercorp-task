package com.intercorp.domain.resource;

import com.intercorp.domain.dto.TareaDTO;
import lombok.Data;

import java.util.List;

@Data
public class ListaTareasResource {
    private List<TareaDTO> listaTareas;
}
