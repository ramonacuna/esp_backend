package com.espe.company.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TipoEmpresaDtoActualizar {
    @NotNull
    private Integer idTipoEmpresa;
    @NotNull
    @Size(min = 1, max = 150)
    private String nombreTipoEmpresa;
    private Short estadoTipoEmpresa;

    public TipoEmpresaDtoActualizar() {
    }

    public TipoEmpresaDtoActualizar(String nombreTipoEmpresa, Short estadoTipoEmpresa, Integer idTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.estadoTipoEmpresa = estadoTipoEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public @NotNull Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(@NotNull Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public @NotNull @Size(min = 1, max = 150) String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(@NotNull @Size(min = 1, max = 150) String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Short getEstadoTipoEmpresa() {
        return estadoTipoEmpresa;
    }

    public void setEstadoTipoEmpresa(Short estadoTipoEmpresa) {
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }
}
