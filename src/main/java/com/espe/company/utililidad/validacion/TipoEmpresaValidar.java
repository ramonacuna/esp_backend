package com.espe.company.utililidad.validacion;

import com.espe.infrastructure.exception.ValidationException;

public class TipoEmpresaValidar {
    private static final  int LONGITUD = 150;

    public TipoEmpresaValidar() {}

    private static void validarNombreVacio(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new ValidationException("Nombre tipo de empresa requerido");
        }
    }

    public static void validarLongitud(String nombre, int maximo) {
        if(nombre.trim().length() > maximo) {
            throw new ValidationException("Longitud superada");
        }
    }

    public static void validarNombre(String nombre) {
        validarNombreVacio(nombre);
        validarLongitud(nombre, LONGITUD);
    }

    public static Short estadoAjustado(Short valorEstado) {
        if(valorEstado == null || valorEstado < 1 || valorEstado > 3) {
            return 1;
        }
        return valorEstado;
    }
}
