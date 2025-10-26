
package com.espe.tipos_contratos.controlador;

import com.espe.infrastructure.utility.response.HttpResponse;
import com.espe.tipos_contratos.dto.TipoContratoDtoCrear;
import com.espe.tipos_contratos.dto.TipoContratoDtoRespuesta;
import com.espe.tipos_contratos.servicio.TipoContratoCrearServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/tipos_contratos-type")
public class TipoContratoControlador {
    private  final TipoContratoCrearServicio tipoContratoCrearServicio;

    public TipoContratoControlador(TipoContratoCrearServicio tipoContratoCrearServicio) {
        this.tipoContratoCrearServicio = tipoContratoCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crearTipoContrato(@RequestBody TipoContratoDtoCrear dto) {
        TipoContratoDtoRespuesta respuesta = tipoContratoCrearServicio.crearTipoContrato(dto);
        return HttpResponse.created("That is working", respuesta);
    }
}
