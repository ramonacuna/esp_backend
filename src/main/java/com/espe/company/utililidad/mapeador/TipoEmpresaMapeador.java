package com.espe.company.utililidad.mapeador;

import com.espe.company.dto.TipoEmpresaDtoRespuesta;
import com.espe.company.entity.TipoEmpresa;
import com.espe.infrastructure.utility.mapper.MappingEntityDto;
import org.springframework.stereotype.Component;

@Component
public class TipoEmpresaMapeador implements MappingEntityDto<TipoEmpresa, TipoEmpresaDtoRespuesta> {
    @Override
    public TipoEmpresaDtoRespuesta fromEntity(TipoEmpresa myEntity) {
        if(myEntity == null) {
            return null;
        }
        return new TipoEmpresaDtoRespuesta(
                myEntity.getIdTipoEmpresa(),
                myEntity.getNombreTipoEmpresa(),
                myEntity.getEstadoTipoEmpresa());
    }


    @Override
    public TipoEmpresa fromDto(TipoEmpresaDtoRespuesta myDto) {
        if(myDto == null) {
            return null;
        }
        TipoEmpresa entidad = new TipoEmpresa();
        entidad.setIdTipoEmpresa(myDto.idTipoEmpresa());
        entidad.setNombreTipoEmpresa(myDto.nombreTipoEmpresa());
        entidad.setEstadoTipoEmpresa(myDto.estadoTipoEmpresa());
        return entidad;
    }
}

