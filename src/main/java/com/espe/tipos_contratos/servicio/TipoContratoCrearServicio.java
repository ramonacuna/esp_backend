
package com.espe.tipos_contratos.servicio;

import com.espe.core.crud.CrudOperationImpl;
import com.espe.core.search.SearchService;
import com.espe.infrastructure.exception.BusinessException;
import com.espe.tipos_contratos.dto.TipoContratoDtoCrear;
import com.espe.tipos_contratos.dto.TipoContratoDtoRespuesta;
import com.espe.tipos_contratos.entity.TipoContrato;
import com.espe.tipos_contratos.repositorio.TipoContratoRepositorio;
import com.espe.tipos_contratos.utilidad.mapeador.TipoContratoMapeador;
import com.espe.tipos_contratos.utilidad.validacion.TipoContratoValidar;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoContratoCrearServicio extends CrudOperationImpl<TipoContrato, Integer> {
    
        private final TipoContratoRepositorio tipoContratoRepositorio;
        private final TipoContratoMapeador tipoContratoMapeador;
        
public TipoContratoCrearServicio(TipoContratoRepositorio tipoContratoRepositorio,
                                    TipoContratoMapeador tipoContratoMapeador,
                                    SearchService<TipoContrato, Integer> searchService) {
        super(searchService);
        this.tipoContratoRepositorio = tipoContratoRepositorio;
        this.tipoContratoMapeador = tipoContratoMapeador;
    }

    @Override
    protected JpaRepository<TipoContrato, Integer> getRepository() {
        return tipoContratoRepositorio;
    }
    
    private void verificarExistenciaTipoContrato(String nombre) {
        Optional<TipoContrato> existente = tipoContratoRepositorio.findByNombreTipoContratoIgnoreCase(nombre);
        if(existente.isPresent()) {
            throw new BusinessException("Ya existe " + nombre);
        }
    }
    
    public TipoContratoDtoRespuesta crearTipoContrato(TipoContratoDtoCrear dto) {
        String nombreSinEspacios = dto.nombreTipoContrato().trim();
        TipoContratoValidar.validarNombre(nombreSinEspacios);
        verificarExistenciaTipoContrato(nombreSinEspacios);
        TipoContrato objetoNuevo = new TipoContrato();
        objetoNuevo.setNombreTipoContrato(nombreSinEspacios);
        TipoContrato registrada = add(objetoNuevo);
        return tipoContratoMapeador.fromEntity(registrada);
    }
        
}
