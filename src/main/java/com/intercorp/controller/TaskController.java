package com.intercorp.controller;

import com.intercorp.domain.api.TareaRequest;
import com.intercorp.domain.api.TareaResponse;
import com.intercorp.domain.dto.TareaDTO;
import com.intercorp.service.api.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    @Qualifier("taskService")
    private ITaskService taskService;

    @GetMapping(value = "/list-tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public TareaResponse listarTareas() {
        return taskService.getTareas();
    }

    @DeleteMapping(value = "/delete-task/{idTarea}")
    public ResponseEntity<Void> eliminarTareas(@PathVariable Long idTarea) {
        taskService.eliminarTarea(idTarea);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/save-task", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TareaResponse guardarTarea(@Validated(TareaDTO.class)
                                       @RequestBody TareaDTO tareaDTO) {
        return taskService.guardarTarea(tareaDTO);
    }

    @PutMapping(value = "/update-task/{idTarea}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TareaResponse actualizarTarea(@PathVariable Integer idTarea,
                                         @Validated(TareaDTO.class) @RequestBody TareaDTO tareaDTO) {
        return taskService.actualizarTarea(idTarea, tareaDTO);
    }

}
