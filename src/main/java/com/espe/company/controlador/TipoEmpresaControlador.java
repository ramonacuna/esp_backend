package com.espe.company.controlador;

import com.espe.company.dto.TipoEmpresaDtoCrear;
import com.espe.company.dto.TipoEmpresaDtoRespuesta;
import com.espe.company.servicio.TipoEmpresaCrearServicio;
import com.espe.infrastructure.utility.response.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/company-type")
public class TipoEmpresaControlador {
    private  final TipoEmpresaCrearServicio tipoEmpresaCrearServicio;

    public TipoEmpresaControlador(TipoEmpresaCrearServicio tipoEmpresaCrearServicio) {
        this.tipoEmpresaCrearServicio = tipoEmpresaCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crearTipoEmpresa(@RequestBody TipoEmpresaDtoCrear dto) {
        TipoEmpresaDtoRespuesta respuesta = tipoEmpresaCrearServicio.crearTipoEmpresa(dto);
        return HttpResponse.created("That is working", respuesta);
    }
}
