
package com.espe.tipos_contratos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class TipoContratoDtoActualizar {
    @NotNull
    private Integer idTipoContrato;
    @NotNull
    @Size(min = 1, max = 150)
    private String nombreTipoContrato;
    
    public TipoContratoDtoActualizar() {
    }

    public TipoContratoDtoActualizar(String nombreTipoContrato, Integer idTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
        this.idTipoContrato = idTipoContrato;
    }
    
}
