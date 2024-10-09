package com.intercorp.domain.dto;

import lombok.Data;

@Data
public class TareaDTO {
    private Integer idTarea;
    private String descripcionTarea;
    private String nombreColaborador;
    private String fechaHoraInicio;
    private String fechaHoraFin;
}
