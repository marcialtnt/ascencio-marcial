package com.codigo.ascenciomarcial.controller;

import com.codigo.ascenciomarcial.entity.EmpresaEntity;
import com.codigo.ascenciomarcial.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/examen/v1/empresa")
@Tag(
        name = "Api de empresas",
        description = "Esta api te permite realizar operaciones sobre las entidades empresa."
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(
            summary = "Permite crear una empresa nueva en la base de datos.",
            description = "Para usar este endPoint debes enviar una objeto empresa, el cual se guardará en la Base de datos previa validación",
            parameters = {
                    @Parameter(name = "empresaEntity", description = "Datos de la empresa")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa registro exitoso.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó de manera exitosa.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST esta malformado.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity) {
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }

    @GetMapping("/buscarxId/{id}")
    @Operation(
            summary = "Permite buscar una empresa existente en la base de datos.",
            description = "Para usar este endPoint debes enviar el id de la empresa, el cual se utilizará para la búsquda.",
            parameters = {
                    @Parameter(name = "id", description = "Id de la empresa")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa que se encontró el registro.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 500 significa que no se encontró el registro.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> buscarxId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarxId(id).get());
    }

    @GetMapping("/buscarAll")
    @Operation(
            summary = "Permite listar todas las empresa existentes en la base de datos.",
            description = "Este endPoint no requiere parámetros."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa que se obtuvo la lista de empresas.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST esta malformado.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTTP STATUS 500 significa que no encontraron datos.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<EmpresaEntity>> BuscarAll() {
        return ResponseEntity.ok(empresaService.buscarAll());
    }

    @PutMapping("/actualizar/{id}")
    @Operation(
            summary = "Permite actualizar los datos de una empresa existente en la base de datos.",
            description = "Este endPoint requiere el id de la empresa y los datos a actualizar."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa que realizaó la operación exito.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST esta malformado.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTTP STATUS 500 significa que no encontró la empresa.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity) {
        return ResponseEntity.ok(empresaService.actualizar(id, empresaEntity));
    }

    @DeleteMapping("/borrar/{id}")
    @Operation(
            summary = "Permite el eliminado lógico de una empresa existente en la base de datos.",
            description = "Este endPoint requiere el id de la empresa a eliminar."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa que realizaó la operación exito.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST esta malformado.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTTP STATUS 500 significa que no encontró la empresa.",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> borrar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}
