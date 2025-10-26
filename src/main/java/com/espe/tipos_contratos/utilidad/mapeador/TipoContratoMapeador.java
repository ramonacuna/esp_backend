package com.espe.tipos_contratos.utilidad.mapeador;

import com.espe.infrastructure.utility.mapper.MappingEntityDto;
import com.espe.tipos_contratos.entity.TipoContrato;
import com.espe.tipos_contratos.dto.TipoContratoDtoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class TipoContratoMapeador implements MappingEntityDto<TipoContrato, TipoContratoDtoRespuesta>{
    @Override
    public TipoContratoDtoRespuesta fromEntity(TipoContrato myEntity) {
        if(myEntity == null) {
            return null;
        }
        return new TipoContratoDtoRespuesta(
                myEntity.getIdTipoContrato(),
                myEntity.getNombreTipoContrato());
    }
    
    @Override
    public TipoContrato fromDto(TipoContratoDtoRespuesta myDto) {
        if(myDto == null) {
            return null;
        }
        TipoContrato entidad = new TipoContrato();
        entidad.setIdTipoContrato(myDto.idTipoContrato());
        entidad.setNombreTipoContrato(myDto.nombreTipoContrato());

        return entidad;
    }
}
