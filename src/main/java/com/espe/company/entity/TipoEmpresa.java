package com.espe.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "tipo_empresas", indexes = @Index(name = "idx_nombre_tipo_empresa",
        columnList = "nombre_tipo_empresa"))
@Entity(name = "empresa_TipoEmpresa")
public class TipoEmpresa implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_empresa")
    private Integer idTipoEmpresa;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_tipo_empresa", nullable = false, unique = true, length = 150)
    private String nombreTipoEmpresa;

    @NotNull
    @Column(name = "estado_tipo_empresa", nullable = false, unique = true)
    private Short estadoTipoEmpresa;

    public TipoEmpresa() {
    }

    public TipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public TipoEmpresa(String nombreTipoEmpresa, Integer idTipoEmpresa, Short estadoTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public @NotNull @Size(min = 1, max = 150) String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(@NotNull @Size(min = 1, max = 150) String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public @NotNull Short getEstadoTipoEmpresa() {
        return estadoTipoEmpresa;
    }

    public void setEstadoTipoEmpresa(@NotNull Short estadoTipoEmpresa) {
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoEmpresa that = (TipoEmpresa) o;
        return Objects.equals(idTipoEmpresa, that.idTipoEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTipoEmpresa);
    }

    @Override
    public String toString() {
        return "TipoEmpresa{" +
                "idTipoEmpresa=" + idTipoEmpresa +
                ", nombreTipoEmpresa='" + nombreTipoEmpresa + '\'' +
                ", estadoTipoEmpresa=" + estadoTipoEmpresa +
                '}';
    }
}
