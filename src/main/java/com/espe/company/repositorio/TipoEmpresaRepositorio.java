package com.espe.company.repositorio;

import com.espe.company.entity.TipoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("empresa_TipoEmpresaRepositorio")
public interface TipoEmpresaRepositorio extends JpaRepository<TipoEmpresa, Integer> {
    Optional<TipoEmpresa> findByNombreTipoEmpresaIgnoreCase(String nombre);
}
