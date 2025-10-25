package com.espe.company.servicio;

import com.espe.company.dto.TipoEmpresaDtoCrear;
import com.espe.company.dto.TipoEmpresaDtoRespuesta;
import com.espe.company.entity.TipoEmpresa;
import com.espe.company.repositorio.TipoEmpresaRepositorio;
import com.espe.company.utililidad.mapeador.TipoEmpresaMapeador;
import com.espe.company.utililidad.validacion.TipoEmpresaValidar;
import com.espe.core.crud.CrudOperationImpl;
import com.espe.core.search.SearchService;
import com.espe.infrastructure.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoEmpresaCrearServicio extends CrudOperationImpl<TipoEmpresa, Integer> {

    private final TipoEmpresaRepositorio tipoEmpresaRepositorio;
    private final TipoEmpresaMapeador tipoEmpresaMapeador;

    public TipoEmpresaCrearServicio(TipoEmpresaRepositorio tipoEmpresaRepositorio,
                                    TipoEmpresaMapeador tipoEmpresaMapeador,
                                    SearchService<TipoEmpresa, Integer> searchService) {
        super(searchService);
        this.tipoEmpresaRepositorio = tipoEmpresaRepositorio;
        this.tipoEmpresaMapeador = tipoEmpresaMapeador;
    }

    @Override
    protected JpaRepository<TipoEmpresa, Integer> getRepository() {
        return tipoEmpresaRepositorio;
    }

    private void verificarExistenciaTipoEmpresa(String nombre) {
        Optional<TipoEmpresa> existente = tipoEmpresaRepositorio.findByNombreTipoEmpresaIgnoreCase(nombre);
        if(existente.isPresent()) {
            throw new BusinessException("Ya existe " + nombre);
        }
    }

    public TipoEmpresaDtoRespuesta crearTipoEmpresa(TipoEmpresaDtoCrear dto) {
        String nombreSinEspacios = dto.nombreTipoEmpresa().trim();
        Short estado = TipoEmpresaValidar.estadoAjustado(dto.estadoTipoEmpresa());
        TipoEmpresaValidar.validarNombre(nombreSinEspacios);
        verificarExistenciaTipoEmpresa(nombreSinEspacios);
        TipoEmpresa objetoNuevo = new TipoEmpresa();
        objetoNuevo.setNombreTipoEmpresa(nombreSinEspacios);
        objetoNuevo.setEstadoTipoEmpresa(estado);
        TipoEmpresa registrada = add(objetoNuevo);
        return tipoEmpresaMapeador.fromEntity(registrada);
    }
}
