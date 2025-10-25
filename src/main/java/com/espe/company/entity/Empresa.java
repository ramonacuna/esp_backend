package com.espe.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "empresas")
@Entity(name = "empresa_Empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_empresa", nullable = false, unique = true, length = 200)
    private String nombreEmpresa;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion_empresa", nullable = false, unique = true, length = 200)
    private String direccionEmpresa;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "telefono_empresa", nullable = false, unique = true, length = 200)
    private String telefonoEmpresa;

    @JoinColumn(name = "id_tipo_empresa", referencedColumnName = "id_tipo_empresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEmpresa idTipoEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, TipoEmpresa idTipoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public @NotNull @Size(min = 1, max = 200) String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(@NotNull @Size(min = 1, max = 200) String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public @NotNull @Size(min = 1, max = 200) String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(@NotNull @Size(min = 1, max = 200) String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public @NotNull @Size(min = 1, max = 200) String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(@NotNull @Size(min = 1, max = 200) String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public TipoEmpresa getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(TipoEmpresa idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(idEmpresa, empresa.idEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEmpresa);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccionEmpresa='" + direccionEmpresa + '\'' +
                ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
                ", idTipoEmpresa=" + (idTipoEmpresa != null ? idTipoEmpresa.getIdTipoEmpresa() : null) +
                '}';
    }
}
